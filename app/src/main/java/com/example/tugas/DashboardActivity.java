package com.example.tugas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    TextView textViewProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        textViewProfile = findViewById(R.id.textViewProfile);

        Intent intent = getIntent();
        String name = intent.getStringExtra("nama");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("No tlp");
        String address = intent.getStringExtra("Alamat");



        Log.d("DashboardActivity", "Received data: " + name + ", " + email + ", " + ", " + phone + ", " + address );


        String profileInfo =
                "Nama   : " + (name != null ? name : "N/A") + "\n" +
                "Email  : " + (email != null ? email : "N/A") + "\n" +
                "No tlp : " + (phone != null ? phone : "N/A") + "\n" +
                "Alamat : " + (address != null ? address : "N/A");
        textViewProfile.setText(profileInfo);
    }
}
