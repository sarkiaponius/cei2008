package bible;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

public class Bible
{
	private ArrayList<Book> ot;
	private ArrayList<Book> nt;
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
		ot = new ArrayList<Book>();
		nt = new ArrayList<Book>();
	}

	public void load()
	{
		BufferedReader br;
		String acronym, url;
		Book book = null;
		try
		{
			br = new BufferedReader(new FileReader(config.getProperty("sword.ot")));
			while(br.ready())
			{
				acronym = br.readLine();
				book = new Book();
				book.setAcronym(acronym);
				url = ceiBaseUrl + swordMap.getProperty(acronym) + ".epub";
				book.load(url);
				ot.add(book);
			}
			br = new BufferedReader(new FileReader(config.getProperty("sword.nt")));
			while(br.ready())
			{
				acronym = br.readLine();
				book = new Book();
				book.setAcronym(acronym);
				System.err.println(acronym);
				url = ceiBaseUrl + swordMap.getProperty(acronym) + ".epub";
				book.load(url);
				nt.add(book);
				wait(2);
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public String toImp()
	{
		String imp = "$$$[ Module Heading ]\n";
		imp += "$$$[ Testament 1 Heading ]\n";
		Iterator<Book> ir;
		ir = ot.iterator();
		while(ir.hasNext())
		{
			imp += ir.next().toImp();
		}
		imp += "\n$$$[ Testament 2 Heading ]\n\n";
		ir = nt.iterator();
		while(ir.hasNext())
		{
			imp += ir.next().toImp();
		}
		return imp;
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