package bible;

import java.util.ArrayList;
import java.util.Iterator;

public class Book
{
  private ArrayList<Chapter> chapters;
  public void addChapter(Chapter c)
  {
  	chapters.add(c);
  }
  
  public Iterator<Chapter> getChapters()
  {
  	return chapters.iterator();
  }
}
