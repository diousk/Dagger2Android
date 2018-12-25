package com.example.david_chen.mydaggerdemoapplication.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;

import com.example.david_chen.mydaggerdemoapplication.App;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuilder.class,
        AppModule.class, NetworkModule.class})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {}
}
