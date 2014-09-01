import java.io.IOException;

import bible.Bible;

public class TestBible
{

	public static void main(String[] args) throws IOException
	{
		Bible bible = new Bible();
		bible.load();
	}
}
