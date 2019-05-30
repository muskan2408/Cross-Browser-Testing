package jsoupdemo;

import java.io.IOException;
import java.io.StringReader;

import org.jsoup.Jsoup;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSRuleList;
import org.w3c.dom.css.CSSStyleSheet;
import org.xml.sax.InputSource;

import com.steadystate.css.parser.CSSOMParser;
import com.steadystate.css.parser.SACParserCSS3;

public class Jsoupdemo {
	
	public static void main(String args[]) throws IOException
	{
		String webPage = "http://www.ietdavv.edu.in/";
        String html= Jsoup.connect(webPage).get().html();
        System.out.println(html);
        
        InputSource source = new InputSource(
                new StringReader(
                    "h1 { background: #ffcc44; } div { color: red; }"));
//        CSSOMParser parser = new CSSOMParser(new SACParserCSS3());
//        CSSStyleSheet sheet = parser.parseStyleSheet(source, null, null);
//            CSSRuleList rules = sheet.getCssRules();
//            for (int i = 0; i < rules.getLength(); i++) {
//                final CSSRule rule = rules.item(i);
//                System.out.println(rule.getCssText());
//            }
	}
 
   
}
