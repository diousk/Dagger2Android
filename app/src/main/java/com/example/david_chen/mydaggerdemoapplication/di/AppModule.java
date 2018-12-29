package com.example.david_chen.mydaggerdemoapplication.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.david_chen.mydaggerdemoapplication.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(App app) {
        return app.getApplicationContext();
    }

    @Provides
    @Singleton
    SharedPreferences providePrefs(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
