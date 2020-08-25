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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
    FirebaseAuth auth;
    private static final String TAG = "Signup";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_signup);
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText password = (EditText) findViewById(R.id.password);
        this.auth = FirebaseAuth.getInstance();
        ((Button) findViewById(R.id.add)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Signup.this.auth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Signup.this.getApplicationContext(), "Successiful Signup", 1).show();
                            Signup.this.startActivity(new Intent(Signup.this.getApplicationContext(), MainActivity.class));
                            return;
                        }else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Signup.this, task.getException().getLocalizedMessage(),
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }
                        Toast.makeText(Signup.this.getApplicationContext(), "Error in signing", 1).show();
//                        Signup.this.startActivity(new Intent(Signup.this.getApplicationContext(), Signup.class));
                    }
                });
            }
        });
    }
}
