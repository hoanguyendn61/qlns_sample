package com.qlynhansu.Model.BO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.qlynhansu.Model.BEAN.Department;
import com.qlynhansu.Model.DAO.DepartmentDAO;

public class DepartmentBO {
	private static final DepartmentDAO Instance = DepartmentDAO.getInstance();
	private static DepartmentBO _instance;
	public static DepartmentBO getInstance() {
		if(_instance == null) {
			_instance = new DepartmentBO();
		}
		return _instance;
	}
	private DepartmentBO() {}
	public ArrayList<Department> getListDepartment(){
		return Instance.getListDepartment(); 
	}
	public Department getDeptByID(String id) {
		return Instance.getDeptByID(id);
	}
	public int updateDept(Department dept) {
		return Instance.updateDept(dept);
	}
}
