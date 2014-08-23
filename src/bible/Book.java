package bible;

import java.io.FileNotFoundException;
import com.steadystate.css.parser.CSSOMParser;

import org.w3c.css.sac.InputSource;
import org.w3c.dom.css.CSSStyleDeclaration;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import nl.siegmann.epublib.domain.Resource;
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
	private String verseSpanClass;

	public Book()
	{
		super();
		libriMap = new Properties();
		try
		{
			libriMap.load(new FileReader("libri.map"));
		} catch(FileNotFoundException e1)
		{
			e1.printStackTrace();
		} catch(IOException e1)
		{
			e1.printStackTrace();
		}
		chapters = new ArrayList<Chapter>();
	}

	public void testLoad(String u)
	{
		EpubReader er = new EpubReader();
		Iterator<SpineReference> ir = null;
		try
		{
			URL url = new URL(u);
			InputStream in = url.openStream();
			nl.siegmann.epublib.domain.Book inBook = er.readEpub(in);
			in.close();
			setTitle(libriMap.getProperty(inBook.getTitle()));
			ir = inBook.getSpine().getSpineReferences().iterator();
		} catch(MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(ir.hasNext())
		{
			Resource res = ir.next().getResource();
			System.err.println(res.getHref());
			String text = null;
			try
			{
				text = new String(res.getData());
			} catch(IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Document doc = Jsoup.parse(text);
			String inChapter = doc.title();
			if(inChapter.startsWith("Cap."))
			{
				inChapter = inChapter.substring(5);
				Iterator<Element> parIter;
				System.out.println(doc.head().getElementsByTag("link").attr("href"));
				parIter = doc.body().getElementsByTag("p").iterator();
				if(parIter.hasNext())
				{
					Element para = parIter.next();
					Iterator<Element> children = para.children().listIterator();
					if(children.hasNext())
					{
						Element child = children.next();

						if(child.hasAttr("class"))
						{
							verseSpanClass = child.attr("class");
						}
						System.err.println(verseSpanClass);
					}
					// while(children.hasNext())
					// {
					// Element child = children.next();
					// verseSpanClass = child.attr("class");
					// System.err.println(++count + ": " + child.nodeName());
					// }
				}
			}
		}
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

	public void addChapter(Document d)
	{
		chapters.add(new Chapter(d));
	}
	
	public Iterator<Chapter> getChapters()
	{
		return chapters.iterator();
	}

	public void load(String u)
	{
		EpubReader er = new EpubReader();
		Iterator<SpineReference> ir = null;
		try
		{
			URL url = new URL(u);
			InputStream in = url.openStream();
			nl.siegmann.epublib.domain.Book inBook = er.readEpub(in);
			in.close();
			System.err.println(inBook.getTitle());
			setTitle(libriMap.getProperty(inBook.getTitle()));
			ir = inBook.getSpine().getSpineReferences().iterator();
		} catch(MalformedURLException e)
		{
			e.printStackTrace();
		} catch(IOException e)
		{
			e.printStackTrace();
		}
		while(ir.hasNext())
		{
			Resource res = ir.next().getResource();
//			System.err.println(res.getHref());
			String text = null;
			try
			{
				text = new String(res.getData());
			} catch(IOException e)
			{
				e.printStackTrace();
			}
			Document doc = Jsoup.parse(text);
	    CSSOMParser parser = new CSSOMParser();
	    try
			{
				System.out.println(doc.head().getElementsByTag("link").attr("href"));
				CSSStyleDeclaration o = parser.parseStyleDeclaration(new InputSource(new FileReader(doc.head().getElementsByTag("link").attr("href"))));
				System.out.println(o.getPropertyCSSValue("vertical-align"));
			}
			catch(IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			addChapter(doc);
		}
	}
}