package com.example.p7day03work.base;

public class BasePresenter <P extends BaseView>{
    public P Iviews;

   public void attachView(P p){
       Iviews=p;
   }
}
