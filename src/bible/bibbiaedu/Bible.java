package bible.bibbiaedu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;

import osis.DivCT;
import osis.ObjectFactory;
import osis.OsisCT;
import osis.OsisTextCT;

import bible.bibbiaedu.Book;

public class Bible
{
	private ArrayList<Book> ot;
	private ArrayList<Book> nt;
	private Properties swordMap;
	private Properties config;
	private String baseUrl;
	private String paraLibro;
	private String paraCapitolo;
	public Logger log;
	private static String logLayout = "%05r %p %C{1}.%M - %m%n";


	private void initLogger() throws FileNotFoundException
	{
		// logger generico
		log = Logger.getLogger("COMPARC");
		log.setLevel(Level.INFO);
		PatternLayout pl = new PatternLayout(logLayout);
		File lf = new File("log");
		PrintWriter pw = new PrintWriter(lf);
		WriterAppender wa = new WriterAppender(pl, pw);
		log.addAppender(wa);
//		wa = new WriterAppender(pl, System.out);
//		log.addAppender(wa);
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
		paraLibro = config.getProperty("tilc.para.libro");
		paraCapitolo = config.getProperty("tilc.para.capitolo");
		ot = new ArrayList<Book>();
		nt = new ArrayList<Book>();

	}

	public void load()
	{
		BufferedReader br;
		String acronym, url;
		Book book = null;
		try
		{
			br = new BufferedReader(new FileReader(config.getProperty("sword.ot")));
			while(br.ready())
			{
				acronym = br.readLine();
				if(!acronym.startsWith("#"))
				{
					book = new Book();
					book.setAcronym(acronym);
					book.setParaCapitolo(paraCapitolo);
					System.err.println(acronym);
					url = baseUrl + paraLibro + "=" + swordMap.getProperty(acronym);
					System.err.println(url);
					book.load(url);
					ot.add(book);
				}
			}
			br = new BufferedReader(new FileReader(config.getProperty("sword.nt")));
			while(br.ready())
			{
				acronym = br.readLine();
				if(!acronym.startsWith("#"))
				{
					book = new Book();
					book.setAcronym(acronym);
					book.setParaCapitolo(paraCapitolo);
					System.err.println(acronym);
					url = baseUrl + paraLibro + "=" + swordMap.getProperty(acronym);
					System.err.println(url);
					book.load(url);
					nt.add(book);
					wait(2);
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

	public String toImp()
	{
		String imp = "$$$[ Module Heading ]\n\n";
		imp += "$$$[ Testament 1 Heading ]\n\n";
		Iterator<Book> ir;
		ir = ot.iterator();
		while(ir.hasNext())
		{
			imp += ir.next().toImp();
		}
		imp += "\n$$$[ Testament 2 Heading ]\n\n";
		ir = nt.iterator();
		while(ir.hasNext())
		{
			imp += ir.next().toImp();
		}
		return imp;
	}

	public OsisCT toOsis()
	{
		osis.ObjectFactory objF = new ObjectFactory();
		OsisCT osisCT = objF.createOsisCT();
		OsisTextCT osisText = objF.createOsisTextCT();
		osisCT.setOsisText(osisText);
		DivCT testament = objF.createDivCT();
		testament.setType("x-testament");
		osisText.getDiv().add(testament);
		Iterator<Book> ir;
		ir = ot.iterator();
		while(ir.hasNext())
		{
			testament.getContent().addAll(ir.next().toOsis().getContent());
		}
		testament = new DivCT();
		testament.setType("x-testament");
		osisText.getDiv().add(testament);
		ir = nt.iterator();
		while(ir.hasNext())
		{
			testament.getContent().addAll(ir.next().toOsis().getContent());
		}
		return osisCT;
	}

	public void toImp(String file) throws FileNotFoundException
	{
		PrintWriter pw = new PrintWriter(file);
		pw.println(toImp());
		pw.close();
	}
	
	private void wait(int seconds)
	{
		try
		{
			Thread.sleep(1000 * seconds);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}
}