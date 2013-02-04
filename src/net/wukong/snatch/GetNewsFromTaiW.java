package net.wukong.snatch;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetNewsFromTaiW {
    
	public String getTaiwNews() throws IOException {//static void main(String[] args) throws IOException {// 
		FileWriter out = new FileWriter(new File("D:"+File.separator+"xinwen.txt"));
		String taiwUrl = null;
		for(int i=1;i<=2;i++){
			if(i==1){
				taiwUrl = "http://news.baidu.com/n?cmd=4&class=taiwan&pn=1";
			}if(i==2){
				taiwUrl = "http://news.baidu.com/n?cmd=4&class=taiwan&pn=2&sub=0";
			}
		 Document doc = Jsoup.connect(taiwUrl).get();
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
	
