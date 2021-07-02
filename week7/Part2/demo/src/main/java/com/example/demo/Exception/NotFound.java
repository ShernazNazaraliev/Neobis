package com.example.demo.Exception;

public class NotFound extends RuntimeException{
    public NotFound(Long id){
        super("Could not find it " +id);
    }
}
