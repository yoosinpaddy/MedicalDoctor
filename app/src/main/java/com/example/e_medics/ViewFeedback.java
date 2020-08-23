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

public class ViewFeedback extends AppCompatActivity {
    FirebaseDatabase database;
    List<String> list = new ArrayList();
    DatabaseReference ref;
    ListView viewfeedback;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_view_feedback);
        this.database = FirebaseDatabase.getInstance();
        this.ref = this.database.getReference();
        this.viewfeedback = (ListView) findViewById(R.id.viewfeedback);
        this.ref.child("feedback").addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    ViewFeedback.this.list.add(((FeedbackDatabase) child.getValue(FeedbackDatabase.class)).feedback);
                }
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
        this.viewfeedback.setAdapter(new ArrayAdapter<>(getApplicationContext(), 17367043, this.list));
    }
}
