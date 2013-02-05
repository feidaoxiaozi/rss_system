package net.wukong.service;

import java.util.List;

import net.wukong.rssnews.RssNews;

public interface RssNewsService {
	
	public void loadSzywNews(RssNews rssNews);
	public void loadTWNews(RssNews rssNews);
	public void loadGangAoNews(RssNews rssNews);
	public void loadHqsyNews(RssNews rssNews);
	public void loadGjrwNews(RssNews rssNews);
	public void loadZgjqNews(RssNews rssNews);
	public void loadThjjNews(RssNews rssNews);
	public void loadGjjqNews(RssNews rssNews);
	public List<RssNews> findAllRssNews();	

}
