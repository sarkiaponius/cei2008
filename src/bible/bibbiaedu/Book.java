package bible.bibbiaedu;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;

import nl.siegmann.epublib.domain.Resources;

import org.apache.log4j.Logger;
import org.jdom2.Element;
import org.jsoup.nodes.Document;
import org.w3c.css.sac.InputSource;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSRuleList;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSStyleRule;
import org.w3c.dom.css.CSSStyleSheet;

import com.steadystate.css.parser.CSSOMParser;

public class Book
{
	private ArrayList<Chapter> chapters;
	private String title;
	private Properties libriMap;
	private Properties doppiMap;
	private String fileName;
	public static Logger log;
	private nl.siegmann.epublib.domain.Book epub = null;
	private String swordAcronym, htmlRegex;
	private String paraCapitolo;

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
		htmlRegex = "<sup>.*</sup>(</font>)*";
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

	public HashSet<String> getVerseMarkers()
	{
		CSSOMParser parser;
		InputSource is;
		CSSStyleSheet css;
		CSSRuleList cssRules;
		CSSRule rule;
		CSSStyleRule styleRule;
		HashSet<String> verseMarkers = null;
		String selector, property, value;
		Resources res;

		try
		{
			res = epub.getResources();
			res.getByHref("Styles/style.css").getReader();

			/*
			 * crea un parser CSS e si predispone a scorrere il CSS di questo libro
			 * alla ricerca di classi con font-size plausibili come numeri di
			 * versetto, e a metterle via in contenitore
			 */

			parser = new CSSOMParser();
			is = new InputSource(res.getByHref("Styles/style.css").getReader());
			css = parser.parseStyleSheet(is, null, null);
			cssRules = css.getCssRules();
			verseMarkers = new HashSet<String>();

			/*
			 * ora che ha la lista di tutte le regole del CSS, le scorre esaminando
			 * solo quelle che iniziano con "*.t" e che hanno font-size=.65em
			 */

			for(int i = 0; i < cssRules.getLength(); i++)
			{
				rule = cssRules.item(i);
				if(rule instanceof CSSStyleRule)
				{
					styleRule = (CSSStyleRule) rule;
					selector = styleRule.getSelectorText();
					if(selector.startsWith("*.t"))
					{
						CSSStyleDeclaration styleDeclaration = styleRule.getStyle();

						for(int j = 0; j < styleDeclaration.getLength(); j++)
						{
							property = styleDeclaration.item(j);
							value = styleDeclaration.getPropertyCSSValue(property)
							    .getCssText();
							if(property.equals("font-size") && value.equals("0.65em"))
							{
								verseMarkers.add(selector);
							}
						}
					}
				}
			}
		}
		catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return verseMarkers;
	}

	public void load(String bookDir, String acronym)
	{
		URL url = null;
		URLConnection uconn = null;
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
				boolean removeFirst = false;
				lines = 0;
				InputStream is = null;
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
						if(line.startsWith("<sup><a"))
						{
							temp = "";
							line = line.replaceAll(htmlRegex, "");
							line = line.replaceAll("<br><dd><br><dd>.*<br><dd></b></font>",
							    "");
							line = line.replaceAll("<br><dd> *<br><dd>$", "");
							line = line.replaceAll("<br><dd> *<br><dd>", "\n");
							line = line.replaceAll("<br><dd>$", "");
							line = line.replaceAll("<br><dd>", "\n");
							String osisID = swordAcronym;
							osisID += "." + i;
							osisID += "." + ++verseNumber;
							log.info("Versetto " + osisID);
							if(doppiMap.getProperty(osisID) == "0")
							{
								temp = line.trim();
								removeFirst = false;
							}
							else if(doppiMap.getProperty(osisID) == "1")
							{
								temp = line.trim().substring(1);
								removeFirst = true;
							}
							else
							{
								if(removeFirst)
								{
									chapter
									    .addVerse(temp + line.trim().substring(1), verseNumber);
								}
								else
								{
									chapter.addVerse(temp + line.trim(), verseNumber);
								}
								temp = "";
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
		paraCapitolo = pc;
	}
}
