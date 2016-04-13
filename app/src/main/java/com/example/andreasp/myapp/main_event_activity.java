package com.example.andreasp.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class main_event_activity extends AppCompatActivity {

//    public void CreateEvent(View view) {
//        Intent EventIntent = new Intent(main_event_activity.this, event_creator.class);
//        startActivity(EventIntent);
//    }

    public void SeeEvents (View v){
        Intent ComingEvents = new Intent(main_event_activity.this, events.class);
        startActivity(ComingEvents);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_event_activity);
    }
}
