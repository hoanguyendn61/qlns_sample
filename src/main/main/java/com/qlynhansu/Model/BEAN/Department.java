package com.qlynhansu.Model.BEAN;


public class Department {
	private String idpb;
	private String namepb;
	public String getNamepb() {
		return namepb;
	}
	public void setNamepb(String namepb) {
		this.namepb = namepb;
	}
	private String desc;
	public Department(String id, String name, String d) {
		this.idpb = id;
		this.namepb = name;
		this.desc = d;
	}
	public String getIdpb() {
		return idpb;
	}
	public void setIdpb(String idpb) {
		this.idpb = idpb;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
