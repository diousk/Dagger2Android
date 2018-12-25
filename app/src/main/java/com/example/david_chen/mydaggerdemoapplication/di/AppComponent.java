package com.example.david_chen.mydaggerdemoapplication.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;

import com.example.david_chen.mydaggerdemoapplication.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(App app);

    @Component.Builder
    interface Builder {
        @BindsInstance Builder application(App app);
        AppComponent build();
    }

    // for child components use '@Subcomponent'
    MainComponent.Builder mainBuilder();
}
