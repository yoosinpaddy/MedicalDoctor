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

public class Facilities extends FragmentActivity implements OnMapReadyCallback {
    FacilitiesDatabase dat;
    FirebaseDatabase database;
    /* access modifiers changed from: private */
    public GoogleMap mMap;
    DatabaseReference ref;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities);
        this.database = FirebaseDatabase.getInstance();
        this.ref = this.database.getReference();
        this.ref.child("facilities").addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Facilities.this.dat = (FacilitiesDatabase) child.getValue(FacilitiesDatabase.class);
                    Facilities.this.mMap.addMarker(new MarkerOptions().position(new LatLng(Facilities.this.dat.Lat.doubleValue(), Facilities.this.dat.Longitude.doubleValue())).title(Facilities.this.dat.Town));
                }
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);
    }

    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;
        this.mMap.setMapType(2);
    }
}
