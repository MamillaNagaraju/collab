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

import com.face.dao.Blogdao;
import com.face.dao.Regisdao;
import com.face.model.Blog;
import com.face.model.Regis;
@RestController
public class BlogRestController {
	@Autowired
	Blogdao blogDAO;
	//---------retrive----//
	
	@RequestMapping(value = "/myblog", method = RequestMethod.GET)
	    public ResponseEntity<List<Blog>>listBlogs()
	    {
		System.out.println("am in retrive blog");
	 List<Blog> blogs = blogDAO.viewBlogs();
	 System.out.println(blogs.toString());
	 
	 if(blogs.isEmpty())
	 {
	 return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
}

return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
}
	 /*creating user*/
	 @RequestMapping(value = "/myblog", method = RequestMethod.POST)
	 public ResponseEntity<Void> addBlogData(@RequestBody Blog blog, UriComponentsBuilder ucBuilder)
	 {
		 System.out.println("user name="+blog.getBlogTitle());
		 blogDAO.addBlog(blog);
	 @SuppressWarnings("Unused")
	 HttpHeaders headers = new HttpHeaders();
	 //headers.setLocation(ucBuilder.path("//{id}").buildAndExpand(userCollab.getUserId()).toUri());
	 return new ResponseEntity<Void>(HttpStatus.CREATED);
	 }
	
	// delete the blog
	 @RequestMapping(value="/myblog/{BBid}", headers="Accept=applicaton/json",method=RequestMethod.DELETE)
	 public void deleteUser (@PathVariable ("BBid") int bid)
	 {
		 System.out.println("I am in blog rest delete controller");
		 blogDAO.deleteBlog(bid);
		}
	
	 //update the blog
	 @RequestMapping(value="/updateBlog", method=RequestMethod.PUT)
	 public void updateBlog(@RequestBody Blog blog)
	 {
		 System.out.println("inside update blog");
		 blogDAO.updateBlog(blog);
	 }
	 }