package com.qlynhansu.Model.BO;

import java.util.ArrayList;

import com.qlynhansu.Model.BEAN.Employee;
import com.qlynhansu.Model.DAO.EmployeeDAO;

public class EmployeeBO {
	private static EmployeeDAO Instance = EmployeeDAO.getInstance();
	private static EmployeeBO _instance;
	public static EmployeeBO getInstance() {
		if(_instance == null) {
			_instance = new EmployeeBO();
		}
		return _instance;
	}
	private EmployeeBO() {}
	
	public ArrayList<Employee> getListEmployee(){
		return Instance.getListEmployee();
	}
	public Employee getEmpByID(String idnv) {
		return Instance.getEmpByID(idnv);
	}
	public ArrayList<Employee> getListEmployee(String idpb){
		return Instance.getListEmployee(idpb);
	}
	public ArrayList<Employee> searchforEmployee(String field, String search){
		return Instance.searchforEmployee(field, search);
	}
	public int removeEmployee(String idnv) {
		return Instance.removeEmployee(idnv);
	}
	public int removeMultipleEmployees(String ids) {
		return Instance.removeMultipleEmloyees(ids);
	}
	public int insertEmployee(Employee emp) {
		return Instance.insertEmployee(emp);
	}
	public int updateEmployee(Employee emp) {
		return Instance.updateEmployee(emp);
	}
}
