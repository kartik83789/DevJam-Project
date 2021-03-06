package com.example.hosplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    CardView doctorCard, aboutCard, locationCard, scheduleCard, medicineCard,ambulanceCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating object of cards

        doctorCard = findViewById(R.id.doctorCard);
        scheduleCard = findViewById(R.id.ScheduleCard);
        locationCard = findViewById(R.id.locationCard);
        aboutCard = findViewById(R.id.aboutCard);
        medicineCard = findViewById(R.id.medicineCard);
        ambulanceCard = findViewById(R.id.ambulanceCard);



        //creating intent for each card

        doctorCard.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), DoctorsList.class);
            startActivity(intent);
        });
        scheduleCard.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Schedule.class);
            startActivity(intent);
        });
        locationCard.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Location.class);
            startActivity(intent);
        });
        aboutCard.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), AboutUs.class);
            startActivity(intent);
        });
        medicineCard.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Medicine.class);
            startActivity(intent);
        });
        ambulanceCard.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Ambulance.class);
            startActivity(intent);
        });

    }
}