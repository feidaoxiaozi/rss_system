package net.wukong.service.impl;

import java.util.List;

import net.wukong.dao.RssNewsDao;
import net.wukong.rssnews.RssNews;
import net.wukong.service.RssNewsService;

public class RssNewsServiceImpl implements RssNewsService{
    private RssNewsDao rssNewsDao;
	public RssNewsDao getRssNewsDao() {
		return rssNewsDao;
	}

	public void setRssNewsDao(RssNewsDao rssNewsDao) {
		this.rssNewsDao = rssNewsDao;
	}

	public List<RssNews> findAllRssNews() {
		
		return this.rssNewsDao.findAllRssNews();
	}

	
	public void loadSzywNews(RssNews rssNews) {		
		this.rssNewsDao.loadSzywNews(rssNews);
		
	}

	public void loadTWNews(RssNews rssNews) {
		this.rssNewsDao.loadTWNews(rssNews);
		
	}

	public void loadGangAoNews(RssNews rssNews) {
		this.rssNewsDao.loadGangAoNews(rssNews);
		
	}

	public void loadHqsyNews(RssNews rssNews) {
       this.rssNewsDao.loadHqsyNews(rssNews);		
	}

	public void loadGjrwNews(RssNews rssNews) {
		this.rssNewsDao.loadGjrwNews(rssNews);
		
	}

	public void loadZgjqNews(RssNews rssNews) {
		this.rssNewsDao.loadZgjqNews(rssNews);
		
	}

	public void loadThjjNews(RssNews rssNews) {
		this.rssNewsDao.loadThjjNews(rssNews);
		
	}

	public void loadGjjqNews(RssNews rssNews) {
		this.rssNewsDao.loadGjjqNews(rssNews);
		
	}

}
