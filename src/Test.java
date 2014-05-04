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

	public static void main(String[] args) throws IOException
	{
		bible.Book book = new bible.Book();
		book.load("http://www.verbumweb.net/it/bibbia/Esodo.epub");
		String title = book.getTitle();
		System.out.println(title);
		Iterator<Chapter> chaps = book.getChapters();
		while(chaps.hasNext())
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
