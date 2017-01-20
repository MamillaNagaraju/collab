package com.face.dao;

import java.util.List;

import com.face.model.JobRegistration;
import com.face.model.Jobpos;

public interface Jobposdao {
	void addJob(Jobpos job);
	List<Jobpos> viewJobs();
	void deleteJob(int id);
	void updateJob(Jobpos job);
	Jobpos viewJob(int id);
	void registerJob(JobRegistration jobRegistration);
}

