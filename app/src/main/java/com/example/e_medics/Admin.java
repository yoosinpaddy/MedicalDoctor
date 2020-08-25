package com.example.e_medics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Admin extends AppCompatActivity {
    Button login;
    EditText password;
    EditText username;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_admin);
        this.username = (EditText) findViewById(R.id.username);
        this.password = (EditText) findViewById(R.id.pass);
        this.login = (Button) findViewById(R.id.log);
        this.login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String user = Admin.this.username.getText().toString();
                String pass = Admin.this.password.getText().toString();
                if (!user.equals("kinyanjui") || !pass.equals("1234")) {
                    Toast.makeText(Admin.this.getApplicationContext(), "Error WRong CREDENTIALS", 1).show();
                    Admin.this.startActivity(new Intent(Admin.this.getApplicationContext(), Admin.class));
                    return;
                }
                Admin.this.startActivity(new Intent(Admin.this.getApplicationContext(), AdminDashBoard.class));
            }
        });
    }
}
