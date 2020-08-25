package com.example.e_medics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PatientLandingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_landing_page);
    }
    public void logout(View view){
        startActivity(new Intent(this, MainActivity.class));
    }
}