/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.runnable;

/**
 *
 * @author vivekum
 */
public class AppRunnable implements Runnable {
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet");
    }
    
    public static void main(String[] args) {
        AppRunnable  runnable = new AppRunnable();
    }
}
