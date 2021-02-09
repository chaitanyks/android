package com.example.sqltest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {
    DatabaseReference databaseReference;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addData();
        gotoCategories();
    }

    private void gotoCategories() {
        ((Button) findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            /* class com.example.sqltest.MainActivity.AnonymousClass1 */

            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, FirebaseDataShow.class));
            }
        });
    }

    private void addData() {
        ((Button) findViewById(R.id.addDataButton)).setOnClickListener(new View.OnClickListener() {
            /* class com.example.sqltest.MainActivity.AnonymousClass2 */

            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, FirebaseDataAdd.class));
            }
        });
    }
}
