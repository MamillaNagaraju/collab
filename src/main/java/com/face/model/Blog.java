package com.face.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Blog {
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int blog_id;
	private String blogTitle;
	private String blogDescritption;
	private Date time;
	private String postedBy;
	private String category;
	public int getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
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
	public Date getDate() {
		return time;
	}
	public void setDate(Date date) {
		time = date;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
