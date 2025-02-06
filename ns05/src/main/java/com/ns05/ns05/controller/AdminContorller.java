package com.ns05.ns05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ns05.ns05.Exceptions.MyException;
import com.ns05.ns05.config.Configuration;
import com.ns05.ns05.model.AdminResponse;



@Controller
public class AdminContorller {

    @GetMapping("/adminHome")
    public String adminHome(Model model) throws MyException {
        model.addAttribute("home", "home");
        return "Admin";

    }

    @GetMapping("/users")
    public String usersRecords(Model model) throws MyException {

        AdminResponse rm = null;
        try {
            rm = Configuration
                    .getRestTemplate()
                    .getForObject(Configuration.getIP() + "admin/getUsers", AdminResponse.class);
        } catch (Exception e) {
            throw new MyException("your server is not reachable");
        }

        model.addAttribute("userspage", "users");
        model.addAttribute("users", rm.getUserModels());

        return "Admin";

    }

    @GetMapping("/files")
    public String userFiles(Model model) throws MyException {

        AdminResponse rm = null;
        try {
            rm = Configuration
                    .getRestTemplate()
                    .getForObject(Configuration.getIP() + "admin/getFiles", AdminResponse.class);
        } catch (Exception e) {
            throw new MyException("your server is not reachable");
        }

        model.addAttribute("filespage", "filespage");
        model.addAttribute("files", rm.getFileModels());

        return "Admin";

    }

}
