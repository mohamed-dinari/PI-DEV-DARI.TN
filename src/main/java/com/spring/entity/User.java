package com.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Controller;
@Controller
@Entity
@Table(name="Table_User")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private Long id;
	@Column(name="FIRST_NAME")
	private String fName;
	@Column(name="LAST_NAME")
	private String lName;
	@Column(name="PASSWORD")
	private String password;
	@Enumerated(EnumType.STRING)
	private Role Role;
	@Temporal(TemporalType.DATE)
	private Date Date ;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return Role;
	}
	public void setRole(Role role) {
		this.Role = role;
	}
	public Date getDate(){
		return Date;
	}
	public void setDate(Date date) {
		this.Date = date;
	}
	public User() {
		super();
	}
	public User(Long id, String fName, String lName, String password ,com.spring.entity.Role role, java.util.Date date) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.password = password;
		this.Role = role;
		this.Date = date;
	}
	public User(String fName, String lName, String password, com.spring.entity.Role role, java.util.Date date) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.password = password;
		Role = role;
		Date = date;
	}
	
	
	

}
