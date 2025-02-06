package com.ns05.ns05.controller;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ns05.ns05.Exceptions.MyException;
import com.ns05.ns05.Repository.GetSystemsRepository;
import com.ns05.ns05.Repository.UserRequestRepository;
import com.ns05.ns05.config.Configuration;
import com.ns05.ns05.model.AdminResponse;
import com.ns05.ns05.model.UserModel;
import com.ns05.ns05.model.UserRequestModel;
import com.ns05.ns05.utils.CreateNodes;
import com.ns05.ns05.utils.HashCodeGenearate;
import com.ns05.ns05.utils.ResponseMessage;

import me.xdrop.fuzzywuzzy.FuzzySearch;

@Controller
public class CreateConnectionController {

    @Autowired
    UserRequestRepository userRequestRepository;
    @Autowired
    GetSystemsRepository getSystemsRepository;

    @GetMapping("/getUsers/{userid}")
    public String createConnection(Model model,@PathVariable String userid) throws MyException{

         AdminResponse adminResponse=null;
         try {
            adminResponse = Configuration
                    .getRestTemplate()
                    .getForObject(Configuration.getIP() + "admin/getUsers", AdminResponse.class);
        } catch (Exception e) {
            throw new MyException("your server is not reachable");
        }


      //get User detail
     
     ResponseMessage rm = Configuration
              .getRestTemplate()
              .getForObject(Configuration.getIP() + "user/profile/" + userid, ResponseMessage.class);

          double d=FuzzySearch.ratio("mysmilarstring","myawfullysimilarstirng");
           List<UserModel>  users=  adminResponse.getUserModels()
           .stream()
           .filter(s -> !(s.getEmailId().equals(rm.getUserModel().getEmailId())))
           .collect(Collectors.toList());
       
              model.addAttribute("values", users);
              model.addAttribute("create","create");
              model.addAttribute("hashcode", HashCodeGenearate.getHashValue(rm.getUserModel().getEmailId()));
       return "index";
    }


    @PostMapping("/getUsers/sendKey")
    public String sendRequest1(
        @RequestParam("userid") String userId,
        @RequestParam("hash") String hashcode,
        @RequestParam("user") String receiverId,
        Model model
    ){
      String receiverid[]=receiverId.split(",");
      int recvid=Integer.parseInt(receiverid[0]);
      UserRequestModel urm=new UserRequestModel();
      urm.setHashCode(hashcode);
      urm.setSenderId(Integer.parseInt(userId));
      urm.setReceiveId(recvid);
      urm.setStatus("pending");
      urm.setFileId(0);
      
      long i=getSystemsRepository.count();
   int result = CreateNodes.getMali();
   int result1= CreateNodes.getMali();
   if(result==result1){
      result1= CreateNodes.getMali();
   }
   System.out.println(result+"\t"+result1);
      if(i<4){
         model.addAttribute("msg","Nodes are less than 4. Please create atleast four nodes");
      }else{

     UserRequestModel ur= userRequestRepository.save(urm);
     if(ur==null){
        model.addAttribute("msg","Request failed");
     }else{
        model.addAttribute("msg","Request failed");
     }
   }
     model.addAttribute("create","create");
        return "index";
    }
    
    
}
