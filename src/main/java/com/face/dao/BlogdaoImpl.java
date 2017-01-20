package com.face.dao;

import java.util.Date;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.face.model.Blog;

@Repository("blogdao")
@EnableTransactionManagement
@Transactional
public class BlogdaoImpl  implements Blogdao
{
	
	@Autowired
	SessionFactory sessionFactory;
	
	Date date;

	
	public void addBlog(Blog blog)
	{
		System.out.println("i am in add blog method in daos");
		Session session=sessionFactory.openSession();
		System.out.println("session="+session);
		org.hibernate.Transaction tx = session.beginTransaction();
		date = new Date();
		String data = date.toString();
		//blog.setDate(data);
		session.saveOrUpdate(blog);
		tx.commit();
		System.out.println("end the add user");
		
	}
	
	public List<Blog> viewBlogs()
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings ({"unchecked","deprecation"})
		List<Blog> list = session.createCriteria(Blog.class).list();
		return list;
		
	}
	
	
	public void updateBlog(Blog blog)
	{
		Session session = sessionFactory.getCurrentSession();
		date = new Date();
		String data = date.toString();
		//blog.setDate(data);
		session.update(blog);
		
	}
	
	public void deleteBlog (int id)
	{
		Session session=sessionFactory.getCurrentSession();
		Blog blog=(Blog)session.get(Blog.class,new Integer(id));
		session.delete(blog);
	}

	@Override
	public String getBlogByBBid(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
