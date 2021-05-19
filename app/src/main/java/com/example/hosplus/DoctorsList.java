package com.example.hosplus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class DoctorsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_list);

        FirebaseApp.initializeApp(this);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();

        ArrayList<Doctor> list = new ArrayList<>();

        for (int i=1 ;i < 8; ++i){
            DatabaseReference getDoctor = databaseReference.child("doctors").child("doctor" + i);
            
        };


        DoctorAdapter doctorAdapter = new DoctorAdapter(this, list);

        ListView doctorList = findViewById(R.id.doctor_list);
        doctorList.setAdapter(doctorAdapter);


    }
}