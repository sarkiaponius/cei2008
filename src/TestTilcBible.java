import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import bible.Bible;

public class TestTilcBible
{

  public static void main(String[] args) throws IOException
  {
    Bible bible = new Bible();
    if(bible.isToDownLoad())
    {
      bible.download();
    }
    else
    {
      bible.load();
      if(args[0].equals("osis"))
      {
        Format format = Format.getPrettyFormat();
        format.setEncoding("UTF-8");
        XMLOutputter xo = new XMLOutputter(format);
//				xo.output(bible.toOsis(), new FileWriter("cei2008.osis"));
        xo.output(bible.toOsis(), new OutputStreamWriter(new FileOutputStream("cei2008.osis"), StandardCharsets.UTF_8));

      }
      if(args[0].equals("imp"))
      {
        PrintWriter pw = new PrintWriter("cei2008.imp");
        pw.println(bible.toImp());
        pw.close();
      }
    }
  }
}