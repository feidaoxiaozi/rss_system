package net.wukong.service;

import java.util.List;

import net.wukong.rssnews.RssNews;

public interface RssNewsService {
	
	public void loadSzywNews(RssNews rssNews);
			
	public List<RssNews> findAllRssNews();	

}
