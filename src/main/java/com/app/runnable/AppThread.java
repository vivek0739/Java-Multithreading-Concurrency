/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.runnable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vivekum
 */
public class AppThread extends Thread {
    @Override
    public void run() {
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("/Users/vivekum/Downloads/Ex_Files_Java_EE_Concurrency/Exercise Files/Chapter2/02_03/begin/sample.txt")))) {
          
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(Thread.currentThread().getName() +  " reading the line " + line);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AppThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
