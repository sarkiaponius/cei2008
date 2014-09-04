package bible.tilc;

import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.TextNode;

import bible.Verse;

public class Chapter
{
	private ArrayList<Verse> verses;
	private int number;
	private String swordAcronym;

	public String getSwordAcronym()
	{
		return swordAcronym;
	}

	public void setSwordAcronym(String swordAcronym)
	{
		this.swordAcronym = swordAcronym;
	}

	public Chapter(int n)
	{
		verses = new ArrayList<Verse>();
		setNumber(n);
	}

	public Chapter(String n)
	{
		verses = new ArrayList<Verse>();
		setNumber(Integer.parseInt(n));
	}

	public Chapter(Document d, int number)
	{
		verses = new ArrayList<Verse>();
		{
			setNumber(number);
			Iterator<TextNode> parIter;
			parIter = d.body().textNodes().iterator();
			while(parIter.hasNext())
			{
				TextNode para = parIter.next();
				System.err.println(para.text());
			}
		}
	}

	public void addVerse(Verse v)
	{
		verses.add(v);
	}

	public void addVerse(String t, int n)
	{
		verses.add(new Verse(t, n));
	}

	public void addVerse(String t, String n) throws NumberFormatException
	{
		verses.add(new Verse(t, Integer.parseInt(n)));
	}

	public void setNumber(int n)
	{
		number = n;
	}

	public void setNumber(String n)
	{
		number = Integer.parseInt(n);
	}

	public int getNumber()
	{
		return number;
	}

	public Iterator<Verse> getVerses()
	{
		return verses.iterator();
	}

	public String toImp(String swordAcronym)
	{
		Iterator<Verse> viter = verses.iterator();
		String imp = "$$$" + swordAcronym + " " + number + ":0\n";
		while(viter.hasNext())
		{
			imp += viter.next().toImp(swordAcronym, number);
		}
		return imp;
	}
}
