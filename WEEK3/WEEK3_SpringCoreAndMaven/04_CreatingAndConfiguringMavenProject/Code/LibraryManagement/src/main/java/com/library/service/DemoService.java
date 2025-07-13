package com.library.service;

public class DemoService {
    public void doWork() {
        System.out.println("DemoService: Doing some work...");
        try { Thread.sleep(150); } catch (InterruptedException e) { }
    }
}
