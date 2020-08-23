package com.example.e_medics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Profile extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_profile);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        ListView listView = (ListView) findViewById(R.id.profile);
        listView.setAdapter(ArrayAdapter.createFromResource(getApplicationContext(), R.array.menu, R.layout.text_view_with_line_height_from_layout));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position == 0) {
                    Profile.this.startActivity(new Intent(Profile.this.getApplicationContext(), Main3Activity.class));
                } else if (position == 1) {
                    Profile.this.startActivity(new Intent(Profile.this.getApplicationContext(), Admin.class));
                } else if (position == 2) {
                    Profile.this.startActivity(new Intent(Profile.this.getApplicationContext(), MainActivity.class));
                } else if (position != 3) {
                    Toast.makeText(Profile.this.getApplicationContext(), "Error", 1).show();
                    Profile.this.startActivity(new Intent(Profile.this.getApplicationContext(), MainActivity.class));
                } else {
                    Profile.this.startActivity(new Intent(Profile.this.getApplicationContext(), Service.class));
                }
            }
        });
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Snackbar.make(view, (CharSequence) "Replace with your own action", 0).setAction((CharSequence) "Action", (View.OnClickListener) null).show();
            }
        });
    }
}
