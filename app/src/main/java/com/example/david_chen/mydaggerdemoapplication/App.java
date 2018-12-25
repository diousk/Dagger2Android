package com.example.david_chen.mydaggerdemoapplication;

import android.app.Application;
import android.content.SharedPreferences;

import com.example.david_chen.mydaggerdemoapplication.di.AppComponent;
import com.example.david_chen.mydaggerdemoapplication.di.AppModule;
import com.example.david_chen.mydaggerdemoapplication.di.DaggerAppComponent;
import com.example.david_chen.mydaggerdemoapplication.di.MainComponent;
import com.example.david_chen.mydaggerdemoapplication.di.MainModule;
import com.example.david_chen.mydaggerdemoapplication.di.NetworkModule;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class App extends DaggerApplication {
    @Inject SharedPreferences preferences;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }
}
