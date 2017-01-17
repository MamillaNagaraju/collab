package com.face.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.face.model.Regis;

@Repository("Regisdao")
@EnableTransactionManagement
@Transactional
public class RegisdaoImpl implements Regisdao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addUser(Regis user) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
		
	}

	public void updateUser(Regis user) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
		
	}

	public void deleteUser(Regis user) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(user);
		
	}

	public Regis getUserByUsername(String username) {
		Session session=sessionFactory.getCurrentSession();
		Regis user=(Regis)session.createQuery("from Regis where username='"+username+"'").getSingleResult();
		
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<Regis> listUsers() 
	{
		Session session=sessionFactory.getCurrentSession();
		System.out.println("i am in user list update");
		List<Regis> users=session.createQuery("from Regis").getResultList();
		System.out.println(users.get(0));
		return users;
	}
	
	

}

