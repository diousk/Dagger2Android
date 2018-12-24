package com.example.david_chen.mydaggerdemoapplication.di;

import android.content.Context;
import android.net.ConnectivityManager;
import android.view.WindowManager;

import com.example.david_chen.mydaggerdemoapplication.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    private MainActivity activity;

    public MainModule(MainActivity activity) {
        this.activity = activity;
    }

    @Provides
    WindowManager provideWindowManager() {
        return (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
    }

    @Provides
    ConnectivityManager provideConnectivityManager(Context context) {
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }
}
