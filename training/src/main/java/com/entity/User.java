package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 街情報クラス
 */
@Entity
@Table(name = "user")
public class User{
	
	// ID
	@Id
	@Column
	private int id;
	// email
	@Column
	
	private String email;
	// password
	@Column
	private String password;
	
	// Getter・Setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
	