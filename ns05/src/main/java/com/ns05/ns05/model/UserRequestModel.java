package com.ns05.ns05.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserRequestModel {

    @Id
    @GeneratedValue
    int id;
    int senderId;
    int receiveId;
    String status;
    int fileId;
    String hashCode;
    String macaddress;
    String ipaddress;
    double timetaken;

    
    
    public String getMacaddress() {
        return macaddress;
    }
    public void setMacaddress(String macaddress) {
        this.macaddress = macaddress;
    }
    public String getIpaddress() {
        return ipaddress;
    }
    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getSenderId() {
        return senderId;
    }
    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }
    public int getReceiveId() {
        return receiveId;
    }
    public void setReceiveId(int receiveId) {
        this.receiveId = receiveId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getFileId() {
        return fileId;
    }
    public void setFileId(int fileId) {
        this.fileId = fileId;
    }
    public String getHashCode() {
        return hashCode;
    }
    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }
    public double getTimetaken() {
        return timetaken;
    }
    public void setTimetaken(double timetaken) {
        this.timetaken = timetaken;
    }


    
    
}
