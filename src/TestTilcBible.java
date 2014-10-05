import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import bible.lachiesa.Bible;

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
			XMLOutputter xo = new XMLOutputter(Format.getPrettyFormat());
			xo.output(bible.toOsis(), new FileWriter("cei2008.osis"));
		}
	}
}
