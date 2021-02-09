package com.example.sqltest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class sqliteImp extends SQLiteOpenHelper {
    public static final String COL_1 = "Id";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "SubClass";
    public static final String COL_4 = "Notes";
    public static final String DATABASE_NAME = "Radiology";
    public static final String TABLE_NAME = "RadiologyTable";

    public sqliteImp(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        getWritableDatabase();
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table RadiologyTable (Id Integer primary key autoincrement,Name Text,Subclass Text,Notes Text)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists RadiologyTable");
        onCreate(db);
    }

    public long insert(String name, String subclass, String notes) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, subclass);
        contentValues.put(COL_4, notes);
        return db.insert(TABLE_NAME, null, contentValues);
    }

    public Cursor fetchdata() {
        return getWritableDatabase().rawQuery("Select Id,SubClass from RadiologyTable", null);
    }

    public Cursor fetchdatabyname(String name) {
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery("Select Id,SubClass from RadiologyTable Where Name ='" + name + "'", null);
    }

    public Cursor fetchNotes(String id) {
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery("Select Notes from RadiologyTable Where Id=" + id, null);
    }

    public boolean updateNotes(String id, String notes) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_4, notes);
        db.update(TABLE_NAME, contentValues, "Id = ? ", new String[]{id});
        return true;
    }

    public int deleteRow(String Id) {
        return getWritableDatabase().delete(TABLE_NAME, "Id = ?", new String[]{Id});
    }

    public void preLoadedData() {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, "Abdomen");
        contentValues.put(COL_3, "Gallstone disease - Gallbladder obstruction");
        contentValues.put(COL_4, "Most gallstones that we find with ultrasound are asymptomatic and should be left untreated.\nHowever when gallstones obstruct the gallbladder or the common bile duct they become symptomatic.\n");
        Log.d("this", String.valueOf(db.insert(TABLE_NAME, null, contentValues)));
        contentValues.clear();
        contentValues.put(COL_2, "Breast");
        contentValues.put(COL_3, "Bi-RADS for Mammography and Ultrasound 2013");
        contentValues.put(COL_4, "Harmien Zonderland and Robin Smithuis\nRadiology department of the Academical Medical Centre in Amsterdam and the Rijnland hospital in Leiderdorp, the Netherlands");
        db.insert(TABLE_NAME, null, contentValues);
        contentValues.clear();
        contentValues.put(COL_2, "Cardio");
        contentValues.put(COL_3, "CAD-RADS");
        contentValues.put(COL_4, "Csilla Celeng, Richard Takx, Robin Smithuis and Tim Leiner\nRadiology Department University Medical Center Utrecht and the Alrijne hospital in Leiderdorp, The Netherlands");
        db.insert(TABLE_NAME, null, contentValues);
        contentValues.clear();
        contentValues.put(COL_2, "Chest");
        contentValues.put(COL_3, "BTS guideline for pulmonary nodules");
        contentValues.put(COL_4, "Onno Mets and Robin Smithuis\nthe Academical Medical Centre, Amsterdam and the Alrijne Hospital, Leiderdorp, the Netherlands");
        db.insert(TABLE_NAME, null, contentValues);
        contentValues.clear();
        contentValues.put(COL_2, "HeadAndNeck");
        contentValues.put(COL_3, "Infrahyoid neck");
        contentValues.put(COL_4, "Frank Pameijer, Erik Beek, Frank Joosten and Robin Smithuis\nRadiology department of the University Medical Centre of Utrecht, the Rijnstate Hospital in Arnhem and the Rijnland hospital in Leiderdorp, the Netherlands");
        db.insert(TABLE_NAME, null, contentValues);
        contentValues.clear();
        contentValues.put(COL_2, "MSK");
        contentValues.put(COL_3, "Ankle fracture - Weber and Lauge-Hansen Classification");
        contentValues.put(COL_4, "Robin Smithuis\nRadiology Department of the Rijnland Hospital, Leiderdorp, the Netherlands");
        db.insert(TABLE_NAME, null, contentValues);
        contentValues.clear();
        contentValues.put(COL_2, "Neuro");
        contentValues.put(COL_3, "Brain Anatomy");
        contentValues.put(COL_4, "Robin Smithuis\nRadiology department, Rijnland Hospital Leiderdorp, the Netherlands.");
        db.insert(TABLE_NAME, null, contentValues);
        contentValues.clear();
        contentValues.put(COL_2, "Pediatric");
        contentValues.put(COL_3, "Acute Abdomen in Neonates");
        contentValues.put(COL_4, "Joosje Bomer, Samuel Stafrace, Robin Smithuis and Herma Holscher\nAkershus Universitetssykehus in Lørenskog, Norway, Sidra Medicine in Doha, Qatar, Alrijne hospital in Leiden and Juliana Children's Hospital in the Hague, the Netherlands");
        db.insert(TABLE_NAME, null, contentValues);
        contentValues.clear();
    }
}
