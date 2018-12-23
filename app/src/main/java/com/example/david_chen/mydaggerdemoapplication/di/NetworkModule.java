package com.example.david_chen.mydaggerdemoapplication.di;

import android.content.Context;

import com.example.david_chen.mydaggerdemoapplication.R;
import com.example.david_chen.mydaggerdemoapplication.api.WikiApi;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(1200, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Context context, OkHttpClient okHttpClient) {
        String hostAddress = context.getString(R.string.server_address);
        return new Retrofit.Builder()
                .baseUrl(hostAddress)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
    }

    @Provides
    @Singleton
    WikiApi provideWikiApi(Retrofit retrofit) {
        return retrofit.create(WikiApi.class);
    }
}
