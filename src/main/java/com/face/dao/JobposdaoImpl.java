package com.face.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.face.model.JobRegistration;
import com.face.model.Jobpos;

@Transactional
@Repository("jobsdao")
public class JobposdaoImpl implements Jobposdao{
@Autowired
SessionFactory sessionFactory;
public void addJob(Jobpos job)
{
Session session=sessionFactory.getCurrentSession();	
session.saveOrUpdate(job);
}


public List<Jobpos> viewJobs() {
	Session session=sessionFactory.getCurrentSession();
return session.createCriteria(Jobpos.class).list();

}

public void deleteJob(int id) {
	Session session=sessionFactory.getCurrentSession();
	Jobpos job=(Jobpos) session.get(Jobpos.class, new Integer(id));
	session.delete(job);
}

public void updateJob(Jobpos job) {
	Session session=sessionFactory.getCurrentSession();
	session.update(job);
	
	}

public Jobpos viewJob(int id) {
	Session session=sessionFactory.getCurrentSession();
	Jobpos job=(Jobpos) session.get(Jobpos.class, new Integer(id));
	return job;
}

public void registerJob(JobRegistration jobRegistration) {
	Session session=sessionFactory.getCurrentSession();
	session.save(jobRegistration);
}
}
