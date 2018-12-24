package com.example.david_chen.mydaggerdemoapplication.di;

import com.example.david_chen.mydaggerdemoapplication.MainActivity;

import dagger.Subcomponent;

@Subcomponent(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
