package com.example.david_chen.mydaggerdemoapplication.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;

import com.example.david_chen.mydaggerdemoapplication.App;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(App app);

    @Component.Builder
    interface Builder {
        Builder appModule(AppModule appModule);
        Builder networkModule(NetworkModule networkModule);
        AppComponent build();
    }

    // for child components use '@Subcomponent'
    MainComponent plusMain(MainModule mainModule);
}
