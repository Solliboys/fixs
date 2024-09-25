package com.example.tugas;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView; // Import TextView
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    Button btnLogin;
    TextView textViewEmail; // Declare TextView for displaying the email

    String registeredEmail, registeredPassword, registeredName, registeredDob, registeredPhone, registeredAddress, registeredGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Ensure this matches your layout file name

        // Initialize the UI components
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.btnLogin);
        textViewEmail = findViewById(R.id.editTextEmail); // Initialize the TextView

        // Get the data passed from RegisterActivity
        Intent intent = getIntent();
        registeredEmail = intent.getStringExtra("email");
        registeredPassword = intent.getStringExtra("password");
        registeredName = intent.getStringExtra("nama");
        registeredDob = intent.getStringExtra("Tgl");
        registeredPhone = intent.getStringExtra("No tlp");
        registeredAddress = intent.getStringExtra("Alamat");
        registeredGender = intent.getStringExtra("jenis");

        // Log the received email for debugging
        Log.d("LoginActivity", "Received email: " + registeredEmail);

        // Set the received email in the TextView
        textViewEmail.setText(registeredEmail); // Display the email

        // Set up login button click listener
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    // Method to handle login validation
    private void loginUser() {
        String inputEmail = editTextEmail.getText().toString();
        String inputPassword = editTextPassword.getText().toString();

        // Check if the entered email and password match the registered credentials
        if (inputEmail.equals(registeredEmail) && inputPassword.equals(registeredPassword)) {
            // Log the login success action
            Log.d("LoginActivity", "Login successful with email: " + inputEmail);

            // Send the user to DashboardActivity with the registered data
            Intent dashboardIntent = new Intent(LoginActivity.this, DashboardActivity.class);
            dashboardIntent.putExtra("nama", registeredName);
            dashboardIntent.putExtra("email", registeredEmail);
            dashboardIntent.putExtra("No tlp", registeredPhone);
            dashboardIntent.putExtra("Alamat", registeredAddress);
            startActivity(dashboardIntent);  // Start DashboardActivity

            finish();  // Close LoginActivity

        } else {
            // Show an invalid password dialog if credentials don't match
            showInvalidPasswordDialog();
        }
    }

    // Method to show an alert dialog when the password is incorrect
    private void showInvalidPasswordDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Password Salah")
                .setMessage("Password yang Anda masukkan salah. Apakah Anda ingin melihat daftar mahasiswa?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Move to an activity that displays the student list
                        Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();  // Close the dialog if "Tidak" is chosen
                    }
                })
                .show();
    }
}
