package com.example.andreasp.myapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class dessert_list extends AppCompatActivity {

    private OrientationEventListener LandscapeChecker;
    dessertFragment dessertFrag;
    int orientationValue;
    ListView dessertList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert_list);

        String[] dessertArray = {"Strawberry icecream", "Pancakes", "Brownie", "Cheesecake"};

        dessertList = (ListView) findViewById(R.id.dessertListView);
        dessertList.setAdapter(new DessertAdapter(dessertArray, dessert_list.this));

//        dessertFrag = new dessertFragment();
//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.dessertList, dessertFrag, "myDessert");
//        fragmentTransaction.commit();


//        LandscapeChecker = new OrientationEventListener(getApplicationContext()) {
//            @Override
//            public void onOrientationChanged(int arg0) {
//                orientationValue = arg0;
//
//                if ((orientationValue> 80 && orientationValue<100) || (orientationValue>260 && orientationValue<280)){
//                    setContentView(R.layout.landscape_fragments);
//                }
//                if(orientationValue < 0){   // The phone lies on the table
//
//                }
//            }
//
//        };
//        if (LandscapeChecker.canDetectOrientation()){
//            LandscapeChecker.enable();
//        }


    }


}