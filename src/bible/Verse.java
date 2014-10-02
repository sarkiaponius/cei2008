package bible;

import org.jdom2.Element;

public class Verse
{
	private String text;
	private int number;
	private String swordAcronym;
	private int chapterNumber;

	public int getChapterNumber()
	{
		return chapterNumber;
	}

	public void setChapterNumber(int chapterNumber)
	{
		this.chapterNumber = chapterNumber;
	}

	public String getSwordAcronym()
	{
		return swordAcronym;
	}

	public void setSwordAcronym(String swordAcronym)
	{
		this.swordAcronym = swordAcronym;
	}

	public Verse(int n)
	{
		number = n;
		text = new String();
	}

	public Verse(String t, int n)
	{
		text = new String(t);
		number = n;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String t)
	{
		text = new String(t);
	}

	public void appendText(String t)
	{
		text += t;
	}

	public int getNumber()
	{
		return number;
	}

	public void clean()
	{
		text = text.replaceAll("«", "\"");
	}
	
	public Element toOsis(String swordAcronym, int chapter)
	{
		Element verse = new Element("verse");
		verse.setAttribute("osisID", swordAcronym + "." + chapter + "." + number);
		verse.setText(text);
		return verse;
	}
	
	public String toImp(String swordAcronym, int chapter)
	{
		return "$$$" + swordAcronym + " " + chapter + ":" + number + "\n" + text + "\n";
	}
}
