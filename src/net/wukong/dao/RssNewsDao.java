package net.wukong.dao;

import java.util.List;
import net.wukong.rssnews.RssNews;

public interface RssNewsDao {
	
	public void loadRssNews(RssNews rssNews);
			
	public List<RssNews> findAllRssNews();
	
}
