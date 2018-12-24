package com.example.david_chen.mydaggerdemoapplication.di;

import com.example.david_chen.mydaggerdemoapplication.MainActivity;

import dagger.Component;

@MainScope
@Component(dependencies = AppComponent.class , modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
