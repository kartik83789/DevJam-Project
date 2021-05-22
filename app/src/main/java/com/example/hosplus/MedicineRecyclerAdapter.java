package com.example.hosplus;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

public class MedicineRecyclerAdapter extends FirebaseRecyclerAdapter<Medicines,MedicineRecyclerAdapter.viewHolder> {

    public MedicineRecyclerAdapter(@NonNull @NotNull FirebaseRecyclerOptions<Medicines> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull MedicineRecyclerAdapter.viewHolder holder, int position, @NonNull @NotNull Medicines model) {

        holder.medicineName.setText(model.getName());
        Picasso.get().load(model.getImage()).into(holder.medicineImage);
        holder.medicinePrize.setText(model.getPrize());

    }

    @NonNull
    @NotNull
    @Override
    public MedicineRecyclerAdapter.viewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine_layout, parent, false);
        return new viewHolder(view);
    }

    class viewHolder extends RecyclerView.ViewHolder
    {
        //create reference for image,name
        ImageView medicineImage;
        TextView medicineName,medicinePrize;
        public viewHolder(@NonNull @NotNull View itemView)
        {
            super(itemView);
            medicineImage = (ImageView)itemView.findViewById(R.id.medicineImage);
            medicineName = (TextView)itemView.findViewById(R.id.medicineName);
            medicinePrize = (TextView)itemView.findViewById(R.id.medicinePrize);
        }
    }
}
