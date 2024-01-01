package com.smartcomputers.smartproject.common.exception;

public class ResourceNotFoundException extends RuntimeException{
    private String id;
    private String resource;
    public ResourceNotFoundException(String resource,String id){
        super(resource+" with value = "+id+" not found!");
    }
}
