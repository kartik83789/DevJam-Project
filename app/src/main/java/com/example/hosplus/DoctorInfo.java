package com.example.hosplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DoctorInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_info);

        //retrieving data from intent
        Intent intent = getIntent();
        String doctorName = intent.getStringExtra("doctorName");
        String doctorImage = intent.getStringExtra("doctorImage");
        String doctorInfo = intent.getStringExtra("doctorInfo");
        String doctorSpeciality = intent.getStringExtra("doctorSpeciality");

    }
}