package com.example.david_chen.mydaggerdemoapplication.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context context;
    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    public SharedPreferences providePrefs() {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
