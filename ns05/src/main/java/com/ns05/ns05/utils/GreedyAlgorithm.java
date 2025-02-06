package com.ns05.ns05.utils;

import java.util.List;

public class GreedyAlgorithm {

    int currentLevel = 0;
    final int maxLevel = 3;
    Connector sc;
    public GreedyAlgorithm(Connector sc) {
        this.sc = sc;
    }

    public long findMostFollowersPath(String account) {
        long max = 0;
        SocialUser toFollow = null;
    
        List<SocialUser> followers = sc.getFollowers(account);
        for (SocialUser el : followers) {
            long followersCount = el.getFollowers().size();
            if (followersCount > max) {
                toFollow = el;
                max = followersCount;
            }
        }
        if (currentLevel < maxLevel - 1) {
            currentLevel++;
            max += findMostFollowersPath(toFollow.getUsername());
        } 
        return max;
    }
    
}
