package com.sportyshoes.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin_login")
public class Admin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int AdminId;
	private String username;
	private String password;
	
	
	
	public int getAdminId() {
		return AdminId;
	}
	public void setAdminId(int adminId) {
		AdminId = adminId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Admin(int adminId, String username, String password) {
		super();
		AdminId = adminId;
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [AdminId=" + AdminId + ", username=" + username + ", password=" + password + "]";
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
