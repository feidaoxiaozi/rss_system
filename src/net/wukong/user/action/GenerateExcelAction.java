package net.wukong.user.action;

import java.io.InputStream;

import net.wukong.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class GenerateExcelAction extends ActionSupport {

	private UserService service;

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

	private InputStream getDownloadFile() {
		return this.service.getInputStream();

	}

	@Override
	public String execute() throws Exception {

		return SUCCESS;
	}
}
