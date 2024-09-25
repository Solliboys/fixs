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
    TextView textViewEmail;

    String registeredEmail, registeredPassword, registeredName, registeredDob, registeredPhone, registeredAddress, registeredGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Ensure this matches your layout file name


        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.btnLogin);
        textViewEmail = findViewById(R.id.editTextEmail); // Initialize the TextView

        Intent intent = getIntent();
        registeredEmail = intent.getStringExtra("email");
        registeredPassword = intent.getStringExtra("password");
        registeredName = intent.getStringExtra("nama");
        registeredDob = intent.getStringExtra("Tgl");
        registeredPhone = intent.getStringExtra("No tlp");
        registeredAddress = intent.getStringExtra("Alamat");
        registeredGender = intent.getStringExtra("jenis");

        Log.d("LoginActivity", "Received email: " + registeredEmail);


        textViewEmail.setText(registeredEmail);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        String inputEmail = editTextEmail.getText().toString();
        String inputPassword = editTextPassword.getText().toString();


        if (inputEmail.equals(registeredEmail) && inputPassword.equals(registeredPassword)) {

            Log.d("LoginActivity", "Login successful with email: " + inputEmail);

            Intent dashboardIntent = new Intent(LoginActivity.this, DashboardActivity.class);
            dashboardIntent.putExtra("nama", registeredName);
            dashboardIntent.putExtra("email", registeredEmail);
            dashboardIntent.putExtra("No tlp", registeredPhone);
            dashboardIntent.putExtra("Alamat", registeredAddress);
            startActivity(dashboardIntent);  // Start DashboardActivity

            finish();

        } else {

            showInvalidPasswordDialog();
        }
    }


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
