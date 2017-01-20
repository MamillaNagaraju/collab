package com.face.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Blogtable1",schema="mn")
public class Blog 
{
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	
	private int BBid;
	private String blogTitle;
	private String blogDescritption;
	private String cdate;
	private String postedBy;
	private String category;
	
	public int getBlog_id() {
		return BBid;
	}
	public void setBlog_id(int blog_id) {
		this.BBid = blog_id;
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
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
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
