package net.wukong.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import net.wukong.dao.UserDao;
import net.wukong.rssnews.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	public void delUser(User user) {
		this.getHibernateTemplate().delete(user);

	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUser() {
		String hql = "from User";
		return (List<User>) this.getHibernateTemplate().find(hql);
	}

	public User findById(int id) {
		User user = (User) this.getHibernateTemplate().get(User.class, id);
		return user;
	}

	public void saveUser(User user) {
		this.getHibernateTemplate().save(user);

	}

	public void updateUser(User user) {
		this.getHibernateTemplate().update(user);

	}

}
