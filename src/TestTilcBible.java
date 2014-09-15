import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.MarshalException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Validator;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.bind.api.JAXBRIContext;
import com.sun.xml.internal.bind.api.TypeReference;
import com.sun.xml.internal.ws.api.model.SEIModel;
import com.sun.xml.internal.ws.developer.JAXBContextFactory;

import bible.bibbiaedu.Bible;

public class TestTilcBible
{

	public static void main(String[] args) throws IOException
	{
		Bible bible = new Bible();
		bible.load();
		// bible.toImp("cei2008.imp");
		JAXBContext jc;
		try
		{
			jc = JAXBContext.newInstance("osis.OsisCT");
			Marshaller m = jc.createMarshaller();
			m.setProperty("jaxb.formatted.output", true);
			m.marshal(bible.toOsis(), System.out);
		}
		catch(JAXBException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(..toString());
	}
}
