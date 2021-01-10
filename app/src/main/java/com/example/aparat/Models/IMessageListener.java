package com.example.aparat.Models;

public interface IMessageListener<T> {

    public void OnSuccess(T responseMessage);

    public void OnFailer(String errorResponse);
}
