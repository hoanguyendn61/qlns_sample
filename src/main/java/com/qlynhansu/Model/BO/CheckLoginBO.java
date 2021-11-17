package com.qlynhansu.Model.BO;

import com.qlynhansu.Model.DAO.CheckLoginDAO;

public class CheckLoginBO {
	private static CheckLoginBO _instance;
	private CheckLoginBO() {}
	public static CheckLoginBO getInstance() {
		if(_instance == null) {
			_instance = new CheckLoginBO();
		}
		return _instance;
	}
	
	public boolean isUserValid(String username, String password) {
		return CheckLoginDAO.getInstance().doesUserExist(username, password);
	}
}
