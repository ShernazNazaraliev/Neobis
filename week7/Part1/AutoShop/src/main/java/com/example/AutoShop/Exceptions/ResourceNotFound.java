package com.example.AutoShop.Exceptions;

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound() {
    }

    public ResourceNotFound(String str, Long id){
        super(str + id);
    }

}