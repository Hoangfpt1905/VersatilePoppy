package com.alicumber.versatile;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SlientModeActivity extends AppCompatActivity {
        private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slient_mode);
            audioManager =(AudioManager)getSystemService(Context.AUDIO_SERVICE);
    }
    public void TorchRingButtonClick(View view) {
        audioManager.setRingerMode(2);
    }

    public void TorchSlientButtonClick(View view) {
        audioManager.setRingerMode(1);
    }


}