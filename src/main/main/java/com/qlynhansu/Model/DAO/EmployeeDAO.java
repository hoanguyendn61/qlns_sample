package com.qlynhansu.Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.qlynhansu.Model.BEAN.Employee;

public class EmployeeDAO {
	private static EmployeeDAO _instance;
	public static EmployeeDAO getInstance() {
		if(_instance == null) {
			_instance = new EmployeeDAO();
		}
		return _instance;
	}
	private EmployeeDAO() {}
	public ArrayList<Employee> getListEmployee(){
		ArrayList<Employee> list = new ArrayList<Employee>();
		String SELECT_EMP = "SELECT * FROM nhanvien";
		String url = "jdbc:mysql://localhost:3306/DULIEU";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_EMP);
			while(rs.next()){
				Employee emp = new Employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				list.add(emp);
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
	public ArrayList<Employee> getListEmployee(String idpb){
		ArrayList<Employee> list = new ArrayList<Employee>();
		String SELECT_EMP = "SELECT * FROM nhanvien WHERE IDPB = '"+idpb+"'";
		String url = "jdbc:mysql://localhost:3306/DULIEU";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_EMP);
			while(rs.next()){
				Employee emp = new Employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				list.add(emp);
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
	public Employee getEmpByID(String idnv) {
		Employee emp = null;
		String SELECT_EMP = "SELECT * FROM nhanvien WHERE IDNV = '"+idnv+"'";
		String url = "jdbc:mysql://localhost:3306/DULIEU";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_EMP);
			if(rs.next()){
				emp = new Employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
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
		return emp;
	}
	public ArrayList<Employee> searchforEmployee(String field, String search){
		ArrayList<Employee> list = new ArrayList<Employee>();
		String SEARCH_EMP = "SELECT * FROM nhanvien WHERE "+field+" LIKE ?";
		String url = "jdbc:mysql://localhost:3306/DULIEU";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "");
			PreparedStatement stmt = con.prepareStatement(SEARCH_EMP);
			
			stmt.setString(1, "%"+search+"%");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Employee emp = new Employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				list.add(emp);
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
	public int removeEmployee(String idnv) {
		String RM_EMP = "DELETE FROM nhanvien WHERE idnv=?";
		String url = "jdbc:mysql://localhost:3306/DULIEU";
		int rs = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "");
			PreparedStatement stmt = con.prepareStatement(RM_EMP);
			stmt.setString(1, idnv);
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
	public int removeMultipleEmloyees(String idnvs) {
		String RM_EMP = "DELETE FROM nhanvien WHERE IDNV IN ('"+idnvs+"')";
		String url = "jdbc:mysql://localhost:3306/DULIEU";
		int rs = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "");
			Statement stmt = con.createStatement();
			rs = stmt.executeUpdate(RM_EMP);
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
	public int insertEmployee(Employee emp) {
		String RM_EMP = "INSERT INTO nhanvien VALUES(?,?,?,?)";
		String url = "jdbc:mysql://localhost:3306/DULIEU";
		int rs = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "");
			PreparedStatement stmt = con.prepareStatement(RM_EMP);
			stmt.setString(1, emp.getIdnv());
			stmt.setString(2, emp.getName().trim());
			stmt.setString(3, emp.getIdPb());
			stmt.setString(4, emp.getAddress().trim());
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
	public int updateEmployee(Employee emp) {
		String RM_EMP = "UPDATE nhanvien SET Hoten = ?, IDPB = ?, Diachi = ? WHERE IDNV = ?";
		String url = "jdbc:mysql://localhost:3306/DULIEU";
		int rs = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "");
			PreparedStatement stmt = con.prepareStatement(RM_EMP);
			stmt.setString(1, emp.getName().trim());
			stmt.setString(2, emp.getIdPb().trim());
			stmt.setString(3, emp.getAddress().trim());
			stmt.setString(4, emp.getIdnv().trim());
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
