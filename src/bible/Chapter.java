package bible;

import java.util.ArrayList;
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
			int vNumb = 0;
			Verse verse = null;
			Node node = null;
			while(parIter.hasNext())
			{
				Element para = parIter.next();
				Iterator<Node> nodes = para.childNodes().iterator();
//				System.out.println(para.html());
				boolean isFirstNode = true;
				boolean skipNextVerse = false;
				while(nodes.hasNext())
				{
					node = nodes.next();
					System.out.println("nodo [" + node.toString() + "]");
					if(node instanceof Element)
					{
						// System.out.println("il nodo è un elemento");
						if(((Element) node).tagName() == "span")
						{
							// System.out.println("il nodo è uno span");
							if(isFirstNode)
							{
								// System.out.println("il nodo è il primo nodo");
								isFirstNode = false;
								verseSpanClass = node.attr("class");
							}
							if(node.attr("class").equals(verseSpanClass))
							{
								// System.out.println("il nodo è di tipo vNumb, creo un verso");
								// System.out.println(((Element) node).ownText());
								try
								{
									vNumb = Integer.parseInt(((Element) node).ownText());
								}
								catch(java.lang.NumberFormatException e)
								{
									vNumb = 1;
									skipNextVerse = true;
								}
								if(verse != null)
								{
									addVerse(verse);
								}
								verse = new Verse(vNumb);
							}
							else
							{
								// System.out.println("il nodo non è di tipo vNumb");
								verse.appendText(((Element) node).ownText());
							}
						}
						else
						{
							// System.out.println("il nodo è un elemento non span");
							verse.appendText(((Element) node).ownText());
						}
					}
					else
					{
						String t = ((TextNode) node).text().trim();
						// System.out.println("il nodo non è un elemento (" + t + ")");
						if(t != "" && t.length() != 1)
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
				verse.appendText(((Element) node).ownText());
			}
			else
			{
				verse.appendText(((TextNode) node).text());
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
}
