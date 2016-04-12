package com.example.andreasp.myapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Andreasp on 06-04-2016.
 */
public class TodoCursorAdapter extends CursorAdapter {

    public TodoCursorAdapter(Context context, Cursor cursor, int flags) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.activity_events, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView EventName = (TextView) view.findViewById(R.id.EventNameText);
        TextView EventDrink = (TextView) view.findViewById(R.id.EventDrinkText);
        TextView EventDate = (TextView) view.findViewById(R.id.DateOfEvent);
        // Extract properties from cursor
        String EVENT_NAME = cursor.getString(cursor.getColumnIndexOrThrow("Name"));
        String EVENT_DRINK = cursor.getString(cursor.getColumnIndexOrThrow("Drink"));
        String EVENT_DATE = cursor.getString(cursor.getColumnIndexOrThrow("Date"));
        // Populate fields with extracted properties
        EventName.setText(EVENT_NAME);
        EventDrink.setText(EVENT_DRINK);
        EventDate.setText(EVENT_DATE);

    }

}
