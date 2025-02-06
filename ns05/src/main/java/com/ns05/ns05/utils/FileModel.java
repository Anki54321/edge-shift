package com.ns05.ns05.utils;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FileModel {
	
    @Id
    @GeneratedValue
	int FileId;
	int UserId;
	String fileName;
	String hashKey;
	double domain;
	String fileUrl;

	
	
	
	public FileModel() {
	}
	public FileModel(String fileName, String fileUrl) {
		this.fileName = fileName;
		this.fileUrl = fileUrl;
	}
	public int getFileId() {
		return FileId;
	}
	public void setFileId(int fileId) {
		FileId = fileId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getHashKey() {
		return hashKey;
	}
	public void setHashKey(String hashKey) {
		this.hashKey = hashKey;
	}


	
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public double getDomain() {
		return domain;
	}
	public void setDomain(double domain) {
		this.domain = domain;
	}
	
	
	

}

