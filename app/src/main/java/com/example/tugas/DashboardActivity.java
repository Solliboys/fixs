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
        setContentView(R.layout.activity_dashboard); // Ensure this layout file exists and contains textViewProfile

        // Initialize TextView
        textViewProfile = findViewById(R.id.textViewProfile);

        // Get data from Intent sent by RegisterActivity
        Intent intent = getIntent();
        String name = intent.getStringExtra("nama");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("No tlp");
        String address = intent.getStringExtra("Alamat");


        // Log the received data for debugging purposes
        Log.d("DashboardActivity", "Received data: " + name + ", " + email + ", " + ", " + phone + ", " + address );

        // Create the profile information string and display it in textViewProfile
        String profileInfo =
                "Nama   : " + (name != null ? name : "N/A") + "\n" +
                "Email  : " + (email != null ? email : "N/A") + "\n" +
                "No tlp : " + (phone != null ? phone : "N/A") + "\n" +
                "Alamat : " + (address != null ? address : "N/A");
        textViewProfile.setText(profileInfo);
    }
}
