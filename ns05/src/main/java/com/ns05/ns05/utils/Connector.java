package com.ns05.ns05.utils;

import java.util.ArrayList;
import java.util.List;

public class Connector {
    private boolean isCounterEnabled = true;
    private int counter = 4;
    
    List<SocialUser> users;



    public Connector() {
        users = new ArrayList<>();
    }

    public boolean switchCounter() {
        this.isCounterEnabled = !this.isCounterEnabled;
        return this.isCounterEnabled;
    }

    public List getFollowers(String account) {
        if (counter < 0) {
            throw new IllegalStateException ("Node as problem");
        } else {
            if (this.isCounterEnabled) {
                counter--;
            }
            for (SocialUser user : users) {
                if (user.getUsername().equals(account)) {
                    return user.getFollowers();
                }
            }
         }
         return new ArrayList<>();
    }

    public boolean isCounterEnabled() {
        return isCounterEnabled;
    }

    public void setCounterEnabled(boolean isCounterEnabled) {
        this.isCounterEnabled = isCounterEnabled;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public List<SocialUser> getUsers() {
        return users;
    }

    public void setUsers(List<SocialUser> users) {
        this.users = users;
    }
    
    
}

