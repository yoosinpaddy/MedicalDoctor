package com.example.e_medics;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main3Activity extends AppCompatActivity {
    EditText address;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    Button edit;
    EditText email;
    EditText latitude;
    EditText longitude;
    EditText name;
    EditText phone;
    DatabaseReference ref = this.database.getReference("doctor");
    EditText specialization;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main3);
        this.edit = (Button) findViewById(R.id.edit);
        this.name = (EditText) findViewById(R.id.name);
        this.email = (EditText) findViewById(R.id.email);
        this.phone = (EditText) findViewById(R.id.phone);
        this.address = (EditText) findViewById(R.id.address);
        this.specialization = (EditText) findViewById(R.id.specialization);
        this.latitude = (EditText) findViewById(R.id.latitude);
        this.longitude = (EditText) findViewById(R.id.longitude);
        this.edit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (TextUtils.isEmpty(Main3Activity.this.name.getText().toString())) {
                    Toast.makeText(Main3Activity.this.getApplicationContext(), "Empty fields", 1).show();
                    Main3Activity.this.finish();
                    return;
                }
                String userId = Main3Activity.this.ref.push().getKey();
                Doctor doctor = new Doctor(Main3Activity.this.name.getText().toString().trim(), Main3Activity.this.email.getText().toString().trim(), Main3Activity.this.address.getText().toString().trim(), Main3Activity.this.phone.getText().toString().trim(), Main3Activity.this.specialization.getText().toString().trim(), Double.valueOf(Double.parseDouble(Main3Activity.this.latitude.getText().toString())), Double.valueOf(Double.parseDouble(Main3Activity.this.longitude.getText().toString())));
                Main3Activity.this.name.setText("");
                Main3Activity.this.email.setText("");
                Main3Activity.this.address.setText("");
                Main3Activity.this.phone.setText("");
                Main3Activity.this.specialization.setText("");
                Main3Activity.this.latitude.setText("");
                Main3Activity.this.longitude.setText("");
                Main3Activity.this.ref.child(userId).setValue(doctor);
            }
        });
    }
}
