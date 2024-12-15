package repository;

import java.sql.*;

public class DataBaseHelper {
	private static final String url = "jdbc:mysql://localhost:3306/swiggy";
	private static final String user = "root";
	private static final String password = "root";
	
	public static Connection connect() {
	Connection conn = null;
	try {
		conn = DriverManager.getConnection(url,user,password);
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return conn;
	}
}
