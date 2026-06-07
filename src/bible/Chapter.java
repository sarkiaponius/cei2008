package bible;

import java.io.BufferedReader;
//import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.TextNode;

public class Chapter
{
  private TreeMap<Integer, Verse> verses;
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
    verses = new TreeMap<Integer, Verse>();
    setNumber(n);
  }

  public Chapter(String n)
  {
    this();
    verses = new TreeMap<Integer, Verse>();
    setNumber(Integer.parseInt(n));
  }

  public Chapter(Document d, int number)
  {
    this();
    verses = new TreeMap<Integer, Verse>();
    {
      setNumber(number);
      Iterator<TextNode> parIter;
      parIter = d.body().textNodes().iterator();
      while (parIter.hasNext())
      {
        TextNode para = parIter.next();
        System.err.println(para.text());
      }
    }
  }

  public void addVerse(Verse v)
  {
    verses.put(v.getNumber(), v);
  }

  public void addVerse(String t, int n)
  {
    verses.put(n, new Verse(t, n));
  }

  public void addVerse(String t, String n) throws NumberFormatException
  {
    int number;
    String part = "";
    if(n.endsWith("a") || n.endsWith("b"))
    {
      number = Integer.parseInt(n.substring(0, n.length() - 1));
      part = n.substring(n.length() - 1);
      log.warn("Parte: " + part);
    }
    else
    {
      number = Integer.parseInt(n);
    }
    log.debug("Sono in addVerse: verseRef = " + n);
    if(verses.get(number) == null)
    {
      verses.put(number, new Verse(t, number));
      log.debug("Versetto nuovo");
    }
    else
    {
      if(part.equals("b"))
      {
        verses.get(number).appendText(" " + t);
      }
      else
      {
        verses.get(number).prependText(" " + t);
      }
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

//  public Iterator<Verse> getVerses()
//  {
//    return verses.iterator();
//  }

//  public String toImp(String swordAcronym)
//  {
//    Iterator<Verse> viter = verses.iterator();
//    String imp = "$$$" + swordAcronym + " " + number + ":0\n";
//    while (viter.hasNext())
//    {
//      imp += viter.next().toImp(swordAcronym, number);
//    }
//    return imp;
//  }

  public Element toOsis(String swordAcronym)
  {
    Namespace def = Namespace.getNamespace("http://www.bibletechnologies.net/2003/OSIS/namespace");
    Element chapter = new Element("chapter", def);
    chapter.setAttribute("osisID", swordAcronym + "." + number);
//    Iterator<Verse> viter = getVerses();
    for(Verse v : verses.values())
//    while (viter.hasNext())
    {
      Element verse = v.toOsis(swordAcronym, number);
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
      br = new BufferedReader(new InputStreamReader(new FileInputStream(chapFile), StandardCharsets.UTF_8));
      while (br.ready())
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
             * Ci sono una ventina di casi in cui un versetto è stato diviso in a e b, e un
             * caso (Job.31.40) in cui i due versetti sono molto distanti fra loro. Qui si
             * rimuove la lettera e si mette via un versetto col solo numero. Nel caso del
             * versetto b, sarà cura di addVerse() aggiungere solo il secondo testo al
             * versetto già presente.
             */

            if(line.contains("a</sup>") || line.contains("b</sup>"))
            {
              log.warn(osisID + ", numero versetto anomalo: " + verseRef);
//              line = line.replaceAll(".</sup>", "</sup>");
              verseRef = line.replaceAll("^.*<sup>", "");
              verseRef = verseRef.replaceAll("</sup>.*$", "");
              log.warn(osisID + ", numero versetto corretto in: " + verseRef);
            }

            /*
             * Questo test rimane per segnalare l'anomalia, comunque gestita altrove
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
            line = line.replaceAll("»([A-Z])", "«$1");
            osisID += "." + verseRef;
            log.info("Versetto " + osisID);
            addVerse(temp + line.trim(), verseRef);
          }
          if(line.endsWith("<br><dd><br><dd>$"))
            break;
        }
        else
        {
          break;
        }
      }
      br.close();
    }
    catch (MalformedURLException e)
    {
      log.warn(e.getMessage());
    }
    catch (NumberFormatException e)
    {
      log.warn("Problema con un numero: " + e.getMessage());
    }
    catch (IOException e)
    {
      log.warn("Problema di I/O: " + e.getMessage());
    }
    catch (Exception e)
    {
      log.warn("Eccezione generica: " + e.getMessage());
    }
  }
}
