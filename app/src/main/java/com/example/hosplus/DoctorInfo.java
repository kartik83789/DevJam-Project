package com.example.hosplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DoctorInfo extends AppCompatActivity {
    TextView doctorNm, doctorIn, doctorSp;
    ImageView doctorIm;
    Button contactBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_info);

        //retrieving data from intent
        Intent intent = getIntent();
        String doctorName = intent.getStringExtra("doctorName");
        String doctorImage = intent.getStringExtra("doctorImage");
        String doctorInfo = intent.getStringExtra("doctorInfo");
        String doctorMail = intent.getStringExtra("doctorMail");
        String doctorSpeciality = intent.getStringExtra("doctorSpeciality");

        doctorNm = findViewById(R.id.doctorNm);
        doctorIm = findViewById(R.id.doctorIm);
        doctorIn = findViewById(R.id.doctorIn);
        doctorSp = findViewById(R.id.doctorSp);
        contactBtn = findViewById(R.id.contactButton);

        doctorNm.setText(doctorName);
        doctorSp.setText(doctorSpeciality);
        doctorIn.setText(doctorInfo);
        Picasso.get().load(doctorImage).into(doctorIm);

        contactBtn.setOnClickListener(v -> {
            Intent intent1 = new Intent(Intent.ACTION_SENDTO);
            intent1.setData(Uri.parse("mailto:"));
            intent1.putExtra(Intent.EXTRA_EMAIL, doctorMail+"");
            intent1.putExtra(Intent.EXTRA_SUBJECT, "Create my appointment");
            if ( intent1.resolveActivity(getPackageManager()) != null){
                startActivity(intent1);
            };
        });


    }
}