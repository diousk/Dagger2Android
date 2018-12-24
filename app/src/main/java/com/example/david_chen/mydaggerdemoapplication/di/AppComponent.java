package com.example.david_chen.mydaggerdemoapplication.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;

import com.example.david_chen.mydaggerdemoapplication.App;
import com.example.david_chen.mydaggerdemoapplication.api.WikiApi;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(App app);
    // for child components use 'dependencies at @Component'
    WikiApi wikiApi();
    Context context();
    SharedPreferences sharedPreferences();
}
