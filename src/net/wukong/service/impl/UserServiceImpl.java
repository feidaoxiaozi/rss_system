package net.wukong.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import net.wukong.dao.UserDao;
import net.wukong.rssnews.User;
import net.wukong.service.UserService;


public class UserServiceImpl implements UserService {

	private UserDao userDao;// 此处将dao的接口作为UserServiceImpl类的属性，然后通过spring配置文件进行依赖注入

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void delUser(User user) {
		this.userDao.delUser(user);
	}

	public List<User> findAllUser() {

		return this.userDao.findAllUser();
	}

	public User findById(int id) {

		return this.userDao.findById(id);
	}

	public void saveUser(User user) {
		this.userDao.saveUser(user);

	}

	public void updateUser(User user) {
		this.userDao.updateUser(user);

	}

	public InputStream getInputStream() {
		HSSFWorkbook hf = new HSSFWorkbook();

		HSSFSheet sheet = hf.createSheet("sheet1");

		HSSFRow row = sheet.createRow(0);

		HSSFCell cell = row.createCell((short) 0);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("序号");

		cell = row.createCell((short) 1);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("用户名");

		cell = row.createCell((short) 2);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("密码");

		cell = row.createCell((short) 3);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("年龄");

		row = sheet.createRow(1);

		List<User> list = this.findAllUser();

		for (int i = 0; i < list.size(); i++) {
			User user = list.get(i);
			row = sheet.createRow(i + 1);
			cell = row.createCell((short) 0);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(user.getId());

			cell = row.createCell((short) 1);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(user.getUsername());

			cell = row.createCell((short) 2);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(user.getPassword());

			cell = row.createCell((short) 3);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(user.getAge());
		}

		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		try {
			hf.write(bos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] content = bos.toByteArray();

		InputStream is = new ByteArrayInputStream(content);

		return is;

		// String fileName = CharacterUtils.getRandomString(10);

		// String fileName = RandomStringUtils.randomAlphanumeric(10);
		//
		// fileName = new StringBuffer().append(".xls").toString();
		//
		// final File file = new File(fileName);
		// try {
		// OutputStream os = new FileOutputStream(file);
		// hf.write(os);
		// os.close();
		// } catch (Exception ex) {
		// ex.getStackTrace();
		// }
		// InputStream is = null;
		// try {
		// is = new FileInputStream(file);
		// } catch (Exception ex) {
		// ex.getStackTrace();
		// }
		// new Thread(new Runnable() {
		// public void run() {
		// try {
		// Thread.sleep(20000);
		// } catch (InterruptedException e) {
		//					
		// e.printStackTrace();
		// }
		// file.delete();
		// }
		// }
		//
		// ).start();
		// return is;
	}
}
