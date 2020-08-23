package com.example.e_medics;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DoctorLocation extends FragmentActivity implements OnMapReadyCallback {
    FirebaseDatabase database;
    Doctor doc;
    /* access modifiers changed from: private */
    public GoogleMap mMap;
    DatabaseReference ref;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_location);
        this.database = FirebaseDatabase.getInstance();
        this.ref = this.database.getReference();
        this.ref.child("doctor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    doc = (Doctor) child.getValue(Doctor.class);
                    mMap.addMarker(new MarkerOptions().position(new LatLng(doc.Latitude.doubleValue(), doc.Longitude.doubleValue())).title(doc.Name));

//                    mMap.addMarker(new MarkerOptions().position(new LatLng(doc.Latitude.doubleValue(), doc.Longitude.doubleValue())).title(doc.Name));
                }
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;
        this.mMap.setMapType(3);
    }
}
