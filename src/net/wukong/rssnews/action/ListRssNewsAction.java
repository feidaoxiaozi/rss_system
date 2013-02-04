package net.wukong.rssnews.action;

import java.util.Map;
import net.wukong.rssnews.RssNews;
import net.wukong.service.RssNewsService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListRssNewsAction extends ActionSupport {
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
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		
		Map request = (Map) ActionContext.getContext().get("request");
		
		request.put("list", service.findAllRssNews());
        
		return SUCCESS;
	}
}
