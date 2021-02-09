package com.example.sqltest;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EditNotesActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_notes);
        final String subclass = getIntent().getSerializableExtra("subClass").toString();
        final String id = getIntent().getSerializableExtra(sqliteImp.COL_1).toString();
        final String name = getIntent().getSerializableExtra(sqliteImp.COL_2).toString();
        final sqliteImp mydb = new sqliteImp(this);
        Cursor cr = mydb.fetchNotes(id);
        StringBuffer notes = new StringBuffer();
        while (cr.moveToNext()) {
            notes.append(cr.getString(0));
        }
        final EditText editText = (EditText) findViewById(R.id.editNotesText);
        editText.setText(notes.toString());
        editText.setMovementMethod(new ScrollingMovementMethod());
        ((Button) findViewById(R.id.notesSave)).setOnClickListener(new View.OnClickListener() {
            /* class com.example.sqltest.EditNotesActivity.AnonymousClass1 */

            public void onClick(View v) {
                mydb.updateNotes(id, editText.getText().toString());
                Toast.makeText(EditNotesActivity.this, "Data Updated Successfully", 1).show();
                Intent intent = new Intent(EditNotesActivity.this, NotesViewActivity.class);
                intent.putExtra(sqliteImp.COL_2, name);
                intent.putExtra("subClass", subclass);
                intent.putExtra(sqliteImp.COL_1, id);
                EditNotesActivity.this.startActivity(intent);
                EditNotesActivity.this.finish();
            }
        });
    }
}
