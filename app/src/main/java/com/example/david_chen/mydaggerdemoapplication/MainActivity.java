package com.example.david_chen.mydaggerdemoapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.david_chen.mydaggerdemoapplication.api.WikiApi;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MainView {

    MainPresenter mainPresenter;
    ImageView photoImage;
    TextView titleText;

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

        // setup presenter
        String awsAddress = getString(R.string.server_address);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(awsAddress)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
        WikiApi wikiApi = retrofit.create(WikiApi.class);
        // a real world presenter is more complex than this one
        mainPresenter = new MainPresenter(this, wikiApi);
    }

    @Override
    public void onPhotoFetched(String title, String url) {
        titleText.setText(title);
        Glide.with(this).load(url).into(photoImage);
    }
}