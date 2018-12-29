package com.example.david_chen.mydaggerdemoapplication;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.david_chen.mydaggerdemoapplication.api.WikiApi;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements MainView {

    @Inject Provider<MainPresenter> mainPresenter;
    ImageView photoImage;
    TextView titleText;

    @Inject WikiApi wikiApi;
    @Inject ConnectivityManager connectivityManager;
    @Inject WindowManager windowManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        photoImage = findViewById(R.id.photoImage);
        titleText = findViewById(R.id.titleText);
        Button fetchButton = findViewById(R.id.fetchButton);
        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.get().fetchPageId(534366);
            }
        });
    }

    @Override
    public void onPhotoFetched(String title, String url) {
        titleText.setText(title + "\n" + connectivityManager.getActiveNetworkInfo());
        Glide.with(this).load(url).into(photoImage);
    }
}
