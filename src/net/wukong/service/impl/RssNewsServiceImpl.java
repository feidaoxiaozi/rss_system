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
		this.rssNewsDao.loadRssNews(rssNews);
		
	}

}
