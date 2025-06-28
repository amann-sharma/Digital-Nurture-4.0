package com.unit.testing;

public class MyService {
    private ExternalApi externalApi;
    
    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }
    
    public String fetchData() {
        return externalApi.getData();
    }
    
    public void processData(String data) {
        externalApi.processData(data);
    }
} 