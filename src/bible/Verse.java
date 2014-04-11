package bible;

public class Verse
{
	private String text;
	private int number;
	public Verse(String t, int n)
	{
		text = new String(t);
		number = n;
	}
	
	public String getText()
	{
		return text;
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
