package bible;

import java.io.FileNotFoundException;
import com.steadystate.css.parser.CSSOMParser;
import com.sun.corba.se.pept.transport.InboundConnectionCache;

import org.w3c.css.sac.InputSource;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSRuleList;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSStyleRule;
import org.w3c.dom.css.CSSStyleSheet;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.domain.Resources;
import nl.siegmann.epublib.domain.SpineReference;
import nl.siegmann.epublib.epub.EpubReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Book
{
	private ArrayList<Chapter> chapters;
	private String title;
	private Properties libriMap;
	private String fileName;
	private nl.siegmann.epublib.domain.Book epub = null;
	private String swordAcronym;

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

	public void addChapter(Document d, HashSet<String> verseMarkers, int number)
	{
		chapters.add(new Chapter(d, verseMarkers, number));
	}

	public Iterator<Chapter> getChapters()
	{
		return chapters.iterator();
	}

	public HashSet<String> getVerseMarkers()
	{
		CSSOMParser parser;
		FileReader fr;
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
 * crea un parser CSS e si predispone a scorrere il CSS di questo libro alla
 * ricerca di classi con font-size plausibili come numeri di versetto, e a
 * metterle via in contenitore
 */

			parser = new CSSOMParser();
			is = new InputSource(res.getByHref("Styles/style.css").getReader());
			css = parser.parseStyleSheet(is, null, null);
			cssRules = css.getCssRules();
			verseMarkers = new HashSet<String>();

/*
 * ora che ha la lista di tutte le regole del CSS, le scorre esaminando solo
 * quelle che iniziano con "*.t" e che hanno font-size=.65em
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
		EpubReader er = new EpubReader();
		Iterator<SpineReference> ir = null;
		try
		{
			URL url = new URL(u);
			String qString = url.getFile();
			String fileName = qString.replaceAll(".*/", "");
			setBaseName(fileName.split("\\.")[0]);
			InputStream in = url.openStream();
			epub = er.readEpub(in);
			in.close();
			System.err.println(epub.getTitle());
			setTitle(libriMap.getProperty(getBaseName()));
			ir = epub.getSpine().getSpineReferences().iterator();
		}
		catch(MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			System.err.println("Problema di I/O: " + e.getMessage());
		}
		int chaps = -3;
		while(ir.hasNext())
		{
			Resource res = ir.next().getResource();
			String text = null;
			if(++chaps > 0)
			{
				try
				{
					text = new String(res.getData());
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				Document doc = Jsoup.parse(text);
				addChapter(doc, getVerseMarkers(), chaps);
			}
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
		String imp = "";
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