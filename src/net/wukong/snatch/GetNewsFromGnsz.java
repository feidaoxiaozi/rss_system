package net.wukong.snatch;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetNewsFromGnsz {
    
	public String getSzyw() throws IOException {//static void main(String[] args) throws IOException {// 
		FileWriter out = new FileWriter(new File("D:"+File.separator+"xinwen.txt"));
		String szywUrl = null;
		for(int i=1;i<=2;i++){
			if(i==1){
				szywUrl = "http://news.baidu.com/n?cmd=4&class=shizheng&pn=1";
			}if(i==2){
				szywUrl = "http://news.baidu.com/n?cmd=4&class=shizheng&pn=2&sub=0";
			}
		
//		String taiwanUrl = "http://news.baidu.com/n?cmd=4&class=taiwan&pn=i&sub=0";
//		String gangaoUrl = "http://news.baidu.com/n?cmd=4&class=gangaotai&pn=i";
//		String hqsyUrl = "http://news.baidu.com/n?cmd=4&class=hqsy&pn=i&sub=0";
//		String gjrwUrl = "http://news.baidu.com/n?cmd=4&class=renwu&pn=i&sub=0";
//		String zgjqUrl = "http://news.baidu.com/n?cmd=4&class=zhongguojq&pn=i";
//		String taihaijjUrl = "http://news.baidu.com/n?cmd=4&class=taihaijj&pn=i";
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
		 String href = null;
		 String text = null;
		 String restext = null;
		 String attrtext = null;
		 for(Element item:content){
			 Elements a= item.getElementsByTag("a").not(".rnews");
			 Elements spanRes = item.select(".c");	
			 Elements spanAttr= item.getElementsByTag("span").not(".c");
			 if(!spanAttr.hasText()){
				 spanAttr= spanRes;
				 System.out.println(spanAttr);
			 }			 
			 for(Element item_a:a){				 
				 href= item_a.attr("href");
				 text=item_a.text();
				 System.out.println(text);
				 System.out.println(href);
				 out.write(text+"@"+href+"$");
			 }
			 for(Element resSpan:spanRes){
				 restext = resSpan.text();
				 System.out.println(restext);
				 out.write(restext+"#");				
			 }
			 for(Element item_span:spanAttr){				 
				 attrtext = item_span.text().replace(">>", "");
				 System.out.println(attrtext);
				 out.write(attrtext+"^"+"\r\n");
			 }	
			 }
			
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
	
