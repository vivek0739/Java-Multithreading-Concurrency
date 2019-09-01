/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.tests;

import com.app.runnable.LoggingProcessor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vivekum
 */
public class TestingOtherAPI {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        List<Callable<Boolean>> callables = new ArrayList();
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        
        try {
            List<Future<Boolean>> futures = service.invokeAll(callables);
            for(Future<Boolean> future: futures) {
                System.out.println("future result value" + future.get());
            }
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(TestingOtherAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            System.out.println(service.invokeAny(callables));
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(TestingOtherAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        service.shutdown();
        try {
            System.out.println("service shut down?"+service.awaitTermination(30, TimeUnit.SECONDS));
        } catch (InterruptedException ex) {
            service.shutdownNow();
            Logger.getLogger(TestingOtherAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
}
