package com.ns05.ns05.utils;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ns05.ns05.Repository.GetSystemsRepository;
import com.ns05.ns05.model.GetSystemsModel;

@Controller
public class CreateNodes {
    
//@Autowired    
//GetSystemsRepository getSystemsRepository;

public static void main(String args[]){

    CreateNodes cn=new CreateNodes();
    cn.insertNode();
                
}

public void insertNode(){

             GetSystemsModel gsm=new GetSystemsModel();
                 gsm.setPort(Integer.parseInt("8085"));
                 gsm.setUserid(2);
               //  getSystemsRepository.save(gsm);

}

public static int getMali(){


    Random r = new Random();
int low = 2;
int high = 8;
int result = r.nextInt(high-low) + low;
return result;

}
public static int getMali1(){


    Random r = new Random();
int low = 7;
int high = 14;
int result = r.nextInt(high-low) + low;
return result;

}

}
