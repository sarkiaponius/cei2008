import java.io.IOException;

import bible.tilc.Bible;

public class TestTilcBible
{

	public static void main(String[] args) throws IOException
	{
		Bible bible = new Bible();
		bible.load();
		System.err.println(bible.toImp());
	}
}
