package bible;

import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;

public class Chapter
{
	private ArrayList<Verse> verses;
	private int number;
	private String verseSpanClass;

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

	public Chapter(Document d)
	{
		verses = new ArrayList<Verse>();
		String title = d.title();
		if(title.startsWith("Cap."))
		{
			setNumber(title.substring(5));
			Iterator<Element> parIter;
			parIter = d.body().getElementsByTag("p").iterator();

/*
 * Va individuata la class dello span usato per distinguere i versetti. Di
 * solito il primo paragrafo è un versetto, e comincia con questo span.
 */
			if(parIter.hasNext())
			{
				Element para = parIter.next();

				Iterator<Element> children = para.children().listIterator();
				if(children.hasNext())
				{
					Element child = children.next();

					if(child.hasAttr("class"))
					{
						verseSpanClass = child.attr("class");
					}
				}
			}
			String query = "span:not([class=" + verseSpanClass + "])";
			parIter = d.body().getElementsByTag("p").iterator();
			int vNumb = 0;
			while(parIter.hasNext())
			{
				Element para = parIter.next();

/*
 * Bisogna rimuovere ogni altro tag "span"
 */
				para.select(query).unwrap();
//				System.err.println(para.html());
				
// l'unwrap funziona, ma lascia invariati i textNode; questo è l'unico modo per 
// farli adeguare al nuovo contenuto HTML del para.
				
				para = new Element(para.tag(), para.baseUri()).append(para.html());
				
				if(para.hasText() && !para.html().equals("&nbsp;"))
				{
					Iterator<TextNode> vTextIter;
					vTextIter = para.textNodes().iterator();
					while(vTextIter.hasNext())
					{
						TextNode vTextNode = vTextIter.next();
						String vText = vTextNode.text().trim();
						if(!vText.equalsIgnoreCase(" "))
						{
							try
							{
								addVerse(vText, ++vNumb);
//								System.err.println(vNumb + ": [" + vText.trim() + "]");
							} catch(NumberFormatException e)
							{
//								System.err.println("Wrong verse number " + vNumb
//										+ ", verse discarded");
							}
						}
					}
				}
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
}
