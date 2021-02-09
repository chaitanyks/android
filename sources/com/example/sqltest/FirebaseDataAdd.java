package com.example.sqltest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseDataAdd extends AppCompatActivity {
    DatabaseReference databaseReference;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_data_add);
        addData();
    }

    private void addData() {
        final EditText name = (EditText) findViewById(R.id.editText);
        final EditText subclass = (EditText) findViewById(R.id.editText2);
        final EditText notes = (EditText) findViewById(R.id.editText3);
        this.databaseReference = FirebaseDatabase.getInstance().getReference(sqliteImp.TABLE_NAME);
        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            /* class com.example.sqltest.FirebaseDataAdd.AnonymousClass1 */

            public void onClick(View v) {
                String Name = name.getText().toString();
                String Subclass = subclass.getText().toString();
                String Notes = notes.getText().toString();
                String id = FirebaseDataAdd.this.databaseReference.push().getKey();
                FirebaseDataAdd.this.databaseReference.child(id).setValue(new RadiologyData(id, Name, Subclass, Notes));
                Toast.makeText(FirebaseDataAdd.this, "Data Inserted Successfully", 1).show();
                FirebaseDataAdd.this.finish();
            }
        });
    }
}
