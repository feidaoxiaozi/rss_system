package net.wukong.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	Connection con = null;

	public Connection getConn() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/rss_system";
			con = DriverManager.getConnection(url, "root", "123456");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public void close() {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  
}
