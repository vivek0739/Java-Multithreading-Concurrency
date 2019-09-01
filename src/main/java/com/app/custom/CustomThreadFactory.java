/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.custom;

import java.util.concurrent.ThreadFactory;

/**
 *
 * @author vivekum
 */
public class CustomThreadFactory implements ThreadFactory{

    public static int counter = 0;
    @Override
    public Thread newThread(Runnable r) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Thread thread = new Thread(r);
        thread.setName("Custom Thread"+ counter++);
        return thread;
    }
    
}
