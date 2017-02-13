package com.face.dao;

import com.face.model.UploadFile;

public interface FileDAO {
public abstract void uploadFile(UploadFile file);
	
	public abstract UploadFile getFile(long userId);

}
