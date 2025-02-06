package com.cc05.cc05.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cc05.cc05.model.ItemSetModel;

@Controller
public class CC05Controller {


    @GetMapping("/extractForm")
    public String extractForm(Model model){
     
        model.addAttribute("extract","extract");
        return "index";

    }

    @PostMapping("/extract")
    public String extract(Model model,
    @RequestParam("value1") String value1,
     @RequestParam("value2")String value2) throws NumberFormatException, IOException{
             
      //  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int noOfTransactions,minimumSupport;
		double minimumConfidence;
		String sampleFile = "D:\\projects\\shyam projects\\cc05\\src\\main\\resources\\static\\dataset.txt";
		List<String> transactions = new ArrayList<String>();
		
		String newLine = System.getProperty("line.separator");
		
		System.out.println(newLine+"'APRIORI ALGORITHM'"); 
		System.out.print("Enter the Minimum Support = ");



        
		minimumSupport = Integer.parseInt(value1); 
		System.out.print("Enter the Minimum Confidence (in %) = ");	
		minimumConfidence = Double.parseDouble(value2);
		minimumConfidence = minimumConfidence/100;
		
		File file = new File(sampleFile);
		Scanner sc = new Scanner(file);
		
		while (sc.hasNextLine())
		{
			String str = sc.nextLine();
			transactions.add(str);
		}
	
		noOfTransactions = transactions.size();
		
		ApriorAlogitham a = new ApriorAlogitham();
		ItemSetModel values=a.display(noOfTransactions, transactions, minimumSupport, minimumConfidence);
        sc.close();
        model.addAttribute("values", values);
        model.addAttribute("extractresult","extractresult");
        return "index";

    }

	@GetMapping("/negativeForm")
    public String negativeForm(Model model){
     
        model.addAttribute("negativeForm","negativeForm");
        return "index";

    }

	@PostMapping("/negative")
    public String negative(Model model,
    @RequestParam("value1") String value1,
     @RequestParam("value2")String value2) throws NumberFormatException, IOException{
             
      //  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int noOfTransactions,minimumSupport;
		double minimumConfidence;
		String sampleFile = "D:\\projects\\shyam projects\\cc05\\src\\main\\resources\\static\\dataset.txt";
		List<String> transactions = new ArrayList<String>();
		
		String newLine = System.getProperty("line.separator");
		
		System.out.println(newLine+"'APRIORI ALGORITHM'"); 
		System.out.print("Enter the Minimum Support = ");



        
		minimumSupport = Integer.parseInt(value1); 
		System.out.print("Enter the Minimum Confidence (in %) = ");	
		minimumConfidence = Double.parseDouble(value2);
		minimumConfidence = minimumConfidence/100;
		
		File file = new File(sampleFile);
		Scanner sc = new Scanner(file);
		
		while (sc.hasNextLine())
		{
			String str = sc.nextLine();
			transactions.add(str);
		}
	
		noOfTransactions = transactions.size();
		
		NegativeRuleAlogirtham a = new NegativeRuleAlogirtham();
		Map<String,Integer> values=a.display(noOfTransactions, transactions, minimumSupport, minimumConfidence);
        sc.close();
        model.addAttribute("values", values);
        model.addAttribute("negative","negative");
        return "index";

    }


    
}
