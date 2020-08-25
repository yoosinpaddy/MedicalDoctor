package com.example.e_medics;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddDoctors extends AppCompatActivity {
    Button add;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    EditText name;
    EditText email;
    EditText address;
    EditText phone;
    EditText special;
    EditText lat;
    EditText longitude;
    DatabaseReference ref = this.database.getReference("doctor");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_add_doctors);
        this.name = (EditText) findViewById(R.id.name);
        this.email = (EditText) findViewById(R.id.email);
        this.address = (EditText) findViewById(R.id.location);
        this.phone = (EditText) findViewById(R.id.phone);
        this.special = (EditText) findViewById(R.id.specialization);
        this.lat = (EditText) findViewById(R.id.lat);
        this.longitude = (EditText) findViewById(R.id.log);
        this.add = (Button) findViewById(R.id.addfacilities);
        this.add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String userId = AddDoctors.this.ref.push().getKey();
                AddDoctors.this.ref.child(userId).setValue(new Doctor(AddDoctors.this.name.getText().toString(), AddDoctors.this.email.getText().toString(), AddDoctors.this.address.getText().toString(), phone.getText().toString(),special.getText().toString(), Double.valueOf(Double.parseDouble(AddDoctors.this.lat.getText().toString())), Double.valueOf(Double.parseDouble(AddDoctors.this.longitude.getText().toString()))));
                Toast.makeText(AddDoctors.this.getApplicationContext(), "Successful", 0).show();
            }
        });
    }
}
