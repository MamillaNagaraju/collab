package com.face.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.face.dao.Jobposdao;
import com.face.dao.Queanforumdao;
import com.face.model.Jobpos;
import com.face.model.Queanforum;

//-------------------------create user--------------//
@RestController
public class JobpoController {
	@Autowired
Jobposdao jobs;
	
	@RequestMapping(value = "/myjob", method = RequestMethod.POST )
	public ResponseEntity<Jobpos> addJob (@RequestBody Jobpos job , UriComponentsBuilder ucBuilder)
	 { 
		jobs.addJob(job);
		@SuppressWarnings("unused")
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Jobpos>(HttpStatus.CREATED);
	 }
	
	
	//---------------------------retrive-------//
	
	@RequestMapping(value = "/myjob/", method = RequestMethod.GET)
    public ResponseEntity<List<Jobpos>>listBlogs()
    {
	System.out.println("am in retrive forum");
 List<Jobpos> job = jobs.viewJobs();
 System.out.println(job.toString());
 
 if(job.isEmpty())
 {
 return new ResponseEntity<List<Jobpos>>(HttpStatus.NO_CONTENT);
}
 return new ResponseEntity<List<Jobpos>>(job, HttpStatus.OK);
    }

	
	// delete forum//
			 @RequestMapping(value="/myjob/{ID}", headers="Accept=applicaton/json",method=RequestMethod.DELETE)
			 public void deleteUser (@PathVariable ("ID") int id)
			 {
				 System.out.println("I am in blog rest delete controller");
				 jobs.deleteJob(id);

			 }
			 
			 
			 //update//
			 @RequestMapping(value="/updatejob", method=RequestMethod.PUT)
			 public void updateQueanforum(@RequestBody Jobpos job)
			 {
				 System.out.println("inside update forum");
				 jobs.updateJob(job);
			 }
}

