package com.qlynhansu.Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckLoginDAO {
	private static CheckLoginDAO _instance;
	
	private CheckLoginDAO() {}
	public static CheckLoginDAO getInstance() {
		if(_instance == null) {
			_instance = new CheckLoginDAO();
		}
		return _instance;
	}
	
	public boolean doesUserExist(String username, String password) {
		boolean exists = false;
//		Ket noi CSDL
		String SELECT_USER = "SELECT username, password FROM admin WHERE username=? and password =?";
		String url = "jdbc:mysql://localhost:3306/DULIEU";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "");
			PreparedStatement stmt = con.prepareStatement(SELECT_USER);
			stmt.setString(1,username);
			stmt.setString(2,password);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				exists = true;
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exists;
	}
}
