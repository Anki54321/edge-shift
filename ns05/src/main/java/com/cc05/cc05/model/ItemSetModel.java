package com.cc05.cc05.model;

import java.util.List;

public class ItemSetModel {

    private int NoOfitems;
    private int transactions;
    private int support;
    private double confidence;
    
    private List<String> items;
    public int getNoOfitems() {
        return NoOfitems;
    }
    public void setNoOfitems(int noOfitems) {
        NoOfitems = noOfitems;
    }
    public int getTransactions() {
        return transactions;
    }
    public void setTransactions(int transactions) {
        this.transactions = transactions;
    }
    public int getSupport() {
        return support;
    }
    public void setSupport(int support) {
        this.support = support;
    }
    public double getConfidence() {
        return confidence;
    }
    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }
    public List<String> getItems() {
        return items;
    }
    public void setItems(List<String> items) {
        this.items = items;
    }

  


    

    
}
