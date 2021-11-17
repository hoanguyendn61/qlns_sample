package com.qlynhansu.Model.BO;

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
}
