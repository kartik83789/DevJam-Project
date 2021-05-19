package com.example.hosplus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DoctorAdapter extends BaseAdapter {

    ArrayList<Doctor> doctorArrayList;
    Context context;

    public DoctorAdapter(Context context, ArrayList<Doctor> doctorArrayList) {
        this.doctorArrayList = doctorArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return doctorArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return doctorArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.doctor_layout, parent, false);
        }
        // get current doctor to be displayed
        Doctor currentItem = (Doctor) getItem(position);

        //create reference for image,name
        ImageView doctorImage = convertView.findViewById(R.id.doctor_image);
        TextView doctorName = convertView.findViewById(R.id.doctor_name);

        //setting values
        doctorName.setText(currentItem.getName());
        Picasso.get().load(currentItem.getImage()).into(doctorImage);

        //creating a onclicklistener for card
        MaterialCardView movieCardView = convertView.findViewById(R.id.doctor_card);
        movieCardView.setOnClickListener(v -> {
            Toast.makeText(context, doctorArrayList.get(position).getName() + " tapped", Toast.LENGTH_LONG).show();
        });

        return convertView;
    }
}
