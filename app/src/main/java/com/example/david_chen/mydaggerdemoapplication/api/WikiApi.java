package com.example.david_chen.mydaggerdemoapplication.api;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WikiApi {
    @GET("api.php?action=query&prop=info|pageimages&pithumbsize=500&format=json&inprop=url")
    Single<PageResponse> getPage(@Query("pageids") int pageId);
}
