package com.example.e_medics;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Service extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_service);
        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ListView listView = (ListView) Service.this.findViewById(R.id.listView);
                final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Service.this.getApplicationContext(), R.array.service, R.layout.text_view_with_line_height_from_layout);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        Toast.makeText(Service.this.getApplicationContext(), (CharSequence) adapter.getItem(position), 1).show();
                    }
                });
            }
        });
    }
}
