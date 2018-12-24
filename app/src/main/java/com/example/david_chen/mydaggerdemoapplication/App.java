package com.example.david_chen.mydaggerdemoapplication;

import android.app.Application;
import android.content.SharedPreferences;

import com.example.david_chen.mydaggerdemoapplication.di.AppComponent;
import com.example.david_chen.mydaggerdemoapplication.di.AppModule;
import com.example.david_chen.mydaggerdemoapplication.di.DaggerAppComponent;
import com.example.david_chen.mydaggerdemoapplication.di.DaggerMainComponent;
import com.example.david_chen.mydaggerdemoapplication.di.MainComponent;
import com.example.david_chen.mydaggerdemoapplication.di.MainModule;
import com.example.david_chen.mydaggerdemoapplication.di.NetworkModule;

import javax.inject.Inject;

public class App extends Application {
    AppComponent appComponent;
    MainComponent mainComponent;
    @Inject
    SharedPreferences preferences;

    @Override
    public void onCreate() {
        super.onCreate();
        // setup dagger component
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
        appComponent.inject(this);

        mainComponent = DaggerMainComponent.builder()
                .mainModule(new MainModule())
                .appComponent(appComponent)
                .build();
    }

    public MainComponent getMainComponent() {
        return mainComponent;
    }
}
