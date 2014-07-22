package bible;

public class Verse
{
	private String text;
	private int number;
	
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
}
