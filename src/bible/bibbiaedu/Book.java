package bible.bibbiaedu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;

import nl.siegmann.epublib.domain.Resources;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;
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
	private String fileName;
	public Logger log;
	private static String logLayout = "%05r %p %C{1}.%M - %m%n";
	private nl.siegmann.epublib.domain.Book epub = null;
	private String swordAcronym, htmlRegex;
	private String paraCapitolo;

	public Book()
	{
		super();
		libriMap = new Properties();
		try
		{
			libriMap.load(new FileReader("libri.map"));
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
		log.setLevel(Level.INFO);
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

	public void load(String u)
	{
		URL url = null;
		URLConnection uconn = null;
		BufferedReader br = null;
		InputStreamReader isr = null;
		String line = null;
		Chapter chapter = null;
		int lines = 0, i = 0;
		do
		{
			try
			{
				chapter = new Chapter(++i);
				url = new URL(u + "&" + paraCapitolo + "=" + i);
				uconn = url.openConnection();
				uconn.getConnectTimeout();
				log.info(u + "&" + paraCapitolo + "=" + i);
				isr = new InputStreamReader(uconn.getInputStream(), "ISO-8859-1");
//				isr = new InputStreamReader(uconn.getInputStream());
				br = new BufferedReader(isr);
				int verseNumber = 0;
				lines = 0;
				while(br.ready())
				{
					line = br.readLine();
					log.info("Elaboro capitolo " + i + "(" + line.trim());
					log.debug(line);
					line = line.trim();
					lines++;
					// System.err.println(line);
					if(line.startsWith("<sup><a"))
					{
						line = line.replaceAll(htmlRegex, "");
						line = line.replaceAll("<br><dd><br><dd>.*<br><dd></b></font>", "");
						line = line.replaceAll("<br><dd> *<br><dd>$", "");
						line = line.replaceAll("<br><dd> *<br><dd>", "\n");
						line = line.replaceAll("<br><dd>$", "");
						line = line.replaceAll("<br><dd>", "\n");
						chapter.addVerse(line.trim(), ++verseNumber);
					}
					if(line.endsWith("<br><dd><br><dd>$"))
						break;
					if(line.contains("Attenzione"))
						break;
				}
				br.close();
				if(line.contains("Attenzione"))
					break;
			}
			catch(MalformedURLException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				System.err.println("Problema di I/O: " + e.getMessage());
			}
			log.info(lines);
			addChapter(chapter);
			// wait(1);
		}
		while(!line.contains("Attenzione"));
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

	public void setAcronym(String key)
	{
		swordAcronym = key;
	}

	public void setParaCapitolo(String pc)
	{
		paraCapitolo = pc;
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
