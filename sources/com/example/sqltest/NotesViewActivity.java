package com.example.sqltest;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class NotesViewActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_view);
        final String subclass = getIntent().getSerializableExtra("subClass").toString();
        final String id = getIntent().getSerializableExtra(sqliteImp.COL_1).toString();
        final String name = getIntent().getSerializableExtra(sqliteImp.COL_2).toString();
        final sqliteImp mydb = new sqliteImp(this);
        Cursor cr = mydb.fetchNotes(id);
        final StringBuffer notes = new StringBuffer();
        while (cr.moveToNext()) {
            notes.append(cr.getString(0));
        }
        Log.d("this", notes.toString());
        ((TextView) findViewById(R.id.notesView2)).setText(subclass);
        TextView textView = (TextView) findViewById(R.id.notesView);
        textView.setText(notes.toString());
        textView.setMovementMethod(new ScrollingMovementMethod());
        Button button = (Button) findViewById(R.id.editNotesBtn);
        Button reload = (Button) findViewById(R.id.reloadBtn);
        Button delete = (Button) findViewById(R.id.deleteBtn);
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.example.sqltest.NotesViewActivity.AnonymousClass1 */

            public void onClick(View v) {
                Intent intent = new Intent(NotesViewActivity.this, EditNotesActivity.class);
                intent.putExtra("subClass", subclass);
                intent.putExtra(sqliteImp.COL_1, id);
                intent.putExtra(sqliteImp.COL_2, name);
                intent.putExtra(sqliteImp.COL_4, notes.toString());
                NotesViewActivity.this.startActivity(intent);
                NotesViewActivity.this.finish();
            }
        });
        reload.setOnClickListener(new View.OnClickListener() {
            /* class com.example.sqltest.NotesViewActivity.AnonymousClass2 */

            public void onClick(View v) {
                NotesViewActivity.this.recreate();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            /* class com.example.sqltest.NotesViewActivity.AnonymousClass3 */

            public void onClick(View v) {
                AlertDialog.Builder alertdial = new AlertDialog.Builder(NotesViewActivity.this);
                alertdial.setMessage("Do You Want To Delete This SubClass ?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    /* class com.example.sqltest.NotesViewActivity.AnonymousClass3.AnonymousClass2 */

                    public void onClick(DialogInterface dialog, int which) {
                        if (mydb.deleteRow(id) == 1) {
                            Toast.makeText(NotesViewActivity.this, "Data Deleted Successfully", 1).show();
                            Intent intent = new Intent(NotesViewActivity.this, MainActivity.class);
                            intent.putExtra(sqliteImp.COL_2, name);
                            NotesViewActivity.this.startActivity(intent);
                            NotesViewActivity.this.finish();
                            return;
                        }
                        Toast.makeText(NotesViewActivity.this, "Error", 1).show();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    /* class com.example.sqltest.NotesViewActivity.AnonymousClass3.AnonymousClass1 */

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = alertdial.create();
                alert.setTitle("Delete SubClass");
                alert.show();
            }
        });
    }
}
