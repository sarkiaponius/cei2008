import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.domain.SpineReference;
import nl.siegmann.epublib.epub.EpubReader;

public class Test {

	public static void main(String[] args) {
		EpubReader epubReader = new EpubReader();
		URL url;
		try {
			url = new URL("http://www.verbumweb.net/it/bibbia/Salmi.epub");
			InputStream in = url.openStream();
			Book book = epubReader.readEpub(in);
			System.out.println(book.getTitle());
			Iterator<SpineReference> ir = book.getSpine().getSpineReferences().iterator();
			while (ir.hasNext()) {
				Resource res = ir.next().getResource();
				System.out.println(res.getTitle());
				String text = new String(res.getData());
				Document doc = Jsoup.parse(text);
				Iterator<Element> parIter;
				parIter = doc.body().getElementsByTag("p").iterator();
				while (parIter.hasNext()) {
					Element para = parIter.next();
					Iterator<Element> vNumbIter = para.getElementsByTag("span")
							.iterator();
					Iterator<TextNode> vTextIter = para.textNodes().iterator();
					// while (vTextIter.hasNext()) {
					// TextNode vTextNode = vTextIter.next();
					// System.out.println(vTextNode.getWholeText());
					// }
					// while (vNumbIter.hasNext()) {
					// String vNumb = vNumbIter.next().text();
					// System.out.println("[" + vNumb + "]");
					// }
					while (vTextIter.hasNext() && vNumbIter.hasNext()) {
						TextNode vTextNode = vTextIter.next();
						String vNumb = vNumbIter.next().text();
						System.out.println("[" + vNumb + "] "
								+ vTextNode.getWholeText());
					}
				}
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
