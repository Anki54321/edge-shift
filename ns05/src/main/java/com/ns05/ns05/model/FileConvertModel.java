package com.ns05.ns05.model;

public class FileConvertModel {


    int FileId;
	int UserId;
	String fileName;
	String hashKey;
	double domain;
	String fileUrl;
    double timetaken;
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
    public double getDomain() {
        return domain;
    }
    public void setDomain(double domain) {
        this.domain = domain;
    }
    public String getFileUrl() {
        return fileUrl;
    }
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
    public double getTimetaken() {
        return timetaken;
    }
    public void setTimetaken(double timetaken) {
        this.timetaken = timetaken;
    }


    
    
}
