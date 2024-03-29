package bible;

//import java.io.BufferedReader;
import java.io.File;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jsoup.nodes.Document;


public class Book
{
	private ArrayList<Chapter> chapters;
	private String title;
	private Properties libriMap;
	private Properties doppiMap;
	private String fileName;
	public static Logger log;
	private String swordAcronym;
//	private String htmlRegex;
//	private boolean notNow;
	public Book()
	{
		super();
		libriMap = new Properties();
		doppiMap = new Properties();
		try
		{
			libriMap.load(new FileReader("libri.map"));
			doppiMap.load(new FileReader("doppi.map"));
		}
		catch(FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		chapters = new ArrayList<Chapter>();
//		htmlRegex = "^.*<sup>.*</sup>";
		log = Logger.getLogger("COMPARC");
		// log.setLevel(Level.INFO);
	}

	// inizializza il logger
	public void setTitle(String t)
	{
		title = new String(t);
	}

	public String getTitle()
	{
		return title;
	}

	public void addChapter(Chapter c)
	{
		chapters.add(c);
	}

	public void addChapter(Document d, int number)
	{
		chapters.add(new Chapter(d, number));
	}

	public Iterator<Chapter> getChapters()
	{
		return chapters.iterator();
	}

	public void load(String bookDir, String acronym) throws MalformedURLException
	{
//		BufferedReader br = null;
//		String line = null;
//		String page = null;
//		String temp = null;
		Chapter chapter = null;
//		int lines = 0, i = 0;
		int i = 0;
		int numFiles = new File(bookDir).list().length;
		log.info("Caricamento libro " + acronym + " dalla directory " + bookDir + "("+ numFiles +" file)");
		for(int j = 1; j < numFiles; j++)
		{
			String chapFile = bookDir + "/" + acronym + "." + j;
//			String tempVerseRef = "0";
			chapter = new Chapter(++i);
			chapter.setSwordAcronym(swordAcronym + "." + i);
			log.info("Segue chiamata a chapter.load("+ chapFile +")...");
			chapter.load(chapFile, acronym);
//				log.info("Capitolo " + i);
//				int verseNumber = 0;
//				lines = 0;
//				br = new BufferedReader(new InputStreamReader(new FileInputStream(chapFile),
//				    "ISO-8859-1"));
//				log.debug(page);
//				while(br.ready())
//				{
//					line = br.readLine();
//					if(line != null)
//					{
//						line = line.trim();
//						lines++;
//						log.debug("Riga " + lines + "(" + line.trim() + ")");
//						if(line.contains("<sup>"))
//						{
//							temp = "";
//							String osisID = swordAcronym;
//							osisID += "." + i;
//							String verseRef = line.replaceAll("^.*<sup>", "");
//							verseRef = verseRef.replaceAll("</sup>.*$", "");
//							log.info("Versetto sorgente: " + verseRef);
//							if(line.contains("a</sup>"))
//							{
//								log.warn(osisID + ", numero versetto anomalo: " + verseRef);
//								notNow = true;
//							}
//							if(tempVerseRef.equals(verseRef))
//							{
//								log.warn(osisID + ", numero versetto duplicato: " + verseRef);
//							}
//							tempVerseRef = new String(verseRef);
//							line = line.replaceAll(htmlRegex, "");
//							line = line.replaceAll("<p[^>]*>", "\n");
//							line = line.replaceAll("<br>$", "\n");
//							line = line.replaceAll("<br>", "\n");
//							line = line.replaceAll("^<p>", "");
//							line = line.replaceAll("<p>", "\n");
//							line = line.replaceAll("</p>", "");
//							line = line.replaceAll("<i>", "");
//							line = line.replaceAll("</i>", "");
//							if(notNow)
//							{
//								temp = line.trim();
//								notNow = false;
//							}
//							else
//							{
//								osisID += "." + ++verseNumber;
//								log.info("Versetto " + osisID);
//								chapter.addVerse(temp + line.trim(), verseNumber);
//							}
//						}
//						if(line.endsWith("<br><dd><br><dd>$")) break;
//					}
//					else
//					{
//						break;
//					}
//				}
//				br.close();
			addChapter(chapter);
		}
	}

	public String getBaseName()
	{
		return fileName;
	}

	public void setBaseName(String fileName)
	{
		this.fileName = fileName;
	}

	public Element toOsis()
	{
		Iterator<Chapter> citer = getChapters();
		Chapter chap;
		Namespace def = Namespace.getNamespace("http://www.bibletechnologies.net/2003/OSIS/namespace");
		Element book = new Element("div", def);
		book.setAttribute("type", "book");
		book.setAttribute("osisID", swordAcronym);
		while(citer.hasNext())
		{
			chap = citer.next();
			book.addContent(chap.toOsis(swordAcronym));
		}
		return book;
	}
	
	public String toImp()
	{
		String imp = "$$$" + swordAcronym + " 0:0\n\n";
		Iterator<Chapter> citer = getChapters();
		Chapter chap;
		while(citer.hasNext())
		{
			chap = citer.next();
			imp += chap.toImp(swordAcronym);
		}
		return imp;
	}


	public void setAcronym(String key)
	{
		swordAcronym = key;
	}

	public String getAcronym()
	{
		return swordAcronym;
	}

	public void setParaCapitolo(String pc)
	{
	}
}
