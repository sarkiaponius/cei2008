package bible;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

public class Bible
{
	private ArrayList<Book> books;
	private Properties swordMap;
	private Properties config;
	private String ceiBaseUrl;

	public Bible()
	{
		config = new Properties();
		try
    {
	    config.load(new FileReader("bible.conf"));
    }
    catch(FileNotFoundException e)
    {
	    e.printStackTrace();
    }
    catch(IOException e)
    {
	    e.printStackTrace();
    }
		swordMap = new Properties();
		try
    {
	    swordMap.load(new FileReader(config.getProperty("sword.map")));
    }
    catch(FileNotFoundException e)
    {
	    e.printStackTrace();
    }
    catch(IOException e)
    {
	    e.printStackTrace();
    }
		ceiBaseUrl = config.getProperty("cei.baseurl");
	}
	
	public void load()
	{
		Enumeration<Object> keys = swordMap.keys(); 
		while(keys.hasMoreElements())
		{
			String key = (String) keys.nextElement();
			Book book = new Book();
			book.setAcronym(key);
			String url = ceiBaseUrl + swordMap.getProperty(key) + ".epub"; 
			book.load(url);
			books.add(book);
			System.err.println(book.toImp());
		}		
	}
}
