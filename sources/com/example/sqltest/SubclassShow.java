package com.example.sqltest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class SubclassShow extends AppCompatActivity {
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<String> arrayListId = new ArrayList<>();
    String categoryName;
    DatabaseReference dR;
    ListView listView;
    RadiologyData rD;
    TextView textView;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subclass_show);
        fetchSubClasses();
        gotoNotes();
    }

    private void gotoNotes() {
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.example.sqltest.SubclassShow.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(SubclassShow.this, NotesShow.class);
                intent.putExtra("subclass", SubclassShow.this.arrayList.get(position));
                intent.putExtra("id", SubclassShow.this.arrayListId.get(position));
                SubclassShow.this.startActivity(intent);
            }
        });
    }

    private void fetchSubClasses() {
        this.listView = (ListView) findViewById(R.id.subclasslist);
        this.textView = (TextView) findViewById(R.id.categoryText);
        String obj = getIntent().getSerializableExtra(AppMeasurementSdk.ConditionalUserProperty.NAME).toString();
        this.categoryName = obj;
        this.textView.setText(obj);
        this.dR = FirebaseDatabase.getInstance().getReference(sqliteImp.TABLE_NAME);
        this.arrayAdapter = new ArrayAdapter<>(this, 17367046, this.arrayList);
        this.dR.addValueEventListener(new ValueEventListener() {
            /* class com.example.sqltest.SubclassShow.AnonymousClass2 */

            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot dataSnapshot) {
                SubclassShow.this.arrayList.clear();
                SubclassShow.this.arrayListId.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    SubclassShow.this.rD = (RadiologyData) postSnapshot.getValue(RadiologyData.class);
                    if (SubclassShow.this.rD.getName().equals(SubclassShow.this.categoryName)) {
                        SubclassShow.this.arrayListId.add(SubclassShow.this.rD.id);
                        SubclassShow.this.arrayList.add(SubclassShow.this.rD.getSubclass());
                    }
                    SubclassShow.this.listView.setAdapter((ListAdapter) SubclassShow.this.arrayAdapter);
                }
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(SubclassShow.this, "Error in fetching subclasses", 1).show();
                Log.w("this", "loadPost:onCancelled", databaseError.toException());
            }
        });
    }
}
