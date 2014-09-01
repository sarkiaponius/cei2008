import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import bible.Chapter;
import bible.Verse;

public class Test
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader titles = new BufferedReader(new FileReader("url.map"));
		String title = null;
		String baseUrl = "http://www.verbumweb.net/it/bibbia/";
		int count = 0;
		while(titles.ready())
		{
			title = titles.readLine();
			if(! title.startsWith("#"))
			{
				System.out.println("titolo in lista: " + baseUrl + title + ".epub");
				bible.Book book = new bible.Book();
				book.load(baseUrl + title + ".epub");
				
				System.out.println(title);
				Iterator<Chapter> chaps = book.getChapters();
				while(chaps.hasNext())
				{
					Chapter c = chaps.next();
					Iterator<Verse> verses = c.getVerses();
					while(verses.hasNext())
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
		titles.close();
	}
}
