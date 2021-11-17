package com.qlynhansu.Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.qlynhansu.Model.BEAN.Department;
import com.qlynhansu.Model.BEAN.Employee;

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
	public Department getDeptByID(String id) {
		Department dept = null;
		String SELECT_EMP = "SELECT * FROM phongban WHERE IDPB = '"+id+"'";
		String url = "jdbc:mysql://localhost:3306/DULIEU";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_EMP);
			if(rs.next()){
				dept = new Department(rs.getString(1),rs.getString(2),rs.getString(3));
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
		return dept;
	}
	public int updateDept(Department dept) {
		String RM_EMP = "UPDATE phongban SET Tenpb = ?, Mota = ? WHERE IDPB = ?";
		String url = "jdbc:mysql://localhost:3306/DULIEU";
		int rs = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "");
			PreparedStatement stmt = con.prepareStatement(RM_EMP);
			stmt.setString(1, dept.getNamepb().trim());
			stmt.setString(2, dept.getDesc().trim());
			stmt.setString(3, dept.getIdpb().trim());
			rs = stmt.executeUpdate();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
