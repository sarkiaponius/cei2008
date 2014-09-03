package bible.tilc;

import java.io.BufferedReader;
import java.io.CharConversionException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;

import nl.siegmann.epublib.domain.Resources;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;
import org.jsoup.Jsoup;
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
	private String swordAcronym;

	public Book()
	{
		super();
		libriMap = new Properties();
		try
		{
			libriMap.load(new FileReader("libri.map"));
			initLogger();
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
	}

	// inizializza il logger

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
		wa = new WriterAppender(pl, System.out);
		log.addAppender(wa);
		// BasicConfigurator.configure(wa);
	}

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
		int chapCount = 0;
		URL url = null;
		BufferedReader br = null;
		InputStreamReader isr = null;
		String line;
		Chapter chapter = null;
		try
		{
			url = new URL(u);
			isr = new InputStreamReader(url.openStream(), "ISO-8859-1");
			br = new BufferedReader(isr);
			while(br.ready())
			{
				line = br.readLine();
				if(line.contains("Leggi questo Capitolo"))
				{
					chapCount++;
				}
			}
		}
		catch(MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			System.err.println("Problema di I/O: " + e.getMessage());
		}
		for(int i = 1; i <= chapCount; i++)
		{
			try
			{
				chapter = new Chapter(i);
				url = new URL(u + "&capl=" + i);
				isr = new InputStreamReader(url.openStream(), "ISO-8859-1");
				br = new BufferedReader(isr);
				int verseNumber = 0;
				while(br.ready())
				{
					line = br.readLine().trim();
					if(line.startsWith("<sup><i>"))
					{
						line = line.replaceAll("<sup><i>[-0-9]+</i></sup> *", "");
						line = line.replaceAll("<br><br>.*<br>", "");
						line = line.replaceAll("(<br>)+$", "");
						line = line.replaceAll("(<br>)+", "\n");
						chapter.addVerse(line, verseNumber++);
					}
				}
			}
			catch(MalformedURLException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				System.err.println("Problema di I/O: " + e.getMessage());
			}
			addChapter(chapter);
//			System.err.println(chapter.toImp(swordAcronym));
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

	public void setAcronym(String key)
	{
		swordAcronym = key;
	}
}
