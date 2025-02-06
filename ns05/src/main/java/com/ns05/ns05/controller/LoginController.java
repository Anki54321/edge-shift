package com.ns05.ns05.controller;

import java.time.LocalDate;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.core.env.Environment;

import com.ns05.ns05.Exceptions.MyException;
import com.ns05.ns05.Repository.GetSystemsRepository;
import com.ns05.ns05.Repository.UserStatusRepository;
import com.ns05.ns05.config.Configuration;
import com.ns05.ns05.model.GetSystemsModel;
import com.ns05.ns05.model.UserModel;
import com.ns05.ns05.model.UserReport;
import com.ns05.ns05.utils.Infomation;
import com.ns05.ns05.utils.ResponseMessage;

@Controller
@SessionAttributes({ "um", "ur" })
public class LoginController {

    @Autowired
    UserStatusRepository userStatusRepository;

    @Autowired
    Environment environment;

    @Autowired
    GetSystemsRepository getSystemsRepository;

    @GetMapping("/createNode")
    public String createNode(){

          getSystemsRepository.deleteAll();
        for(int i=0;i<=100;i++){
          GetSystemsModel gsm=new GetSystemsModel();
     gsm.setPort(Integer.parseInt("808"+i));
     gsm.setUserid(i);
     getSystemsRepository.save(gsm);
        }
     
   
     return "Nodes created successfully";

    }

    @PostMapping("/loginsubmit")
    public String userLogin(
            @RequestParam("emailid") String emailid,
            @RequestParam("password") String password, Model model, HttpSession session, HttpServletRequest request)
            throws MyException {

       
        if (emailid.equalsIgnoreCase("admin@gmail.com") && password.equalsIgnoreCase("admin")) {
            model.addAttribute("home", "home");
            return "Admin";
        } else {

            UserModel um = new UserModel();
            um.setEmailId(emailid);
            um.setPassword(password);
            ResponseMessage rm = null;
            try {
                rm = Configuration
                        .getRestTemplate()
                        .postForObject(Configuration.getIP() + "user/login", um, ResponseMessage.class);
            } catch (Exception e) {
                throw new MyException("your server is not reachable");
            }
            if (rm.getMessage().equalsIgnoreCase("success")) {
                um = rm.getUserModel();

                UserReport ur = new UserReport();
                ur.setUserId(um.getUserId());
                ur.setLoginDateAndTime(LocalDate.now().toString());
                ur.setLoginStatus("1");
                ur = userStatusRepository.save(ur);
                model.addAttribute("suid", ur.getId());
                model.addAttribute("um", um);
                model.addAttribute("profile", null);
                String port = environment.getProperty("local.server.port");
                System.out.println("the port number is"+port);
                if(port.equalsIgnoreCase("8080")){
                 getSystemsRepository.deleteAll();;
                 
                 GetSystemsModel gsm=new GetSystemsModel();
                 gsm.setPort(Integer.parseInt(port));
                 gsm.setUserid(um.getUserId());
                 getSystemsRepository.save(gsm);
                }else{
                    GetSystemsModel gsm=new GetSystemsModel();
                    gsm.setPort(Integer.parseInt(port));
                    gsm.setUserid(um.getUserId());
                    getSystemsRepository.save(gsm);
                }
                return "index";
            } else {
                String info = Infomation.getErrorMessage("Emailid or password wrong");
                model.addAttribute("info", info);
                return "login";
            }

        }

    }

    @GetMapping("/profile/{userid}")
    public String checkProfile(@PathVariable String userid, Model model) {

        ResponseMessage rm=null;
        try{
       rm = Configuration
                .getRestTemplate()
                .getForObject(Configuration.getIP() + "user/profile/" + userid, ResponseMessage.class);

                if (rm.getMessage().equalsIgnoreCase("success")) {
                    model.addAttribute("um", rm.getUserModel());
                    model.addAttribute("profile", "profile");
                    return "index";
                } else {
                    model.addAttribute("error", "Error Occured ");
                    model.addAttribute("profile", "profile");
                    return "index";
                }
        }catch(Exception e){
            e.printStackTrace();
        }
        return "index";

      

    }

    @GetMapping("/logout")
    public String Logout() {
        return "login";
    }

}
