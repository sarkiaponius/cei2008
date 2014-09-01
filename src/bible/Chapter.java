package bible;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

public class Chapter
{
	private ArrayList<Verse> verses;
	private int number;
	private String verseSpanClass;
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

	public Chapter(Document d, HashSet<String> verseMarkers, int number)
	{
		verses = new ArrayList<Verse>();
		{
			setNumber(number);
			Iterator<Element> parIter;
			parIter = d.body().getElementsByTag("p").iterator();
			int vNumb = 0;
			Verse verse = null;
			Node node = null;
			while(parIter.hasNext())
			{
				Element para = parIter.next();
				Iterator<Node> nodes = para.childNodes().iterator();
				while(nodes.hasNext())
				{
					node = nodes.next();
//					System.out.println("nodo [" + node.toString() + "]");
					if(node instanceof Element)
					{
						if(((Element) node).tagName() == "span")
						{
							if(verseMarkers.contains("*." + node.attr("class")))
							{
//								System.out.println("Lo span ha classe *." + node.attr("class"));
								try
								{
									vNumb = Integer.parseInt(((Element) node).ownText());
								}
								catch(java.lang.NumberFormatException e)
								{
									vNumb = 1;
								}
								if(verse != null)
								{
									addVerse(verse);
								}
								verse = new Verse(vNumb);
//								verse.setChapterNumber(number);
//								verse.setSwordAcronym(swordAcronym);
							}
							else
							{
								// System.out.println("il nodo non è di tipo vNumb");
								if(((Element) node).ownText() != null && verse != null)
								verse.appendText(((Element) node).ownText());
//								verse.setSwordAcronym(swordAcronym);
//								verse.setChapterNumber(number);
								
							}
						}
						else
						{
							// System.out.println("il nodo è un elemento non span");
							if(verse != null) verse.appendText(((Element) node).ownText());
						}
					}
					else
					{
						String t = ((TextNode) node).text().trim();
						// System.out.println("il nodo non è un elemento (" + t + ")");
						if(t != "" && t.length() != 1 && verse != null)
						{
//							System.out.println("[" + t + "]");
							verse.appendText(t);
						}
						// System.out.println(verse.getText());
					}
				}
			}
			if(node instanceof Element)
			{
				if(verse != null) verse.appendText(((Element) node).ownText());
			}
			else
			{
				if(verse != null) verse.appendText(((TextNode) node).text());
			}
			// System.out.println(verse.getNumber() + ", " + verse.getText());
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
		String imp = "";
		while(viter.hasNext())
		{
			imp += viter.next().toImp(swordAcronym, number);
		}
		return imp;
	}
}
