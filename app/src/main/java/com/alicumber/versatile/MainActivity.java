package com.alicumber.versatile;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;


import com.alicumber.versatile.vip.InapppucharseActivity;
import com.google.android.material.appbar.AppBarLayout;

import java.util.Calendar;

/**
 * Author Hoangnd 22/10/2021
 */

public class MainActivity extends AppCompatActivity {
    private ImageView imagetts, imageFLL, imageWifi, ivSlient, ivVip;
    private AppBarLayout appBLU;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appBLU = (AppBarLayout) findViewById(R.id.appBarLayout);
        imageWifi = (ImageView) findViewById(R.id.iv_activity_main_iv_3g);
        imagetts = (ImageView) findViewById(R.id.iv_activity_main_iv_convert_text_to_speech);
        ivSlient = (ImageView) findViewById(R.id.iv_activity_main_iv_slient);
        imageFLL = (ImageView) findViewById(R.id.iv_activity_main_iv_flashlight);
        ivVip = (ImageView) findViewById(R.id.iv_activity_main_iv_vip);

        imagetts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TextToSpeechActivity.class);
                startActivity(intent);
            }
        });

        imageFLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FlashLightActivity.class);
                startActivity(intent);
            }
        });


        imageWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Notification3G.class);
                startActivity(intent);
            }
        });

        ivSlient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SlientModeActivity.class);
                startActivity(intent);
            }
        });
        ivVip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InapppucharseActivity.class);
                startActivity(intent);
            }
        });
    }

    public void showTimePickerDialog(View view) {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        TimePickerDialog time = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                Toast.makeText(MainActivity.this, i + ":" + i1, Toast.LENGTH_SHORT).show();
            }
        }, hour, minute, true);
        time.show();
    }

    public void showDatePickerDialog(View view) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog date = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Toast.makeText(MainActivity.this, i2 + "/" + (+i1 + 1) + "/" + i, Toast.LENGTH_SHORT).show();
            }
        }, year, month, day);
        date.show();
    }

}