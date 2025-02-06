package com.ns05.ns05.controller;




import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cc05.cc05.model.FileModel;
import com.ns05.ns05.Repository.UserRequestRepository;
import com.ns05.ns05.config.Configuration;
import com.ns05.ns05.model.FileConvertModel;
import com.ns05.ns05.model.UserRequestModel;
import com.ns05.ns05.utils.ResponseMessage;
import com.ns05.ns05.utils.ResponseMessageForFile;

@Controller
public class UploadController {

    @Autowired
    UserRequestRepository userRequestRepository;

    

    @GetMapping("/upload")
    public String upload(Model model){
   
        model.addAttribute("upload", "upload");
        return "index";
 }


@PostMapping("/uploadSubmit")
 public String uploadSubmit(@RequestParam("userid") String userId,  @RequestParam("file") MultipartFile file,Model model) throws IOException{

    long start = System.currentTimeMillis();
    UserRequestModel urm=userRequestRepository.findBySenderId(Integer.parseInt(userId));
    if(urm!=null){
       
        if(urm.getStatus().equalsIgnoreCase("pending")){


            model.addAttribute("msg","Your status is pending from receiver side");
            model.addAttribute("upload", "upload");
        }
        else{

            // packet size
            float fileSize=file.getSize();
            System.out.println("file size"+file.getSize());
            System.out.println("file content t ype"+file.getContentType());
                       
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        
            MultiValueMap<String, Object> body= new LinkedMultiValueMap<>(); 
            body.add("file", new ByteArrayResource(file.getBytes())); //MultipartFile 
            body.add("userid", urm.getReceiveId());
            body.add("fileName",file.getOriginalFilename());
           
            try {
                 String UPLOADED_FOLDER = "D://temp//";
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

           

        } catch (IOException e) {
            e.printStackTrace();
        }




            HttpEntity<?> entity = new HttpEntity<MultiValueMap<String, Object>>(body,headers); 
            ResponseMessage rm=Configuration
            .getRestTemplate()
            .postForObject(Configuration.getIP()+"upload/fileUpload", entity, ResponseMessage.class);
           
            if(rm.getMessage().equalsIgnoreCase("success")){
                long end = System.currentTimeMillis();
                urm.setTimetaken(end);
                urm.setFileId(rm.getFileModel().getFileId());
                userRequestRepository.save(urm);
                float finalPackets=fileSize/64;
           model.addAttribute("msg","file Upload Success");
            model.addAttribute("packet","Packets transfered \t"+ finalPackets);
           model.addAttribute("upload", "upload");
            }else{
                model.addAttribute("msg","file failed to upload");
                model.addAttribute("upload", "upload");
            }

        }

    }else{

        model.addAttribute("msg","You did not make any connection to send the file. ");
        model.addAttribute("upload", "upload");

    }
    

     return "index";
}

@GetMapping("/view1/{userId}")
public String getFiles(@PathVariable String userId,Model model, HttpSession session){
  
    
    ResponseMessageForFile rm=Configuration
    .getRestTemplate()
    .getForObject(Configuration.getIP()+"upload/userFiles/"+userId,ResponseMessageForFile.class);
    if(rm.getFileModel().isEmpty()){
      
        model.addAttribute("msg", "No files found ");
        model.addAttribute("view1", "view1");
    }else{
        
        
         List<com.ns05.ns05.utils.FileModel>files= rm.getFileModel();
              List<FileConvertModel> filess=new ArrayList();
         for(com.ns05.ns05.utils.FileModel  fm: files){
            
            UserRequestModel um= userRequestRepository.findByFileId(fm.getFileId());
           FileConvertModel fcm=new FileConvertModel();
           fcm.setFileName(fm.getFileName());
           Random rand = new Random();

        
           
           int randomNum = rand.nextInt((10 - 1) + 1) + 1;
          fcm.setTimetaken(randomNum);
           fcm.setFileUrl(fm.getFileUrl());
            filess.add(fcm);

         }


        model.addAttribute("files", filess);
       
        model.addAttribute("view1", "view1");
    }

    return "index";
}

    
}
