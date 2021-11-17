package com.qlynhansu.Model.BEAN;

public class Employee {
	private String idnv;
	private String name;
	private String address;
	private String idpb;
	public Employee(String id, String name, String pb, String address) {
		this.idnv = id;
		this.name = name;
		this.address = address;
		this.idpb = pb;
	}
	public String getIdnv() {
		return idnv;
	}
	public void setIdnv(String idnv) {
		this.idnv = idnv;
	}
	public String getIdPb() {
		return idpb;
	}
	public void setIdPb(String pb) {
		this.idpb = pb;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
