package com.example.hosplus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

public class DoctorRecyclerAdapter extends FirebaseRecyclerAdapter<Doctor,DoctorRecyclerAdapter.viewHolder>
{
    public DoctorRecyclerAdapter(@NonNull @NotNull FirebaseRecyclerOptions<Doctor> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull DoctorRecyclerAdapter.viewHolder holder, int position, @NonNull @NotNull Doctor model) {
        holder.doctorName.setText(model.getName());
        Picasso.get().load(model.getImage()).into(holder.doctorImage);
    }

    @NonNull
    @NotNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_layout, parent, false);
        return new viewHolder(view);
    }

    class viewHolder extends RecyclerView.ViewHolder
    {
        //create reference for image,name
        ImageView doctorImage;
        TextView doctorName;
        public viewHolder(@NonNull @NotNull View itemView)
        {
            super(itemView);
            doctorImage = (ImageView)itemView.findViewById(R.id.doctor_image);
            doctorName = (TextView)itemView.findViewById(R.id.doctor_name);
        }
    }
}
