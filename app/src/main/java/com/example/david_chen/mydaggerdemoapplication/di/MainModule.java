package com.example.david_chen.mydaggerdemoapplication.di;

import android.content.Context;
import android.net.ConnectivityManager;
import android.view.WindowManager;

import com.example.david_chen.mydaggerdemoapplication.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    @Provides
    WindowManager provideWindowManager(MainActivity activity) {
        return (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
    }

    @Provides
    ConnectivityManager provideConnectivityManager(Context context) {
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }
}
