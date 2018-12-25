package com.example.david_chen.mydaggerdemoapplication.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.david_chen.mydaggerdemoapplication.App;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    Context provideContext(App app) {
        return app.getApplicationContext();
    }

    @Provides
    SharedPreferences providePrefs(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
