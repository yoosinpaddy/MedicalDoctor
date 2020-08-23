package com.example.e_medics;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddFacilities extends AppCompatActivity {
    Button add;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    EditText lat;
    EditText location;
    EditText longitude;
    EditText name;
    DatabaseReference ref = this.database.getReference("facilities");
    EditText town;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_add_facilities);
        this.name = (EditText) findViewById(R.id.name);
        this.location = (EditText) findViewById(R.id.location);
        this.town = (EditText) findViewById(R.id.town);
        this.lat = (EditText) findViewById(R.id.lat);
        this.longitude = (EditText) findViewById(R.id.log);
        this.add = (Button) findViewById(R.id.addfacilities);
        this.add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String userId = AddFacilities.this.ref.push().getKey();
                AddFacilities.this.ref.child(userId).setValue(new FacilitiesDatabase(AddFacilities.this.name.getText().toString(), AddFacilities.this.location.getText().toString(), AddFacilities.this.town.getText().toString(), Double.valueOf(Double.parseDouble(AddFacilities.this.lat.getText().toString())), Double.valueOf(Double.parseDouble(AddFacilities.this.longitude.getText().toString()))));
                Toast.makeText(AddFacilities.this.getApplicationContext(), "Successiful", 0).show();
            }
        });
    }
}
