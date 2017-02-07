package com.face.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Blogtable1",schema="mn")
public class Blog 
{
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	
	private int BBid;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	private Regis user;
	private String blogTitle;
	private String blogDescritption;
	private String status;
	public int getBBid() {
		return BBid;
	}
	public void setBBid(int bBid) {
		BBid = bBid;
	}
	public Regis getUser() {
		return user;
	}
	public void setUser(Regis user) {
		this.user = user;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogDescritption() {
		return blogDescritption;
	}
	public void setBlogDescritption(String blogDescritption) {
		this.blogDescritption = blogDescritption;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
