package net.wukong.dao.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.wukong.dao.DataTransfer;
import net.wukong.dao.RssNewsDao;
import net.wukong.rssnews.RssNews;
import net.wukong.snatch.GetNewsFromGangAo;
import net.wukong.snatch.GetNewsFromGjjq;
import net.wukong.snatch.GetNewsFromGjrw;
import net.wukong.snatch.GetNewsFromGnsz;
import net.wukong.snatch.GetNewsFromHqsy;
import net.wukong.snatch.GetNewsFromTaiW;
import net.wukong.snatch.GetNewsFromThjj;
import net.wukong.snatch.GetNewsFromZgjq;
import net.wukong.util.DBConn;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class RssNewsDaoImpl extends HibernateDaoSupport implements RssNewsDao, DataTransfer{
	
	public static List<HashMap<String, Object>> data=new ArrayList<HashMap<String, Object>>();
	
	DBConn db = new DBConn();
	Connection con  = db.getConn();
	PreparedStatement ps = null,ps1=null,ps2=null;
	ResultSet rs = null;
	BufferedReader br = null;
	
	@SuppressWarnings("unchecked")
	public List<RssNews> findAllRssNews() {
		String hql = "from RssNews";
		return this.getHibernateTemplate().find(hql);
	}

	public void loadRssNewsData( ){ System.err.println("Number====="+data.size());
		String sql ="insert into rsslist (newsId,title,url,resource,time,attention)values(?,?,?,?,?,?)";
		try {
			con.setAutoCommit(false);
			ps = (PreparedStatement)con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);			
			
			for(HashMap<String, Object> map: data){
				
				int n=0,index=0;
				ps.setInt(1, index++);
				ps.setString(2, (String)map.get(TITLE));
				ps.setString(3, (String)map.get(URL));
				ps.setString(4, (String)map.get(FROM));
				ps.setString(5, (String)map.get(TIME));
				ps.setString(6,(String)map.get(ATTENTION));
				ps.addBatch();
				n++;
				if(n>100){
					ps.executeBatch();
					n=0;
				}				                       
				ps.executeBatch();							
				con.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if (null != rs) {
					rs.close();
				}
				if (null != ps) {
					ps.close();
				}
				if (null != ps1) {
					ps1.close();
				}
				if (null != ps2) {
					ps2.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	}

	public void loadSzywNews(RssNews rssNews){
		
		GetNewsFromGnsz szyw = new GetNewsFromGnsz();	
					try {
						szyw.getSzyw();																					
						loadRssNewsData();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}													
																
	}

	public void loadTWNews(RssNews rssNews) {
		GetNewsFromTaiW taiw = new GetNewsFromTaiW();
		try {
			taiw.getTaiwNews();
			loadRssNewsData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadGangAoNews(RssNews rssNews) {
		GetNewsFromGangAo gangAo = new GetNewsFromGangAo();
		try {
			gangAo.getGangAo();
			loadRssNewsData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void loadHqsyNews(RssNews rssNews) {
		GetNewsFromHqsy hqsy = new GetNewsFromHqsy();
		try {
			hqsy.getHqsy();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadRssNewsData();
	}

	public void loadGjrwNews(RssNews rssNews) {
		GetNewsFromGjrw hqsy = new GetNewsFromGjrw();
		try {
			hqsy.getGjrw();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadRssNewsData();
		
	}

	public void loadZgjqNews(RssNews rssNews) {
		GetNewsFromZgjq hqsy = new GetNewsFromZgjq();
		try {
			hqsy.getZgjq();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadRssNewsData();
		
	}

	public void loadThjjNews(RssNews rssNews) {
		GetNewsFromThjj hqsy = new GetNewsFromThjj();
		try {
			hqsy.getThjj();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadRssNewsData();
		
	}

	public void loadGjjqNews(RssNews rssNews) {
		GetNewsFromGjjq gjjq = new GetNewsFromGjjq();
		try {
			gjjq.getGjjq();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadRssNewsData();
		
	}

}
