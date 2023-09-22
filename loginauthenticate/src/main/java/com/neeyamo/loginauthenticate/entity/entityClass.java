package com.neeyamo.loginauthenticate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loginPage")
public class entityClass {
	
	@Id
	private String empId;
	private String empName;
	private String password;
	public entityClass(String empId, String empName, String password) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.password = password;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "entityClass [empId=" + empId + ", empName=" + empName + ", password=" + password + "]";
	}
	
	public entityClass() {
		
	}
}
