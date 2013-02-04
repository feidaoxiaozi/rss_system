package net.wukong.user.action;

import java.util.Map;

import net.wukong.rssnews.User;
import net.wukong.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListUserAction extends ActionSupport {
	private User user;
	private UserService service;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		
		Map request = (Map) ActionContext.getContext().get("request");
		
		request.put("list", service.findAllUser());
        
		return SUCCESS;
	}
}
