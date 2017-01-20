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

import com.face.dao.Regisdao;
import com.face.model.Regis;

@RestController
public class UserRestController {

	@Autowired
	Regisdao userDAO;
	
	 @RequestMapping(value = "/user/", method = RequestMethod.GET)
	    public ResponseEntity<List<Regis>> listAllUsers() {
	        List<Regis> users = userDAO.listUsers();
	        if(users.isEmpty()){
	            return new ResponseEntity<List<Regis>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Regis>>(users, HttpStatus.OK);
	    }

	 //-------------------Create a User--------------------------------------------------------
     
	    @RequestMapping(value = "/user/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createUser(@RequestBody Regis user,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating User " + user.getUsername());
	  
	       
	        
	  
	        userDAO.addUser(user);
	  
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getUserId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 



//------------------- Delete a User --------------------------------------------------------
  
@RequestMapping(value = "/user/{username}", method = RequestMethod.DELETE)
public void deleteUser(@PathVariable("username") String username) {
    

    userDAO.deleteUser(userDAO.getUserByUsername(username));
   
}




//------------------- Update a User --------------------------------------------------------

@RequestMapping(value = "/user/{username}", method = RequestMethod.PUT)
public ResponseEntity<Regis> updateUser(@PathVariable("username") String username, @RequestBody Regis user) {
    System.out.println("Updating User " + userDAO.getUserByUsername(username) );
      
      Regis currentUser = userDAO.getUserByUsername(username);
      
    

    currentUser.setUsername(user.getUsername());
    currentUser.setPassword(user.getPassword());
    currentUser.setMobile(user.getMobile());
    currentUser.setCity(user.getCity());
    currentUser.setRole(user.getRole());
      
    userDAO.updateUser(currentUser);
    return new ResponseEntity<Regis>(currentUser, HttpStatus.OK);
}

 
}