package net.wukong.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import net.wukong.dao.RssNewsDao;
import net.wukong.rssnews.RssNews;
import net.wukong.snatch.GetNewsFromGangAo;
import net.wukong.snatch.GetNewsFromGnsz;
import net.wukong.snatch.GetNewsFromHqsy;
import net.wukong.snatch.GetNewsFromTaiW;
import net.wukong.util.DBConn;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mysql.jdbc.PreparedStatement;

public class RssNewsDaoImpl extends HibernateDaoSupport implements RssNewsDao{
	DBConn db = new DBConn();
	Connection con  = db.getConn();
	PreparedStatement ps = null,ps1=null,ps2=null;
	ResultSet rs = null;
	BufferedReader br = null;
	public void delRssNews(RssNews rssNews) {
		// TODO Auto-generated method stub
		
	}
	@SuppressWarnings("unchecked")
	public List<RssNews> findAllRssNews() {
		String hql = "from RssNews";
		return this.getHibernateTemplate().find(hql);
	}
	public boolean loadRssNewsData(String file){
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:"+File.separator+"xinwen.txt"))));
			String line ="";
            String sql ="insert into rsslist (newsId,title,url,resourceAndTime,attention)values(?,?,?,?,?)";
            try {
				con.setAutoCommit(false);
				ps = (PreparedStatement)con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				int n=0,index=1 ;
				String attention = null;
				try {
					while ((line = br.readLine()) != null) {
						int newsId = index++;	
						String title=line.substring(0, line.indexOf("@")+1).replace("@", "");						
						String url=line.substring(line.indexOf("@")+1, line.indexOf("$")+1).replace("$", "");
						String resource=line.substring(line.indexOf("$")+1, line.indexOf("#")+1).replace("#", "").replace("$", "");						
							attention = line.substring(line.indexOf("#")+1,line.indexOf("^")+1).replace("^", "");						
						    ps.setInt(1,newsId);
							ps.setString(2, title);
							ps.setString(3, url);
							ps.setString(4, resource);
							ps.setString(5, attention);
							ps.addBatch();
							n++;
							if(n>100){
								ps.executeBatch();
								n=0;
							}				                       
							ps.executeBatch();							
							con.commit();
						
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					if(null!=rs){
						rs.close();
					}
					if(null!=ps){
						ps.close();
					}
					if(null!=ps2){
						ps2.close();
					}
					if(null!=ps1){
						ps1.close();
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	public RssNews findRssNewsById(int newsId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateRssNews(RssNews rssNews) {
		// TODO Auto-generated method stub
		
	}
   public String getlianjie() throws IOException{
	     String url = "http://127.0.0.1:8080/histest/left.htm";	   	     
		 Document doc =  Jsoup.connect(url).get();
		 Elements content = doc.select("a");	
		 String text = null;
		 String href = null;
			for(Element item_a:content){
				 href = item_a.attr("href");
				 text=item_a.text();
				 System.out.println(text);
				 System.out.println(href);
				
			 }					
		return text;
   }
	public void loadRssNews(RssNews rssNews){
		
		GetNewsFromGnsz szyw = new GetNewsFromGnsz();
		GetNewsFromTaiW taiw = new GetNewsFromTaiW();
		GetNewsFromGangAo gangAo = new GetNewsFromGangAo();
		GetNewsFromHqsy hqsy = new GetNewsFromHqsy();					
//		 try {
//			String lianjie= getlianjie();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
					try {
						szyw.getSzyw();
						taiw.getTaiwNews();						
						gangAo.getGangAo();								
						hqsy.getHqsy();
						loadRssNewsData("D:"+File.separator+"xinwen.txt");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}													
																
	}

}
