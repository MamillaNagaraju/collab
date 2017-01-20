package com.face.dao;

import java.util.List;

import com.face.model.Regis;
public interface Regisdao{

	public void addUser(Regis user);
	public void updateUser(Regis user);
	public void deleteUser(Regis user);
	public Regis getUserByUsername(String username);
	public List<Regis> listUsers();
	
		
}