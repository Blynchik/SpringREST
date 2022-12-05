package com.example.demo.util;

public class EntityErrorResponse {

    private String message;
    private long timestamp;

    public EntityErrorResponse(String message, long timestamp){
        this.message = message;
        this.timestamp = timestamp;
    }
}
