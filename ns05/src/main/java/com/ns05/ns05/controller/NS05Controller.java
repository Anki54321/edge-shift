package com.ns05.ns05.controller;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.ns05.ns05.Repository.GetSystemsRepository;
import com.ns05.ns05.Repository.UserRequestRepository;

import com.ns05.ns05.model.UserRequestModel;
import com.ns05.ns05.utils.CreateNodes;
import com.ns05.ns05.utils.GetMac;
import com.ns05.ns05.utils.JcapUtils;

@Controller
public class NS05Controller {

    @Autowired
UserRequestRepository userRequestRepository;
@Autowired
Environment environment;
@Autowired
GetSystemsRepository getSystemsRepository;


@PostMapping("/sendKey")
    public String sendRequest1(
        @RequestParam("userid") String userId,
        @RequestParam("hash") String hashcode,
        @RequestParam("user") String receiverId,
       
        Model model
    ) throws UnknownHostException, SocketException{
      String receiverid[]=receiverId.split(",");
      int recvid=Integer.parseInt(receiverid[0]);
      UserRequestModel urm=new UserRequestModel();
      urm.setHashCode(hashcode);
      urm.setSenderId(Integer.parseInt(userId));
      urm.setReceiveId(recvid);
      urm.setStatus("pending");
      urm.setFileId(0);
      urm.setMacaddress(GetMac.getmacaddress());
      String port = environment.getProperty("local.server.port");
      urm.setIpaddress(GetMac.getIpaddress()+":"+port);

      long i=getSystemsRepository.count();

      int result = CreateNodes.getMali();
   int result1= CreateNodes.getMali1();
   JcapUtils jcapUtils=new JcapUtils();
   //NetworkInterface[] nodes1=jcapUtils.getJpacap();
//System.out.println(nodes1[1]);
   if(result==result1){
      result1= CreateNodes.getMali();
      
   }
   int minus=(result1)-(result);
   
   System.out.println(result+"\t"+result1);

      if(i<4){
         model.addAttribute("msg","Nodes are less than 100. Please create 100 nodes");
      }else{

        UserRequestModel ur1=userRequestRepository.findBySenderId(Integer.parseInt(userId));
        UserRequestModel ur2=userRequestRepository.findByReceiveId(Integer.parseInt(userId));
        if(ur1!=null ){
       
        
          if(ur1.getFileId()==0){
          model.addAttribute("msg","You request is in progress");
          }else{
            UserRequestModel ur= userRequestRepository.save(urm);
            if(ur==null){
               model.addAttribute("msg","Request failed");
            }else{
               model.addAttribute("msg","Request Sent to User");         
            } 
          }
        
        }else if(ur2!=null){
          if(ur2.getFileId()==0){
            model.addAttribute("msg","You request is in progress");
            }else{
              UserRequestModel ur= userRequestRepository.save(urm);
              if(ur==null){
                 model.addAttribute("msg","Request failed");
              }else{
                 model.addAttribute("msg","Request Sent to User");
              } 
            }

        }
        
        else{

          UserRequestModel ur= userRequestRepository.save(urm);
          if(ur==null){
             model.addAttribute("msg","Request failed");
          }else{
             model.addAttribute("msg","Request Sent to User");
            model.addAttribute("malnode",(result));
             model.addAttribute("malnode1", (result1));
             model.addAttribute("minus", minus);
          }
        }
   
    }

  
     model.addAttribute("create","create");
        return "index";
    }


    @GetMapping("/viewReq/{userid}")
    public String viewConnection(@PathVariable int userid,Model model){

      
      UserRequestModel urm=  userRequestRepository.findBySenderId(userid);
      if(urm!=null){
        model.addAttribute("view","view");
        model.addAttribute("values", urm);
      }else{

        UserRequestModel urm1=  userRequestRepository.findByReceiveId(userid);
        model.addAttribute("view","view");
        model.addAttribute("msg", "request to accept the connection");
        model.addAttribute("values", urm1);
     
      }
      
   
      
        return "index";
    }


    @GetMapping("/accept/{id}")
    public String acceptConnection(@PathVariable int id,Model model){

      
       UserRequestModel urm=userRequestRepository.findById(id).get();
       urm.setStatus("accepted");
       userRequestRepository.save(urm);   
       
        return "index";
    }
    
    
}
