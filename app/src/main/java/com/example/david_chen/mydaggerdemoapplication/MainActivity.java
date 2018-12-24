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
import com.example.david_chen.mydaggerdemoapplication.di.MainModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView {

    MainPresenter mainPresenter;
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
                mainPresenter.fetchPageId(534366);
            }
        });

        ((App)getApplication()).getAppComponent()
                .plusMain(new MainModule(this))
                .inject(this);

        // setup presenter
        mainPresenter = new MainPresenter(this, wikiApi);
    }

    @Override
    public void onPhotoFetched(String title, String url) {
        titleText.setText(title + "\n" + connectivityManager.getActiveNetworkInfo());
        Glide.with(this).load(url).into(photoImage);
    }
}
