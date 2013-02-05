package net.wukong.rssnews.action;

import net.wukong.rssnews.RssNews;
import net.wukong.service.RssNewsService;

import com.opensymphony.xwork2.ActionSupport;

public class LoadZgjqNewsAction extends ActionSupport{
	private RssNews rssNews;
	private RssNewsService service;
	public RssNews getRssNews() {
		return rssNews;
	}
	public void setRssNews(RssNews rssNews) {
		this.rssNews = rssNews;
	}
	public RssNewsService getService() {
		return service;
	}
	public void setService(RssNewsService service) {
		this.service = service;
	}
	@Override
	public String execute() throws Exception {		
		this.service.loadZgjqNews(rssNews);
		return SUCCESS;
	}

}
