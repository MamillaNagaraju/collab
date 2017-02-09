package com.face.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.face.config.AppContextConfig;
import com.face.dao.Blogdao;
import com.face.dao.Jobposdao;
import com.face.dao.Regisdao;
import com.face.model.Blog;
import com.face.model.Jobpos;
import com.face.model.Regis;
import com.face.model.Queanforum;
public class Apptest {
	
	
	public static void main (String [] args)
	{
		AbstractApplicationContext context=new AnnotationConfigApplicationContext(AppContextConfig.class);
	
/*Blogdao blog=(Blogdao) context.getBean("blogdao");
	
	Blog blo=new Blog();
	
    blo.setBlogDescritption("the description of");
    blo.setBlogTitle("Description");
    blo.setCategory("blog");"
    blo.setCdate("26dec2016");
    blo.setPostedBy("user");
    blog.addBlog(blo);	
    */
		
		Jobposdao blog=(Jobposdao) context.getBean("jobsdao");	
		
		Jobpos job=new Jobpos();
//		
////		job.setAddressOfTheCompany("hyd");
////		job.setCompany("techy");
////		job.setDateOfInterview("26dec2016");
////		job.setCtc("3lakh");
////		job.setEligibilityCriteria("btech");
////		job.setRole("user");
////		job.setSkillsRequired("java");
////		job.setUrlOfTheCompany("www.techy.com");
////		
//		
//		blog.addJob(job);
		
		
}
}