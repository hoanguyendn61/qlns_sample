package com.qlynhansu.Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.qlynhansu.Model.BEAN.Department;

public class DepartmentDAO {
	private static DepartmentDAO _instance;
	public static DepartmentDAO getInstance() {
		if(_instance == null) {
			_instance = new DepartmentDAO();
		}
		return _instance;
	}
	private DepartmentDAO() {}
	
	public ArrayList<Department> getListDepartment(){
		ArrayList<Department> list = new ArrayList<Department>();
		String SELECT_DPM = "SELECT * FROM phongban";
		String url = "jdbc:mysql://localhost:3306/DULIEU";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_DPM);
			while(rs.next()){
				Department dp = new Department(rs.getString(1),rs.getString(2),rs.getString(3));
				list.add(dp);
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
		return list;
	}
	
}
