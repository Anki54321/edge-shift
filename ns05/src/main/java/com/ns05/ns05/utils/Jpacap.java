package com.ns05.ns05.utils;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ns05.ns05.Repository.GetSystemsRepository;
import com.ns05.ns05.model.GetSystemsModel;

public class Jpacap {

    @Autowired
    GetSystemsRepository getSystemsRepository;

    public  NetworkInterface[] getDevicesList() {
        
        List<GetSystemsModel> getSystems=getSystemsRepository.findAll();
        NetworkInterface networkInterface[]=new NetworkInterface[100];
       NetworkInterface ni=null;

        for(int i=0;i<getSystems.size();i++){
           
            try {
                Connector connector=new Connector();
                GreedyAlgorithm gAlgorithm=new GreedyAlgorithm(connector);
                long node=gAlgorithm.findMostFollowersPath("node");
                networkInterface[i]=ni.getByIndex(i);
            } catch (SocketException e) {
                
                e.printStackTrace();
            }

        }

        return networkInterface;
        
    }

}
