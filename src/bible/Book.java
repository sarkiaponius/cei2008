package bible;

import java.util.ArrayList;
import java.util.Iterator;

public class Book
{
  private ArrayList<Chapter> chapters;
  private String title;
  
  public Book()
  {
  	chapters = new ArrayList<Chapter>();
  }
  
  public void setTitle(String t)
  {
  	title = new String(t);
  }
  
  public String getTitle()
	{
		return title;
	}

	public void addChapter(Chapter c)
  {
  	chapters.add(c);
  }
  
  public Iterator<Chapter> getChapters()
  {
  	return chapters.iterator();
  }
}
