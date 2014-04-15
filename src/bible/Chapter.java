package bible;

import java.util.ArrayList;
import java.util.Iterator;

public class Chapter
{
	private ArrayList<Verse> verses;
	private int number;

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

	public void addVerse(Verse v)
	{
		verses.add(v);
	}

	public void addVerse(String t, int n)
	{
		verses.add(new Verse(t, n));
	}

	public void addVerse(String t, String n)
	{
		verses.add(new Verse(t, Integer.parseInt(n)));
	}

	public void setNumber(int n)
	{
		number = n;
	}

	public int getNumber()
	{
		return number;
	}

	public Iterator<Verse> getVerses()
	{
		return verses.iterator();
	}
}
