/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.runnable;

import com.app.beans.User;
import com.app.dao.UserDao;
import java.util.StringTokenizer;
import java.util.concurrent.Callable;

/**
 *
 * @author vivekum
 */
public class UserProcess implements Callable<Integer>{
    private String userRecord;
    private UserDao dao;

    public UserProcess(String userRecord, UserDao dao) {
        this.userRecord = userRecord;
        this.dao = dao;
    }
    
    @Override
    public Integer call() throws Exception {
        int rows = 0;
        System.out.println(Thread.currentThread().getName()+ "record for " + userRecord);
        StringTokenizer tokenenizer = new StringTokenizer(userRecord, ",");
        User user = null;
        while(tokenenizer.hasMoreElements()) {
            user = new User();
            user.setEmailAddress(tokenenizer.nextToken());
            user.setName(tokenenizer.nextToken());
            user.setId(Integer.valueOf(tokenenizer.nextToken()));
            rows = dao.saveUser(user);
        }
        return rows;
    }
        
}
