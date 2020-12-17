package com.example.p7day03work.utils;

public interface CallBack <T>{
    void OnSuccess(T t);

    void OnFail(String error);
}
