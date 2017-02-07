package com.face.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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

	 //------------------Create a User--------------------------------------------------------
     
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


//@RequestMapping(value="/logincheck", method=RequestMethod.POST)
//public ResponseEntity <?> logincheck(@RequestBody Regis userdetails,HttpSession session){
//	System.out.println("Entering UserController : Login()");
//	Long userid=userdetails.getUserId();
//	Regis validuser = userDAO.logincheck(userdetails);
//	System.out.println("\n" + userdetails.getUserId());
//	
//	if(validuser==null){
//		System.out.println("validuser is null");
//		Error error = new Error("User does not exists");
//		return new ResponseEntity<Error> (error,HttpStatus.UNAUTHORIZED);// 401
//	}
//	else{
//		session.setAttribute("user", validuser);
//		validuser.setIsonline(true);
//		userDAO.updateUser(validuser); // - to be uncommented after 
//		System.out.print("\nlogincheck - " + validuser.getRole()); 
//		System.out.println("valid user is available");
//		
//		 //select * from proj2_profile_pics where username='adam';
//		  UploadFile getUploadFile=fileUploadDao.getFile(validuser.getUserId());
//		  if(getUploadFile!=null){
//	  	//String name=getUploadFile.getFilename();
//	  	System.out.println(getUploadFile.getData());
//	  	byte[] imagefiles=getUploadFile.getData();
//	  	try{
//	  		
//	  		String path="F:/collab2/src/main/webapp/resources/images/users/"+validuser.getUserId()+".jpg";
//	  		File file=new File(path);
//	  		//file.mkdirs();
//	  		FileOutputStream fos = new FileOutputStream(file);//to Write some data 
//	  		fos.write(imagefiles);
//	  		fos.close();
//	  		}catch(Exception e){
//	  		e.printStackTrace();
//	  		}
//		  }
//		
//		
//		return new  ResponseEntity<Regis> (validuser, HttpStatus.OK);
//	}		
//}
//
//@RequestMapping(value="/logout",method=RequestMethod.PUT)
//public ResponseEntity<?> logout(HttpSession session){
//	Regis ud = (Regis)session.getAttribute("user");
//	if(ud!=null){
//		ud.setIsonline(false);
//		userDAO.updateUser(ud);
//		try{
//            //change according to your workspace path and project name
//			String path="F:/collab2/src/main/webapp/resources/images/users/"+ud.getUserId()+".jpg";
//			File file=new File(path);
//			System.out.println(file.delete());
//	
//	}catch(Exception e){
//		e.printStackTrace();
//	}
//	}
//	session.removeAttribute("user");		
//	session.invalidate();
//	return new  ResponseEntity<Void> (HttpStatus.OK);		
//	
//}

 
}