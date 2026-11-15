package com.global.system.utils;

import org.springframework.stereotype.Component;

import com.global.system.model.UserModel;

@Component
public class ResponseMessage {

    String message;
    UserModel userModel;

    public ResponseMessage(){
        
    }

    public ResponseMessage(String msg) {
        this.message=msg;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public UserModel getUserModel() {
        return userModel;
    }
    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    
    
}
