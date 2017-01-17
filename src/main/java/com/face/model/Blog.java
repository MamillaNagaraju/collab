package com.face.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Blog {
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int blog_id;
	private String blogTitle;
	private String blogDescritption;
	private String Date;
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
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
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
