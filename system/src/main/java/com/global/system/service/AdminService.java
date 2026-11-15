package com.global.system.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.system.Repository.FileRepository;
import com.global.system.Repository.Userrepository;
import com.global.system.model.FileModel;
import com.global.system.utils.AdminResponse;

@Service
public class AdminService {

    @Autowired
    Userrepository userrepository;
    @Autowired
    FileRepository fileRepository;

    public AdminResponse getUsers(){
      
        AdminResponse ar=new AdminResponse();
        ar.setMessage("success");
        ar.setUserModels(userrepository.findAll());
        return ar;
    }

    public AdminResponse getFiles(){
      
        AdminResponse ar=new AdminResponse();
        ar.setMessage("success");
        ar.setFileModels(fileRepository.findAll());
          List<FileModel> fileModel=ar.getFileModels();

          for(FileModel fileModel2:fileModel){
            checkVurnability(fileModel2.getFileName());
          }
        

        return ar;
    }

    private void checkVurnability(String fileName) {

      try                                                                                                                          
{  
File file=new File("http://localhost:8081/upload/files/testdoc.txt");    
FileReader fr=new FileReader(file);    
BufferedReader br=new BufferedReader(fr);  
StringBuffer sb=new StringBuffer();   
String line;  
while((line=br.readLine())!=null)  
{  
  System.out.println(line);
sb.append(line);     
sb.append("\n");     
}  
fr.close();   
System.out.println("Contents of File: ");  
System.out.println(sb.toString());  
}  
catch(IOException e)  
{  
e.printStackTrace();  
}    


    }
    
}
