package com.example.andreasp.myapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;

public class event_creator extends AppCompatActivity {

    EditText EventName, EventDrink, EventTimePlace;
    SQL_database myhelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_creator);

        myhelper = new SQL_database(this);
        db = myhelper.getWritableDatabase();

        EventName = (EditText) findViewById(R.id.EventName);
        EventDrink = (EditText) findViewById(R.id.EventDrink);
        EventTimePlace = (EditText) findViewById(R.id.EventDate);
    }

    public void saveEvent (View v){

        String EventNameText = EventName.getText().toString();
        String EventDrinkText = EventDrink.getText().toString();
        String EventDateText = EventTimePlace.getText().toString();

        ContentValues valuesToInsert = new ContentValues();
        valuesToInsert.put(myhelper.EVENT_NAME, EventNameText);
        valuesToInsert.put(myhelper.EVENT_DRINK, EventDrinkText);
        valuesToInsert.put(myhelper.EVENT_DATE, EventDateText);
        long id = db.insert(myhelper.EVENT_TABLE, null, valuesToInsert);

        Toast.makeText(this, "Event Saved!", Toast.LENGTH_SHORT).show();

    }
}
