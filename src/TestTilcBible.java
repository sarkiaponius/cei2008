import java.io.IOException;

import bible.bibbiaedu.Bible;

public class TestTilcBible
{

	public static void main(String[] args) throws IOException
	{
		Bible bible = new Bible();
		bible.load();
		bible.toImp("cei2008.imp");
	}
}
