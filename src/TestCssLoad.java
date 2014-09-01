import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import nl.siegmann.epublib.domain.Resources;
import nl.siegmann.epublib.domain.SpineReference;
import nl.siegmann.epublib.epub.EpubReader;

import bible.Chapter;
import bible.Verse;

public class TestCssLoad
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader titles = new BufferedReader(new FileReader("url.map"));
		String title = null;
		String baseUrl = "http://www.verbumweb.net/it/bibbia/";
		int count = 0;
		EpubReader er = new EpubReader();
		Resources res = null;
		nl.siegmann.epublib.domain.Book inBook = null;
		while(titles.ready())
		{
			title = titles.readLine();
			if(! title.startsWith("#"))
			{
				System.out.println("titolo in lista: " + baseUrl + title + ".epub");
				try
				{
					URL url = new URL(baseUrl + title + ".epub");
					String qString = url.getFile();
					String fileName = qString.replaceAll(".*/", "");
					setBaseName(fileName.split("\\.")[0]);
					InputStream in = url.openStream();
					inBook = er.readEpub(in);
					in.close();
					System.err.println(inBook.getTitle());
					res = inBook.getResources();
				}
				catch(MalformedURLException e)
				{
					e.printStackTrace();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				System.out.println(res.getByHref("Styles/style.css").getSize());
				System.out.println(res.getByHref("Styles/style.css").getReader());
				bible.Book book = new bible.Book();
			}
		}
		titles.close();
	}

	public static void setBaseName(String fileName)
	{
		fileName = fileName;
	}
}
