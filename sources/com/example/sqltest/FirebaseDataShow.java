package com.example.sqltest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FirebaseDataShow extends AppCompatActivity {
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> arrayList = new ArrayList<>();
    Set<String> categoriesNames = new HashSet();
    DatabaseReference dR;
    ListView listView;
    RadiologyData rD;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_data_show);
        fetchCategories();
        gotoSubClass();
    }

    private void gotoSubClass() {
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.example.sqltest.FirebaseDataShow.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(FirebaseDataShow.this, SubclassShow.class);
                intent.putExtra(AppMeasurementSdk.ConditionalUserProperty.NAME, FirebaseDataShow.this.arrayList.get(position));
                FirebaseDataShow.this.startActivity(intent);
            }
        });
    }

    private void fetchCategories() {
        this.dR = FirebaseDatabase.getInstance().getReference(sqliteImp.TABLE_NAME);
        this.arrayAdapter = new ArrayAdapter<>(this, 17367046, this.arrayList);
        this.listView = (ListView) findViewById(R.id.categoriesName);
        this.dR.addValueEventListener(new ValueEventListener() {
            /* class com.example.sqltest.FirebaseDataShow.AnonymousClass2 */

            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot dataSnapshot) {
                FirebaseDataShow.this.categoriesNames.clear();
                FirebaseDataShow.this.arrayList.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    FirebaseDataShow.this.rD = (RadiologyData) postSnapshot.getValue(RadiologyData.class);
                    String name = FirebaseDataShow.this.rD.getName();
                    if (!FirebaseDataShow.this.categoriesNames.contains(name)) {
                        FirebaseDataShow.this.categoriesNames.add(name);
                        FirebaseDataShow.this.arrayList.add(name);
                        Log.d("this", name);
                    }
                    FirebaseDataShow.this.listView.setAdapter((ListAdapter) FirebaseDataShow.this.arrayAdapter);
                }
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(FirebaseDataShow.this, "Error in fetching categories", 1).show();
                Log.w("this", "loadPost:onCancelled", databaseError.toException());
            }
        });
    }
}
