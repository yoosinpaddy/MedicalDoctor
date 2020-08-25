package com.example.e_medics;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        this.email = (EditText) findViewById(R.id.email);
        this.password = (EditText) findViewById(R.id.password);
        ((Button) findViewById(R.id.sign)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this.getApplicationContext(), Signup.class));
            }
        });
        ((Button) findViewById(R.id.login)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (TextUtils.isEmpty(MainActivity.this.email.getText().toString())) {
                    Toast.makeText(MainActivity.this.getApplicationContext(), "Empty Email", 1).show();
                    MainActivity.this.startActivity(new Intent(MainActivity.this.getApplicationContext(), MainActivity.class));
                }
                if (TextUtils.isEmpty(MainActivity.this.password.getText().toString())) {
                    Toast.makeText(MainActivity.this.getApplicationContext(), "Empty Password", 1).show();
                    MainActivity.this.startActivity(new Intent(MainActivity.this.getApplicationContext(), MainActivity.class));
                }
                String mail = MainActivity.this.email.getText().toString();
                String pass = MainActivity.this.password.getText().toString();
                Intent intent = new Intent(MainActivity.this.getApplicationContext(), Login.class);
                Bundle bundle = new Bundle();
                bundle.putString("email", mail);
                bundle.putString("password", pass);
                intent.putExtras(bundle);
                MainActivity.this.startActivity(intent);
            }
        });
    }
    public void patientin(View v){
        startActivity(new Intent(MainActivity.this, SignupPatient.class));
    }
}
