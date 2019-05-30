package jsoupdemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;

import com.steadystate.css.parser.CSSOMParser;
import com.steadystate.css.parser.SACParserCSS3;
import org.w3c.dom.css.CSSStyleSheet;
import org.w3c.dom.css.CSSRuleList;
import javax.xml.transform.Source;

import com.steadystate.css.parser.CSSOMParser;
import org.w3c.dom.css.CSSStyleSheet;
import org.w3c.dom.css.CSSRuleList;
import org.w3c.css.sac.InputSource;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleRule;
import org.w3c.dom.css.CSSStyleDeclaration;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupD {
    protected static JsoupD oParser;
    static String css;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String webPage = "http://www.classical.net/";
        String html= Jsoup.connect(webPage).get().html();
        System.out.println(html);

        oParser= new JsoupD();
        css= "http://www.classical.net/css/main.css";

        Document document = Jsoup.connect(webPage).get();
        Elements links = document.select("link[href]");

        for (Element link : links) 
        {
            System.out.println("link : " + link.attr("href"));
            System.out.println("text : " + link.text());
            
            if(link.attr("href").equals("css/main.css"))
            {
//                String cssText=Jsoup.connect(css).get().wholeText();
//                System.out.println(Jsoup.connect(css).get().wholeText());
            }
        }
        
        InputSource source = new InputSource(
                new StringReader(
                		Jsoup.connect(css).get().wholeText()));
            CSSOMParser parser = new CSSOMParser(new SACParserCSS3());
            CSSStyleSheet sheet = parser.parseStyleSheet(source, null, null);
            CSSRuleList rules = sheet.getCssRules();
            ArrayList<String> CssList=new ArrayList<String>();
            for (int i = 0; i < rules.getLength(); i++) {
                final CSSRule rule = rules.item(i);
                CssList.add(rule.getCssText());
                System.out.println(rule.getCssText());
            }
            int f=0;
            
            for(String css: CssList)
            {
            	
            	if(css.contains("background-blend-mode")
            			|| css.contains("object.style.orphans") 
            			|| css.contains("zoom") 
            			|| css.contains("color-adjust") 
            			|| css.contains("color-caret") 
            			|| css.contains("caret-color") 
            			|| css.contains("color-orientation")
            			|| css.contains(":focus-within")  
            			|| css.contains(":default") 
            			|| css.contains(":read-only") 
            			|| css.contains("windows") 
            			|| css.contains("orphans")
            			|| css.contains(":read-write")
            			|| css.contains("scroll-behavior")
            			|| css.contains(":out-of-range")
            			|| css.contains(":in-range")
            			|| css.contains(": initial")
            			|| css.contains(": inherit")
            			|| css.contains(": unset")
            			|| css.contains("mix-blend-mode")
            			|| css.contains("all:")
            			|| css.contains("::placeholder")
            			|| css.contains("-webkit-text-stroke")
            			|| css.contains("text-stroke")
            			|| css.contains("cursor: grab")
            			|| css.contains("cursor: grabbing")
            			|| css.contains("font-kerning")
            			|| css.contains("-webkit-text-fill-color")
            			|| css.contains("-webkit-text-stroke-width")
            			|| css.contains("-webkit-text-stroke-color")
            			)
            	      {
            		System.out.println("Contains property");
            		System.out.println(css);
            	}
            	else {
            		System.out.print("");
            		f=1;
            	}
            }
            
            if(f==1)
            {
            	System.out.println("NO Property");
            }
        
        
	}

}
