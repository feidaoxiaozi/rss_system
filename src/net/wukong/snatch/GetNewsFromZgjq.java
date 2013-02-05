package net.wukong.snatch;

import java.io.IOException;

import java.util.HashMap;
import net.wukong.dao.DataTransfer;
import net.wukong.dao.impl.RssNewsDaoImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetNewsFromZgjq implements DataTransfer{
	public String getZgjq() throws IOException {//static void main(String[] args) throws IOException{//
		String zgjqUrl = null;
		for(int i=1;i<=2;i++){
			if(i==1){
				zgjqUrl = "http://news.baidu.com/n?cmd=4&class=zhongguojq&pn=1";
			}if(i==2){
				zgjqUrl = "http://news.baidu.com/n?cmd=4&class=zhongguojq&pn=2&sub=0";
			}		
		 Document doc = Jsoup.connect(zgjqUrl).get();

		 Elements content = doc.select("div.p2 div");
		 String url = null;
		 String title = null;
		 String resourceAndTime = null;
		 String from = null;
		 String time = null;
		 String attention = null;
		 for(Element item:content){
			 HashMap<String, Object> map=new HashMap<String, Object>();
			 Elements a= item.getElementsByTag("a").not(".rnews");
			 Elements spanRes = item.select(".c");	
			 Elements spanAttr= item.getElementsByTag("span").not(".c");
			 if(!spanAttr.hasText()){				
				 spanAttr = spanRes;
			 }			
			 for(Element item_a:a){				 
				 url= item_a.attr("href");
				 title=item_a.text();
				 System.out.println(title);
				 System.out.println(url);
				
				 map.put(TITLE, title);
				 map.put(URL, url);
			 }
			 for(Element resSpan:spanRes){
				 resourceAndTime = resSpan.text();					 				
				 String[] ss = resourceAndTime.split("\u00a0");
				 System.out.println("@#@#$$="+ss.length);
				 from = ss[0];				 
				 time = ss[1];				 				
				 map.put(FROM, from);
				 
				 map.put(TIME, time);
				 System.out.println(from);
				 System.out.println(time);
			 }
			 for(Element item_span:spanAttr){
				 System.out.println(item_span.text().equals(null));				 					 									 
					 attention = item_span.text().replace(">>", "").replace("Ãıœ‡πÿ", ""); 
					 map.put(ATTENTION, attention);
					 System.out.println(attention); 				
			 }	
			 RssNewsDaoImpl.data.add(map);
		}
		System.out.println("~~~~~"+ RssNewsDaoImpl.data.size());	
		 try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 }
		return null;
	}
}
	
