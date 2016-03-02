package com.example.andreasp.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    public void clickButton(View view) {
        switch(view.getId()){
            case R.id.menuButton:
                Intent menuIntent = new Intent(MainActivity.this, menuActivity.class);
                startActivity(menuIntent);
                break;
            case  R.id.hoursButton:
                Intent hoursIntent = new Intent(MainActivity.this, openingHours.class);
                startActivity(hoursIntent);
                break;
            case R.id.eventsButton:
                Intent eventsIntent = new Intent(MainActivity.this, events.class);
                startActivity(eventsIntent);
                break;
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
