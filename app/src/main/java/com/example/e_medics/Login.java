package com.example.e_medics;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    FirebaseAuth auth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_login);
        this.auth = FirebaseAuth.getInstance();
        Bundle bundle = getIntent().getExtras();
        this.auth = FirebaseAuth.getInstance();
        this.auth.signInWithEmailAndPassword(bundle.getString("email"), bundle.getString("password")).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Login.this.startActivity(new Intent(Login.this.getApplicationContext(), Dashboard.class));
                    return;
                }
                Toast.makeText(Login.this.getApplicationContext(), "Error Login Signup", 1).show();
                Login.this.startActivity(new Intent(Login.this.getApplicationContext(), Signup.class));
            }
        });
    }
}
