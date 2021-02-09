package com.example.sqltest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Edit extends AppCompatActivity {
    Button button;
    DatabaseReference dR;
    EditText editText;
    String id;
    RadiologyData rD;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        fetchNote();
        save();
    }

    private void save() {
        Button button2 = (Button) findViewById(R.id.saveButton);
        this.button = button2;
        button2.setOnClickListener(new View.OnClickListener() {
            /* class com.example.sqltest.Edit.AnonymousClass1 */

            public void onClick(View v) {
                Edit.this.dR.child(Edit.this.id).child("notes").setValue(Edit.this.editText.getText().toString());
                Edit.this.finish();
            }
        });
    }

    private void fetchNote() {
        this.id = getIntent().getSerializableExtra("id").toString();
        this.editText = (EditText) findViewById(R.id.editNoteText);
        this.dR = FirebaseDatabase.getInstance().getReference(sqliteImp.TABLE_NAME);
        this.dR.child(this.id).addValueEventListener(new ValueEventListener() {
            /* class com.example.sqltest.Edit.AnonymousClass2 */

            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot dataSnapshot) {
                Edit.this.rD = (RadiologyData) dataSnapshot.getValue(RadiologyData.class);
                Edit.this.editText.setText(Edit.this.rD.getNotes());
                Edit.this.editText.setSelection(Edit.this.editText.getText().length());
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError databaseError) {
                Log.w("this", "loadPost:onCancelled", databaseError.toException());
            }
        });
    }
}
