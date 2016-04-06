package com.example.andreasp.myapp;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class events extends AppCompatActivity {

    SQL_database myhelper;
    SQLiteDatabase db;

    public void CreateEvent(View view) {
        Intent EventIntent = new Intent(events.this, event_creator.class);
        startActivity(EventIntent);
        }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        // TodoDatabaseHandler is a SQLiteOpenHelper class connecting to SQLite
        myhelper = new SQL_database(this);
        // Get access to the underlying writeable database
        db = myhelper.getWritableDatabase();
        // Query for items from the database and get a cursor back
        Cursor todoCursor = db.rawQuery("SELECT  * FROM Events", null);

        // Find ListView to populate
        ListView Events = (ListView) findViewById(R.id.ComingEvents);
        // Setup cursor adapter using cursor from last step
        TodoCursorAdapter todoAdapter = new TodoCursorAdapter(this, todoCursor, 0);
        // Attach cursor adapter to the ListView
        Events.setAdapter(todoAdapter);

        // Switch to new cursor and update contents of ListView

    }



}


