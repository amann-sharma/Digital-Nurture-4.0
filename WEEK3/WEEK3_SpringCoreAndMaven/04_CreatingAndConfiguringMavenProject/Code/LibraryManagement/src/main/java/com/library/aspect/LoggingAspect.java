package com.library.aspect;

public class LoggingAspect {
    
    public void beforeMethod() {
        System.out.println("[AOP] Before method execution");
    }
    
    public void afterMethod() {
        System.out.println("[AOP] After method execution");
    }
    
    public void aroundMethod() {
        System.out.println("[AOP] Around method execution");
    }
}
