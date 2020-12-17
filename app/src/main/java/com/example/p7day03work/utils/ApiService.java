package com.example.p7day03work.utils;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

public interface ApiService {

    @GET("http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1")
    Observable<ResponseBody> get();
}
