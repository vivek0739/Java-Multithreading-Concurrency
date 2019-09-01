/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.tests;

import com.app.dao.UserDao;
import com.app.runnable.AppThread;
import com.app.runnable.UserProcess;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vivekum
 */
public class TestExecutors {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        List<String> users = getUserFromFile("/Users/vivekum/Downloads/Ex_Files_Java_EE_Concurrency/Exercise Files/Chapter3/03_04/begin/new_users.txt");
        UserDao dao = new UserDao();
        users.forEach((user) -> {
            Future<Integer> future  = service.submit(new UserProcess(user, dao));
            try {
                System.out.println("Result of operation is:" + future.get());
            } catch (InterruptedException ex) {
                Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        service.shutdown();
        System.out.println("Main execution over");
    }
    
    public static List<String> getUserFromFile(String fileName) {
        List<String> users = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
          
            String line;
            while((line = reader.readLine()) != null) {
                users.add(line);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
}
