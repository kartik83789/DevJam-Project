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

public class Medicine extends AppCompatActivity {

    RecyclerView medicineList;
    MedicineRecyclerAdapter medicineAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        FirebaseRecyclerOptions<Medicines> options =
                new FirebaseRecyclerOptions.Builder<Medicines>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("medicines"), Medicines.class)
                        .build();

        medicineAdapter = new MedicineRecyclerAdapter(options);

        //setting recyclerview
        medicineList = (RecyclerView) findViewById(R.id.medicine_list);
        medicineList.setLayoutManager(new LinearLayoutManager(this));

        medicineList.setAdapter(medicineAdapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        medicineAdapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        medicineAdapter.stopListening();
    }

}