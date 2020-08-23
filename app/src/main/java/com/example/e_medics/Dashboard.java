package com.example.e_medics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Dashboard extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_dashboard);
        ((ImageButton) findViewById(R.id.feedback)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Dashboard.this.startActivity(new Intent(Dashboard.this.getApplicationContext(), Feedback.class));
            }
        });
        ((ImageButton) findViewById(R.id.reservation)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Dashboard.this.startActivity(new Intent(Dashboard.this.getApplicationContext(), Reservation.class));
            }
        });
        ((ImageButton) findViewById(R.id.service)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Dashboard.this.startActivity(new Intent(Dashboard.this.getApplicationContext(), Service.class));
            }
        });
        ((ImageButton) findViewById(R.id.maps)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Dashboard.this.startActivity(new Intent(Dashboard.this.getApplicationContext(), Facilities.class));
            }
        });
        ((ImageButton) findViewById(R.id.profile)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Dashboard.this.startActivity(new Intent(Dashboard.this.getApplicationContext(), Profile.class));
            }
        });
        ((ImageButton) findViewById(R.id.doctor)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Dashboard.this.startActivity(new Intent(Dashboard.this.getApplicationContext(), DoctorLocation.class));
            }
        });
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
    }
}
