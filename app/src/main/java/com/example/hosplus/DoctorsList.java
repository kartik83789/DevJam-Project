package com.example.hosplus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import com.firebase.ui.database.FirebaseListOptions;
import com.firebase.ui.database.FirebaseRecyclerOptions;
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
    RecyclerView doctorList;
    DoctorRecyclerAdapter doctorAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_list);

        FirebaseRecyclerOptions<Doctor> options =
                new FirebaseRecyclerOptions.Builder<Doctor>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("doctors"), Doctor.class)
                        .build();

        doctorAdapter = new DoctorRecyclerAdapter(options,this);

        //setting recyclerview
        doctorList = (RecyclerView) findViewById(R.id.doctor_list);
        doctorList.setLayoutManager(new LinearLayoutManager(this));

        doctorList.setAdapter(doctorAdapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        doctorAdapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        doctorAdapter.stopListening();
    }
}