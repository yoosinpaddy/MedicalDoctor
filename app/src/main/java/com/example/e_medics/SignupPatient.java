package com.example.e_medics;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupPatient extends AppCompatActivity {
    Button add;
    FirebaseAuth auth;
    private static final String TAG = "Signup";
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    EditText name;
    EditText email;
    EditText phone;
    EditText location;
    EditText specialist;
    DatabaseReference ref = this.database.getReference("patients");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.register_patient);
        this.name = (EditText) findViewById(R.id.name);
        this.email = (EditText) findViewById(R.id.email);
        this.phone = (EditText) findViewById(R.id.phone);
        this.location = (EditText) findViewById(R.id.location);
        this.specialist = (EditText) findViewById(R.id.specialist_name);
        this.add = (Button) findViewById(R.id.addfacilities);
        this.add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String userId = ref.push().getKey();
                ref.child(userId).setValue(new PatientModel(name.getText().toString(), email.getText().toString(), phone.getText().toString(),  location.getText().toString(), specialist.getText().toString())).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(), "Successful", 0).show();
                        name.setText("");
                        email.setText("");
                        phone.setText("");
                        location.setText("");
                        specialist.setText("");
                    }
                });
            }
        });
    }
}
