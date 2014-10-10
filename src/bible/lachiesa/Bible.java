package bible.lachiesa;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;
import org.jdom2.DocType;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;

public class Bible
{
	private ArrayList<Book> ot;
	private ArrayList<Book> nt;
	private Properties swordMap;
	private Properties config;
	private String baseUrl;
	private String bibleDir;
	public static Logger log;
	private static String logLayout = "%05r %p %C{1}.%M - %m%n";
	private boolean toDownLoad = false;

	public boolean isToDownLoad()
	{
		return toDownLoad;
	}

	private void initLogger() throws FileNotFoundException
	{
		// logger generico
		log = Logger.getLogger("COMPARC");
		log.removeAllAppenders();
		log.setLevel(Level.INFO);
		PatternLayout pl = new PatternLayout(logLayout);
		File lf = new File("log");
		PrintWriter pw = new PrintWriter(lf);
		WriterAppender wa = new WriterAppender(pl, pw);
		log.addAppender(wa);
		wa = new WriterAppender(pl, System.out);
		log.addAppender(wa);
		// BasicConfigurator.configure(wa);
	}

	public Bible()
	{
		config = new Properties();
		try
		{
			config.load(new FileReader("bible.conf"));
			initLogger();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		swordMap = new Properties();
		try
		{
			swordMap.load(new FileReader(config.getProperty("sword.tilc.map")));
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		baseUrl = config.getProperty("tilc.baseurl");
		config.getProperty("tilc.para.libro");
		config.getProperty("tilc.para.capitolo");
		ot = new ArrayList<Book>();
		nt = new ArrayList<Book>();
		bibleDir = config.getProperty("bible.dir");
		if(config.getProperty("bible.download").equals("true"))
		{
			toDownLoad = true;
		}
		new File(bibleDir).mkdirs();
	}

	public void load()
	{
		BufferedReader[] tReaderArray = null;
		try
		{
			tReaderArray = new BufferedReader[2];
			String ot = config.getProperty("sword.ot");
			String nt = config.getProperty("sword.nt");
			tReaderArray[0] = new BufferedReader(new FileReader(ot));
			tReaderArray[1] = new BufferedReader(new FileReader(nt));
		}
		catch(FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		try
		{
			for(int i = 0; i < 2; i++)
			{
				BufferedReader tReader = tReaderArray[i];
				while(tReader.ready())
				{
					try
					{
						String acronym = tReader.readLine();
						String bookDir = bibleDir + "/" + acronym;
						Book book = new Book();
						book.setAcronym(acronym);
						book.load(bookDir, acronym);
						if(i == 0)
						{
							ot.add(book);
						}
						else
						{
							nt.add(book);
						}
					}
					catch(Exception e)
					{

					}
				}
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public Document toOsis()
	{
		Iterator<Book> ir;
		ir = ot.iterator();
		Document doc = new Document();
		doc.setBaseURI("http://www.bibletechnologies.net/2003/OSIS/namespace");
		Element osis = new Element("osis");
		Namespace def = Namespace.getNamespace("http://www.bibletechnologies.net/2003/OSIS/namespace");
		Namespace xsi = Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
		osis.setNamespace(def);
		osis.addNamespaceDeclaration(xsi);
		String schemaLocation = "http://www.bibletechnologies.net/2003/OSIS/namespace";
		schemaLocation += " http://www.bibletechnologies.net/osisCore.2.1.1.xsd";
		osis.setAttribute("schemaLocation", schemaLocation, xsi);
		doc.setRootElement(osis);
		Element osisText = new Element("osisText");
		osisText.setNamespace(def);
		osisText.setAttribute("osisIDWork", "CEI");
		osisText.setAttribute("lang", "it", Namespace.XML_NAMESPACE);
		osis.addContent(osisText);
		Element header = new Element("header", def);
		osisText.addContent(header);
		Element work = new Element("work", def);
		header.addContent(work);
		work.setAttribute("osisWork", "CEI");
		Element title = new Element("title", def);
		work.addContent(title);
		title.addContent("Bibbia CEI 2008");
		Element identifier = new Element("identifier", def);
		identifier.setText("Bible.CEI");
		work.addContent(identifier);
		Element refSystem = new Element("refSystem", def);
		refSystem.setText("Bible.Catholic");
		work.addContent(refSystem);
		work = new Element("work", def);
		header.addContent(work);
		work.setAttribute("osisWork", "defaultReferenceScheme");
		refSystem = new Element("refSystem", def);
		refSystem.setText("Bible.Catholic");
		work.addContent(refSystem);
		Element testament = new Element("div");
		testament.setAttribute("type", "x-testament");
		testament.setNamespace(def);
		osisText.addContent(testament);
		while(ir.hasNext())
		{
			Element book = ir.next().toOsis();
			testament.addContent(book);
		}
		testament = new Element("div", def);
		testament.setAttribute("type", "x-testament");
		osisText.addContent(testament);
		ir = nt.iterator();
		while(ir.hasNext())
		{
			Element book = ir.next().toOsis();
			testament.addContent(book);
		}
		return doc;
	}

	public void download()
	{
		BufferedReader[] tReaderArray = null;
		try
		{
			tReaderArray = new BufferedReader[2];
			String ot = config.getProperty("sword.ot");
			String nt = config.getProperty("sword.nt");
			tReaderArray[0] = new BufferedReader(new FileReader(ot));
			tReaderArray[1] = new BufferedReader(new FileReader(nt));
		}
		catch(FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		try
		{
			for(int i = 0; i < 2; i++)
			{
				BufferedReader tReader = tReaderArray[i];
				while(tReader.ready())
				{
					try
					{
						String acronym = tReader.readLine();
						if(!acronym.startsWith("#"))
						{
							int j = 0;
							String page = "";
							String bookDir = bibleDir + "/" + acronym;
							new File(bookDir).mkdirs();
							while(!page.contains("e la ricerca non ha dato risultati"))
							{
								String url = baseUrl + swordMap.getProperty(acronym) + "+"
								    + ++j;
								URLConnection uconn = new URL(url).openConnection();
								uconn.getConnectTimeout();
								log.info("Downloading " + acronym + "." + j);
//								log.info("... from " + url);
								String chapFile = bookDir + "/" + acronym + "." + j;
								page = downloadChapter(uconn.getInputStream(), chapFile);
							}
						}
					}
					catch(MalformedURLException e)
					{
						e.printStackTrace();
					}
					catch(IOException e)
					{
						log.warn("Problema di I/O: " + e.getMessage());
					}
				}
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	private String downloadChapter(InputStream is, String fileName)
	{
		ByteArrayOutputStream os = null;
		FileOutputStream fos = null;
		try
		{
			fos = new FileOutputStream(fileName);
		}
		catch(FileNotFoundException e1)
		{
		}
		try
		{
			byte[] chunk = new byte[4096];
			int bytesRead;
			os = new ByteArrayOutputStream();
			while((bytesRead = is.read(chunk)) > 0)
			{
				os.write(chunk, 0, bytesRead);
				fos.write(chunk, 0, bytesRead);
			}
			fos.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return os.toString();
	}
	
	public String toImp()
	{
		String imp = "$$$[ Module Heading ]\n\n";
		Book book = null;
		imp += "$$$[ Testament 1 Heading ]\n\n";
		Iterator<Book> ir;
		ir = ot.iterator();
		log.info("Inizio scarico IMP OT...");
		while(ir.hasNext())
		{
			book = ir.next();
			log.info("Libro " + book.getAcronym());
			imp += book.toImp();
		}
		imp += "\n$$$[ Testament 2 Heading ]\n\n";
		ir = nt.iterator();
		log.info("Inizio scarico IMP NT...");
		while(ir.hasNext())
		{
			book = ir.next();
			log.info("Libro " + book.getAcronym());
			imp += book.toImp();
		}
		return imp;
	}
}