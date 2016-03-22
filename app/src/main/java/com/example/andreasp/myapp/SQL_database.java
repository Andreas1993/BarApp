package com.example.andreasp.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Andreasp on 22-03-2016.
 */
public class SQL_database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "myDB";
    public static final int DATABASE_VERSION = 1;
    public final String TABLE_PARENT = "Types";
    public final String TABLE_CHILD = "Drinks";
    public final String PARENT_ID = "_id";
    public final String CHILD_ID = "_id";
    public final String DRINKS_IMAGE = "Image";
    public final String PARENT_NAME = "Name";
    public final String CHILD_NAME = "Name";
    public final String DRINKS_PRICE = "Price";


    // CREATE TABLE Drinks ();
    public SQL_database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
   }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String ParentQuery = "CREATE TABLE " + TABLE_PARENT + " (" + PARENT_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + DRINKS_IMAGE + " INTEGER, " + PARENT_NAME + " TEXT);";
        String ChildQuery = "CREATE TABLE " + TABLE_CHILD + " (" + CHILD_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + CHILD_NAME + " TEXT, " + DRINKS_PRICE + " TEXT); ";
        db.execSQL(ParentQuery);
        db.execSQL(ChildQuery);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PARENT_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CHILD_NAME);
        onCreate(db);
    }


}
