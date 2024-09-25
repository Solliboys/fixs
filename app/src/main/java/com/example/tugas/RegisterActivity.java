package com.example.tugas;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    EditText editTextName, editTextUsername, editTextEmail, editTextPassword, editTextConfirmPassword, editTextDob, editTextPhone, editTextAddress;
    RadioGroup radioGroupGender;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ensure this matches your layout file name


        editTextName = findViewById(R.id.editTextName);
        editTextUsername = findViewById(R.id.editTextUsername); // Initialize username field
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword); // Confirm password field
        editTextDob = findViewById(R.id.editTextDob);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextAddress = findViewById(R.id.editTextAddress);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        btnRegister = findViewById(R.id.btnRegister);


        editTextDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

     r
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void showDatePickerDialog() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(RegisterActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                        String selectedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                        Log.d("RegisterActivity", "Selected date: " + selectedDate);
                        editTextDob.setText(selectedDate);
                    }
                }, year, month, day);
        datePickerDialog.show();
    }

    private void registerUser() {
        String name = editTextName.getText().toString();
        String username = editTextUsername.getText().toString(); // Capture username input
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        String confirmPassword = editTextConfirmPassword.getText().toString();
        String dob = editTextDob.getText().toString();
        String phone = editTextPhone.getText().toString();
        String address = editTextAddress.getText().toString();

        int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
        RadioButton selectedGender = findViewById(selectedGenderId);
        String gender = selectedGender != null ? selectedGender.getText().toString() : null;

        if (!name.isEmpty() && !username.isEmpty() && !email.isEmpty() && !password.isEmpty() && !dob.isEmpty() &&
                !phone.isEmpty() && !address.isEmpty() && gender != null) {

            // Check if password and confirm password match
            if (password.equals(confirmPassword)) {
                // Create an intent to send data to LoginActivity
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                intent.putExtra("nama", name);
                intent.putExtra("username", username); // Pass username to next activity
                intent.putExtra("email", email);
                intent.putExtra("password", password);
                intent.putExtra("Tgl", dob);
                intent.putExtra("No tlp", phone);
                intent.putExtra("Alamat", address);
                intent.putExtra("jenis", gender);


                startActivity(intent);
                finish();

            } else {
                Toast.makeText(RegisterActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(RegisterActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        }
    }
}
