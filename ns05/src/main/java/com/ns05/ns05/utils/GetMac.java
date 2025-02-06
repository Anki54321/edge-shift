package com.ns05.ns05.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class GetMac {

    public static String getmacaddress() throws UnknownHostException, SocketException{
        InetAddress localHost = InetAddress.getLocalHost();
NetworkInterface ni = NetworkInterface.getByInetAddress(localHost);
byte[] hardwareAddress = ni.getHardwareAddress();
String[] hexadecimal = new String[hardwareAddress.length];
for (int i = 0; i < hardwareAddress.length; i++) {
    hexadecimal[i] = String.format("%02X", hardwareAddress[i]);
}
String macAddress = String.join("-", hexadecimal);
return macAddress;

    }

    public static String getIpaddress() throws UnknownHostException{

        InetAddress localHost = InetAddress.getLocalHost();
        return localHost.getHostAddress();
    }
    
}
