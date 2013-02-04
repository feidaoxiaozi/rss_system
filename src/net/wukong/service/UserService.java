package net.wukong.service;

import java.io.InputStream;
import java.util.List;

import net.wukong.rssnews.User;

public interface UserService {
   
    public void saveUser(User user);
	
	public void delUser(User user);
	
	public User findById(int id);
	
	public List<User> findAllUser();
	
	public void updateUser(User user);
	
	public InputStream getInputStream();
}
