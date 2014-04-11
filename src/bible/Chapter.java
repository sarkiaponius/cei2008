package bible;

import java.util.ArrayList;
import java.util.Iterator;

public class Chapter
{
	private ArrayList<Verse> verses;
	public Chapter()
	{
		
	}
	
	public void addVerse(Verse v)
	{
		verses.add(v);
	}
	
	public void addVerse(String t, int n)
	{
		verses.add(new Verse(t, n));
	}
	
	public Iterator<Verse> getVerses()
	{
		return verses.iterator();
	}
}
