package bible.lachiesa;

import java.io.BufferedReader;
//import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.TextNode;

import bible.Verse;

public class Chapter
{
	private ArrayList<Verse> verses;
	private int number;
	private String swordAcronym;
	private String htmlRegex;
	public static Logger log;

	public Chapter()
	{
		log = Logger.getLogger("COMPARC");
		htmlRegex = "^.*<sup>.*</sup>";
		log.debug("Creato nuovo capitolo");
	}

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
		this();
		verses = new ArrayList<Verse>();
		setNumber(n);
	}

	public Chapter(String n)
	{
		this();
		verses = new ArrayList<Verse>();
		setNumber(Integer.parseInt(n));
	}

	public Chapter(Document d, int number)
	{
		this();
		verses = new ArrayList<Verse>();
		{
			setNumber(number);
			Iterator<TextNode> parIter;
			parIter = d.body().textNodes().iterator();
			while(parIter.hasNext())
			{
				TextNode para = parIter.next();
				System.err.println(para.text());
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
		int number = Integer.parseInt(n);
		int index = number - 1;
		log.debug("Sono in addVerse: verseRef = " + n + ", indice = " + index);
		int size = verses.size();
		if(size > 0 && number > size + 1)
		{
			log.warn("Versetto saltato, da " + size + " a " + number);
			verses.add(index - 1, new Verse("[mancante]", number - 1));
		}
		if(size > 0 && index < size && verses.get(index) != null)
		{
			String text = verses.get(index).getText();
			log.warn("Versetto già presente. Testo attuale: " + text);
			verses.remove(index);
			verses.add(index, new Verse(text + " " + t, number));
		}
		else
		{
			verses.add(new Verse(t, number));
			log.debug("Versetto nuovo");
		}
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
		String imp = "$$$" + swordAcronym + " " + number + ":0\n";
		while(viter.hasNext())
		{
			imp += viter.next().toImp(swordAcronym, number);
		}
		return imp;
	}

	public Element toOsis(String swordAcronym)
	{
		Namespace def = Namespace.getNamespace("http://www.bibletechnologies.net/2003/OSIS/namespace");
		Element chapter = new Element("chapter", def);
		chapter.setAttribute("osisID", swordAcronym + "." + number);
		Iterator<Verse> viter = getVerses();
		while(viter.hasNext())
		{
			Element verse = viter.next().toOsis(swordAcronym, number);
			chapter.addContent(verse);
		}
		return chapter;
	}

	public void load(String chapFile, String acronym)
	{
		BufferedReader br = null;
		String line = null;
		String temp = null;
		int lines = 0;
		String tempVerseRef = "0";
		try
		{
			lines = 0;
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
			    chapFile), "ISO-8859-1"));
			while(br.ready())
			{
				line = br.readLine();
				if(line != null)
				{
					line = line.trim();
					lines++;
					log.debug("Riga " + lines + "(" + line.trim() + ")");
					if(line.contains("<sup>"))
					{
						temp = "";
						String osisID = swordAcronym;
						// osisID += "." + getNumber();
						log.info("Capitolo " + osisID);
						String verseRef = line.replaceAll("^.*<sup>", "");
						verseRef = verseRef.replaceAll("</sup>.*$", "");

						/*
						 * Ci sono una ventina di casi in cui un versetto è stato diviso in
						 * a e b, e un caso (Job.31.40) in cui i due versetti sono molto
						 * distanti fra loro. Qui si rimuove la lettera e si mette via un
						 * versetto col solo numero. Nel caso del versetto b, sarà cura di
						 * addVerse() aggiungere solo il secondo testo al versetto già
						 * presente.
						 */

						if(line.contains("a</sup>") || line.contains("b</sup>"))
						{
							log.warn(osisID + ", numero versetto anomalo: " + verseRef);
							line = line.replaceAll(".</sup>", "</sup>");
							verseRef = line.replaceAll("^.*<sup>", "");
							verseRef = verseRef.replaceAll("</sup>.*$", "");
							log.warn(osisID + ", numero versetto corretto in: " + verseRef);
						}

						/*
						 * Questo test rimane per segnalare l'anomalia, comunque gestita
						 * altrove
						 */

						if(tempVerseRef.equals(verseRef))
						{
							log.warn(osisID + ", numero versetto duplicato: " + verseRef);
						}
						tempVerseRef = new String(verseRef);
						line = line.replaceAll(htmlRegex, "");
						line = line.replaceAll("<p[^>]*>", "\n");
						line = line.replaceAll("<br>$", "\n");
						line = line.replaceAll("<br>", "\n");
						line = line.replaceAll("^<p>", "");
						line = line.replaceAll("<p>", "\n");
						line = line.replaceAll("</p>", "");
						line = line.replaceAll("<i>", "");
						line = line.replaceAll("</i>", "");
						line = line.replaceAll("«", "\"");
						line = line.replaceAll("»", "\"");
						osisID += "." + verseRef;
						log.info("Versetto " + osisID);
						if(osisID.contains("Num.26"))
						{
							// verseRef = "" + (Integer.parseInt(verseRef) - 1);
						}
						addVerse(temp + line.trim(), verseRef);
					}
					if(line.endsWith("<br><dd><br><dd>$")) break;
				}
				else
				{
					break;
				}
			}
			br.close();
		}
		catch(MalformedURLException e)
		{
			log.warn(e.getMessage());
		}
		catch(NumberFormatException e)
		{
			log.warn("Problema con un numero: " + e.getMessage());
		}
		catch(IOException e)
		{
			log.warn("Problema di I/O: " + e.getMessage());
		}
		catch(Exception e)
		{
			log.warn("Eccezione generica: " + e.getMessage());
		}
	}
}
