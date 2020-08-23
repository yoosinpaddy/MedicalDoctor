package com.example.e_medics;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Feedback extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    Button feed;
    EditText feedback;
    DatabaseReference ref = this.database.getReference("feedback");

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_feedback);
        this.feed = (Button) findViewById(R.id.feed);
        this.feedback = (EditText) findViewById(R.id.feedback);
        this.feed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String message = Feedback.this.feedback.getText().toString();
                String userId = Feedback.this.ref.push().getKey();
                Feedback.this.ref.child(userId).setValue(new FeedbackDatabase(message));
            }
        });
    }
}
