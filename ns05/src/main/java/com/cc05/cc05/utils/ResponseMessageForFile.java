package com.cc05.cc05.utils;

import java.util.List;



public class ResponseMessageForFile {
    
    private String message;
    private List<FileModel> fileModel;
   
   
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public List<FileModel> getFileModel() {
        return fileModel;
    }
    public void setFileModel(List<FileModel> fileModel) {
        this.fileModel = fileModel;
    }
   
    
    
    
}
