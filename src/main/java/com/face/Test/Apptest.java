package com.face.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.face.config.AppContextConfig;
import com.face.dao.Regisdao;
import com.face.model.Regis;
public class Apptest {
	
	
	public static void main (String [] args)
	{
		AbstractApplicationContext context=new AnnotationConfigApplicationContext(AppContextConfig.class);
	Regisdao Regis=(Regisdao) context.getBean("Regisdao");
	
	Regis reg=new Regis();
	
	
    reg.setUsername("will");
    reg.setPassword("password@123");
    reg.setCity("NY");
    reg.setMobile("1234567891");
    reg.setRole("User");
    
    Regis.addUser(reg);
    
	}

}
