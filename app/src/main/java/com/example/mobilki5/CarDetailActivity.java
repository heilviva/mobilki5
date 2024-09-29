package com.example.mobilki5;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class CarDetailActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private static final String TAG = "CarDetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);

        VideoView videoView = findViewById(R.id.videoView);
        TextView makeTextView = findViewById(R.id.makeTextView);
        TextView modelTextView = findViewById(R.id.modelTextView);
        TextView yearTextView = findViewById(R.id.yearTextView);
        TextView infoTextView = findViewById(R.id.infoTextView);

        int carVideo = getIntent().getIntExtra("carVideo", 0);
        int carAudio = getIntent().getIntExtra("carAudio", 0);
        String carMake = getIntent().getStringExtra("carMake");
        String carModel = getIntent().getStringExtra("carModel");
        int carYear = getIntent().getIntExtra("carYear", 0);
        String carInfo = getIntent().getStringExtra("carInfo");

        makeTextView.setText(carMake);
        modelTextView.setText(carModel);
        yearTextView.setText(String.valueOf(carYear));
        infoTextView.setText(carInfo);

        if (carVideo != 0) {
            String videoPath = "android.resource://" + getPackageName() + "/" + carVideo;
            videoView.setVideoPath(videoPath);
            videoView.setOnErrorListener((mp, what, extra) -> {
                Log.e(TAG, "Error loading video: " + what + ", " + extra);
                return true;
            });
            videoView.start();
        }

        if (carAudio != 0) {
            mediaPlayer = MediaPlayer.create(this, carAudio);
            mediaPlayer.setOnErrorListener((mp, what, extra) -> {
                Log.e(TAG, "Error loading audio: " + what + ", " + extra);
                return true;
            });
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}