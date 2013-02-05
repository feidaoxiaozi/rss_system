package net.wukong.rssnews;

public class RssNews {
  
	private int newsId;
	
	private String title;
	
	private String url;
	
	private String resource;
	
	private String time;
	
	private String attention;

	

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public void setAttention(String attention) {
		this.attention = attention;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAttention() {
		return attention;
	}
}
