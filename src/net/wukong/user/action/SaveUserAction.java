package net.wukong.user.action;

import net.wukong.rssnews.User;
import net.wukong.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class SaveUserAction extends ActionSupport {

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

	public String execute() throws Exception {

		this.service.saveUser(user);

		return SUCCESS;
	}

}
