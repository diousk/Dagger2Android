package com.example.david_chen.mydaggerdemoapplication.di;

import com.example.david_chen.mydaggerdemoapplication.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @MainScope
    @ContributesAndroidInjector(modules = {MainModule.class})
    abstract MainActivity mainActivity();
}
