/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.tests;

import com.app.runnable.AppThread;

/**
 *
 * @author vivekum
 */
public class TestThreads {
    
    public static void main(String[] args) {
        AppThread thread1 = new AppThread();
        AppThread thread2 = new AppThread();
        AppThread thread3 = new AppThread();
        AppThread thread4 = new AppThread();
        
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        
        
    }
    
}
