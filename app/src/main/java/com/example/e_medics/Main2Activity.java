package com.example.e_medics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    Button add;
    FirebaseDatabase database;
    Button doctor;
    /* access modifiers changed from: private */
    public List<String> list = new ArrayList();
    ListView listView;
    DatabaseReference ref;
    Button viewfacilities;
    Button viewfeedback;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main2);
        this.listView = (ListView) findViewById(R.id.list);
        this.database = FirebaseDatabase.getInstance();
        this.ref = this.database.getReference();
        this.add = (Button) findViewById(R.id.addfacilities);
        this.viewfacilities = (Button) findViewById(R.id.viewfacilities);
        this.viewfeedback = (Button) findViewById(R.id.viewfeedback);
        this.doctor = (Button) findViewById(R.id.viewdoctors);
        this.doctor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Main2Activity.this.ref.child("doctor").addValueEventListener(new ValueEventListener() {
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot child : dataSnapshot.getChildren()) {
                            Main2Activity.this.list.add(((Doctor) child.getValue(Doctor.class)).Name);
                        }
                    }

                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
                Main2Activity.this.listView.setAdapter(new ArrayAdapter<>(Main2Activity.this.getApplicationContext(), 17367043, Main2Activity.this.list));
            }
        });
        this.viewfacilities.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Main2Activity.this.startActivity(new Intent(Main2Activity.this.getApplicationContext(), ViewFacilities.class));
            }
        });
        this.viewfeedback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Main2Activity.this.startActivity(new Intent(Main2Activity.this.getApplicationContext(), ViewFeedback.class));
            }
        });
        this.add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Main2Activity.this.startActivity(new Intent(Main2Activity.this.getApplicationContext(), AddFacilities.class));
            }
        });
    }
}
