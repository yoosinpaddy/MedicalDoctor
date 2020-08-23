package com.example.e_medics;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class ViewFacilities extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference ref;
    List<String> show = new ArrayList();
    ListView viewfacilities;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_view_facilities);
        this.database = FirebaseDatabase.getInstance();
        this.ref = this.database.getReference();
        this.ref.child("facilities").addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    ViewFacilities.this.show.add(((FacilitiesDatabase) child.getValue(FacilitiesDatabase.class)).Name);
                }
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
        this.viewfacilities.setAdapter(new ArrayAdapter<>(getApplicationContext(), 17367043, this.show));
    }
}
