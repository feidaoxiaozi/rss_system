package net.wukong.snatch;

import java.io.IOException;

import java.util.HashMap;
import net.wukong.dao.DataTransfer;
import net.wukong.dao.impl.RssNewsDaoImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetNewsFromGnsz implements DataTransfer{
	public String getSzyw() throws IOException {//static void main(String[] args) throws IOException{//
		String szywUrl = null;
		for(int i=1;i<=2;i++){
			if(i==1){
				szywUrl = "http://news.baidu.com/n?cmd=4&class=shizheng&pn=1";
			}if(i==2){
				szywUrl = "http://news.baidu.com/n?cmd=4&class=shizheng&pn=2&sub=0";
			}
		
//		String gjjqUrl = "http://news.baidu.com/n?cmd=4&class=guojijq&pn=i";
//		String gupUrl = "http://news.baidu.com/n?cmd=4&class=stock&pn=i";
//		String lcaiUrl = "http://news.baidu.com/n?cmd=4&class=money&pn=i";
//		String jjmsUrl = "http://news.baidu.com/n?cmd=4&class=hongguan&pn=i";
//		String rwdtUrl = "http://news.baidu.com/n?cmd=4&class=rwdt&pn=i";
//		String gsdtUrl = "http://news.baidu.com/n?cmd=4&class=gsdt&pn=i";
//		String ssyqUrl = "http://news.baidu.com/n?cmd=4&class=search_engine&pn=i";
//		String dzswUrl = "http://news.baidu.com/n?cmd=4&class=e_commerce&pn=i";
//		String wlyxUrl = "http://news.baidu.com/n?cmd=4&class=online_game&pn=2&sub=0";
//		String cwblUrl = "http://news.baidu.com/n?cmd=4&class=chuanwenbl&pn=i";
//		String hlwplUrl = "http://news.baidu.com/n?cmd=4&class=chuanwenbl&pn=i";
//		String gddtUrl = "http://news.baidu.com/n?cmd=4&class=gddt&pn=i";
//		String zcfxUrl = "http://news.baidu.com/n?cmd=4&class=zcfx&pn=i";
//		String sczsUrl = "http://news.baidu.com/n?cmd=4&class=shichangzoushi&pn=i";
//		String jiajuUrl = "http://news.baidu.com/n?cmd=4&class=fitment&pn=i";
//		String fcplUrl = "http://news.baidu.com/n?cmd=4&class=houseval&pn=i";
//		String fqzuUrl = "http://news.baidu.com/n?cmd=4&class=fqzx&pn=i";
//		String fcjdUrl = "http://news.baidu.com/n?cmd=4&class=estateFocus&pn=i";

		 Document doc = Jsoup.connect(szywUrl).get();

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
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 }
		return null;
	}
}
	
