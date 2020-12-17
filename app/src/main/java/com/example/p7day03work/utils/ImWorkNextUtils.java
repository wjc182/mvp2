package com.example.p7day03work.utils;

import com.example.p7day03work.contract.MainContract;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class ImWorkNextUtils implements MainContract.IModel {
   private static volatile ImWorkNextUtils imWorkNextUtils;
    private final ApiService apiService;

    public ImWorkNextUtils() {
        apiService = new Retrofit.Builder()
                .baseUrl(URLConstance.BaseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class);
    }

    public static ImWorkNextUtils getInstance(){
       if(imWorkNextUtils==null){
           synchronized (ImWorkNextUtils.class){
               if(imWorkNextUtils==null){
                   imWorkNextUtils=new ImWorkNextUtils();
               }
           }
       }
       return imWorkNextUtils;
   }


    @Override
    public <T> void getModel(String url, CallBack<T> callBack) {
            apiService.get()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<ResponseBody>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull ResponseBody responseBody) {
                            try {
                                String string = responseBody.string();

                                Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();

                                Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();

                                Type t = actualTypeArguments[0];

                                Gson gson = new Gson();
                                T json = gson.fromJson(string, t);

                                callBack.OnSuccess(json);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            callBack.OnFail("网络异常"+e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
    }
}
