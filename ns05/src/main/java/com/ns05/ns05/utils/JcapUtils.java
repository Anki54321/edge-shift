package com.ns05.ns05.utils;

import java.net.NetworkInterface;

public class JcapUtils {

    public  NetworkInterface[] getJpacap(){

        int a[]=new int[100];
        Jpacap jpacap=new Jpacap();
      NetworkInterface[] devices =jpacap.getDevicesList();
       BinarySearch binarySearch=new BinarySearch();
       binarySearch.binarySearch(a, 1, 100, 878);
       return devices;
    }
    
}
