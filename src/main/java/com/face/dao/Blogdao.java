package com.face.dao;
	 import java.util.List;
	 import com.face.model.Blog;
	 public interface Blogdao {
		void addBlog (Blog blog);
		List<Blog> viewBlogs();
		void updateBlog(Blog blog);
		void deleteBlog(int id);
	}



