package bible.lachiesa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.jdom2.Element;
import org.jsoup.nodes.Document;

public class Book
{
	private ArrayList<Chapter> chapters;
	private String title;
	private Properties libriMap;
	private Properties doppiMap;
	private String fileName;
	public static Logger log;
	private String swordAcronym, htmlRegex;
	private boolean notNow;
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
		htmlRegex = "^.*<sup>.*</sup>";
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

	public void load(String bookDir, String acronym)
	{
		BufferedReader br = null;
		String line = null;
		String page = null;
		String temp = null;
		Chapter chapter = null;
		int lines = 0, i = 0;
		int numFiles = new File(bookDir).list().length;
		for(int j = 1; j < numFiles; j++)
		{
			String chapFile = bookDir + "/" + acronym + "." + j;
			try
			{
				chapter = new Chapter(++i);
				log.info("Capitolo " + i);
				int verseNumber = 0;
				lines = 0;
				br = new BufferedReader(new InputStreamReader(new FileInputStream(chapFile),
				    "ISO-8859-1"));
				log.debug(page);
				while(br.ready())
				{
					line = br.readLine();
					if(line != null)
					{
						line = line.trim();
						lines++;
						log.debug("Riga " + lines + "(" + line.trim() + ")");
						if(line.contains("<sup>"))
						{
							temp = "";
							if(line.contains("a</sup>"))
							{
								notNow = true;
							}
							line = line.replaceAll(htmlRegex, "");
							line = line.replaceAll("<p[^>]*>", "\n");
							line = line.replaceAll("<br>$", "\n");
							line = line.replaceAll("<br>", "\n");
							line = line.replaceAll("^<p>", "");
							line = line.replaceAll("<p>", "\n");
							line = line.replaceAll("</p>", "");
							line = line.replaceAll("<i>", "");
							line = line.replaceAll("</i>", "");
							String osisID = swordAcronym;
							osisID += "." + i;
							if(notNow)
							{
								temp = line.trim();
								notNow = false;
							}
							else
							{
								osisID += "." + ++verseNumber;
								log.info("Versetto " + osisID);
								chapter.addVerse(temp + line.trim(), verseNumber);
							}
						}
						if(line.endsWith("<br><dd><br><dd>$")) break;
					}
					else
					{
						break;
					}
				}
				br.close();
			}
			catch(MalformedURLException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				log.warn("Problema di I/O: " + e.getMessage());
			}
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
		Element book = new Element("div");
		book.setAttribute("type", "book");
		book.setAttribute("osisID", swordAcronym);
		while(citer.hasNext())
		{
			chap = citer.next();
			book.addContent(chap.toOsis(swordAcronym));
		}
		return book;
	}

	public void setAcronym(String key)
	{
		swordAcronym = key;
	}

	public void setParaCapitolo(String pc)
	{
	}
}
