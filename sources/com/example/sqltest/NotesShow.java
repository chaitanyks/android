package com.example.sqltest;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NotesShow extends AppCompatActivity {
    DatabaseReference dR;
    String id;
    RadiologyData rD;
    String subClass;
    TextView textView;
    TextView textViewTitle;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_show);
        fetchNote();
        gotoEditNotes();
    }

    private void gotoEditNotes() {
        ((Button) findViewById(R.id.editButton)).setOnClickListener(new View.OnClickListener() {
            /* class com.example.sqltest.NotesShow.AnonymousClass1 */

            public void onClick(View v) {
                Intent intent = new Intent(NotesShow.this, Edit.class);
                intent.putExtra("id", NotesShow.this.id);
                NotesShow.this.startActivity(intent);
            }
        });
    }

    private void fetchNote() {
        this.id = getIntent().getSerializableExtra("id").toString();
        this.subClass = getIntent().getSerializableExtra("subclass").toString();
        this.textView = (TextView) findViewById(R.id.notestext);
        TextView textView2 = (TextView) findViewById(R.id.subclasstext);
        this.textViewTitle = textView2;
        textView2.setText(this.subClass);
        this.dR = FirebaseDatabase.getInstance().getReference(sqliteImp.TABLE_NAME);
        this.dR.child(this.id).addValueEventListener(new ValueEventListener() {
            /* class com.example.sqltest.NotesShow.AnonymousClass2 */

            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot dataSnapshot) {
                NotesShow.this.rD = (RadiologyData) dataSnapshot.getValue(RadiologyData.class);
                NotesShow.this.textView.setText(NotesShow.this.rD.getNotes());
                NotesShow.this.textView.setMovementMethod(new ScrollingMovementMethod());
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError databaseError) {
                Log.w("this", "loadPost:onCancelled", databaseError.toException());
            }
        });
    }
}
