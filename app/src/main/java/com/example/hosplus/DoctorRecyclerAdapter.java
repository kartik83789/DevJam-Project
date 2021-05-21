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

public class DoctorRecyclerAdapter extends FirebaseRecyclerAdapter<Doctor,DoctorRecyclerAdapter.viewHolder>
{
    Context context;

    public DoctorRecyclerAdapter(@NonNull @NotNull FirebaseRecyclerOptions<Doctor> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull DoctorRecyclerAdapter.viewHolder holder, int position, @NonNull @NotNull Doctor model) {
        holder.doctorName.setText(model.getName());
        Picasso.get().load(model.getImage()).into(holder.doctorImage);
        holder.doctorSpeciality.setText(model.getSpeciality());

        holder.doctorCard.setOnClickListener(v -> {
            Intent intent = new Intent(context, DoctorInfo.class);
            intent.putExtra("doctorName", model.getName());
            intent.putExtra("doctorImage", model.getImage());
            intent.putExtra("doctorSpeciality", model.getSpeciality());
            intent.putExtra("doctorInfo", model.getInfo());
            intent.putExtra("doctorMail",model.getMail());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });

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
        TextView doctorName,doctorSpeciality;
        CardView doctorCard;
        public viewHolder(@NonNull @NotNull View itemView)
        {
            super(itemView);
            doctorCard = (CardView)itemView.findViewById(R.id.doctor_card);
            doctorImage = (ImageView)itemView.findViewById(R.id.doctor_image);
            doctorName = (TextView)itemView.findViewById(R.id.doctor_name);
            doctorSpeciality = (TextView)itemView.findViewById(R.id.doctor_speciality);
        }
    }
}
