package com.spring.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="T_RECLAMATION")
public class Reclamation implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String title;
	private String content;
	private boolean isread = false;
	@Temporal(TemporalType.DATE)
	private  Date Date;
	public long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isIsread() {
		return isread;
	}
	public void setIsread(boolean isread) {
		this.isread = isread;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		this.Date = date;
	}
	public Reclamation() {
		super();
	}
	public Reclamation(String title, String content, boolean isread) {
		super();
		this.title = title;
		this.content = content;
		this.isread = isread;
		
	}
	public Reclamation(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	public Reclamation(long id, String title, String content, boolean isread) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.isread = isread;
	}
	
	
	public Reclamation(long id, String title, String content, boolean isread, Date date) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.isread = isread;
		this.Date = date;
	}
	
	
	public Reclamation(String title, String content, boolean isread, Date date) {
		super();
		this.title = title;
		this.content = content;
		this.isread = isread;
		this.Date = date;
	}
	@Override
	public String toString() {
		return "Reclamation [id=" + id + ", title=" + title + ", content=" + content + ", isread=" + isread
				+  "]";
	}
	

}
