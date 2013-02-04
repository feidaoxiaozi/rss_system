package net.wukong.dao;

import java.util.List;

import net.wukong.rssnews.User;

public interface UserDao {
       
	public void saveUser(User user);
	
	public void delUser(User user);
	
	public User findById(int id);
	
	public List<User> findAllUser();
	
	public void updateUser(User user);
}
