package com.example.sqltest;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class SubclassActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subclass);
        final sqliteImp mydb = new sqliteImp(this);
        final ArrayList<String> arrayList = new ArrayList<>();
        final ArrayList<String> listId = new ArrayList<>();
        final String name = (String) getIntent().getSerializableExtra(sqliteImp.COL_2);
        Cursor cr = mydb.fetchdatabyname(name);
        while (cr.moveToNext()) {
            listId.add(cr.getString(0));
            arrayList.add(cr.getString(1));
        }
        ((TextView) findViewById(R.id.catName)).setText(name);
        final EditText et = (EditText) findViewById(R.id.addsubtext);
        ListView mylistview = (ListView) findViewById(R.id.sublist);
        mylistview.setAdapter((ListAdapter) new ArrayAdapter<>(this, 17367046, arrayList));
        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.example.sqltest.SubclassActivity.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(SubclassActivity.this, NotesViewActivity.class);
                intent.putExtra(sqliteImp.COL_1, (String) listId.get(position));
                intent.putExtra("subClass", (String) arrayList.get(position));
                intent.putExtra(sqliteImp.COL_2, name);
                SubclassActivity.this.startActivity(intent);
            }
        });
        ((Button) findViewById(R.id.subclassAddBtn)).setOnClickListener(new View.OnClickListener() {
            /* class com.example.sqltest.SubclassActivity.AnonymousClass2 */

            public void onClick(View v) {
                if (Long.valueOf(mydb.insert(name, et.getText().toString(), null)).longValue() != -1) {
                    Toast.makeText(SubclassActivity.this, "Subclass Inserted Successfully", 1).show();
                } else {
                    Toast.makeText(SubclassActivity.this, "Subclass Inserted Failed", 1).show();
                }
                SubclassActivity.this.recreate();
            }
        });
    }
}
