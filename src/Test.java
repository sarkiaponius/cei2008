import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.domain.SpineReference;
import nl.siegmann.epublib.epub.EpubReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;

import bible.*;

public class Test
{

	public static void main(String[] args)
	{
		EpubReader epubReader = new EpubReader();
		Properties libriMap = new Properties();
		try
		{
			libriMap.load(new FileReader("libri.map"));
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}
		URL url;
		try
		{
			url = new URL("http://www.verbumweb.net/it/bibbia/Genesi.epub");
			InputStream in = url.openStream();
			Book inBook = epubReader.readEpub(in);
			bible.Book book = new bible.Book();
			book.setTitle(libriMap.getProperty(inBook.getTitle()));
			String title = book.getTitle();
			System.out.println(title);
			Iterator<SpineReference> ir;
			ir = inBook.getSpine().getSpineReferences().iterator();
			while (ir.hasNext())
			{
				Resource res = ir.next().getResource();
				System.out.println(res.getHref());
				String text = new String(res.getData());
				Document doc = Jsoup.parse(text);
				String inChapter = doc.title();
				if (inChapter.startsWith("Cap."))
				{
					inChapter = inChapter.substring(5);
					Chapter chapter = new Chapter(inChapter);
					book.addChapter(chapter);
					Iterator<Element> parIter;
					parIter = doc.body().getElementsByTag("p").iterator();
					while (parIter.hasNext())
					{
						Element para = parIter.next();
						Iterator<Element> vNumbIter;
						vNumbIter = para.getElementsByTag("span").iterator();
						Iterator<TextNode> vTextIter = para.textNodes().iterator();
						while (vTextIter.hasNext() && vNumbIter.hasNext())
						{
							String vText = vTextIter.next().getWholeText();
							String vNumb = vNumbIter.next().text();
							chapter.addVerse(vText, vNumb);
						}
						Iterator<Chapter> chaps = book.getChapters();
						while (chaps.hasNext())
						{
							Chapter c = chaps.next();
							Iterator<Verse> verses = c.getVerses();
							while (verses.hasNext())
							{
								Verse v = verses.next();
								String stanza = "$$$";
								stanza += book.getTitle() + ".";
								stanza += c.getNumber() + ".";
								stanza += v.getNumber() + "\n";
								stanza += v.getText();
								System.out.println(stanza);
							}
						}
					}
				}
			}
		} catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
