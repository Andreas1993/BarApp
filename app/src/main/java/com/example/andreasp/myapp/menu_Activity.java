package com.example.andreasp.myapp;



import android.app.Activity;
import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;

public class menu_Activity extends Activity {
    private ExpandableListView mExpandableList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        mExpandableList = (ExpandableListView)findViewById(R.id.drinksMenu);

        String[] drinkPrices = {"","","3$","4$","3.5$","5$","","","3$","4$","3.5$","5$","6$"};
        String[] drinksArray = {"Beer","Shots","Gin and Tonic","Jäeger Bomb","Rum and Coke","Whiskey"};
        String[] drinksIngredients = {"Carlsberg","Royal Classic","Newcastle","Slots","Sour shots","Tequila","Death","2cl Gin","20cl Tonic","2cl Jäeger Mäester", "10cl Redbull","2cl Rum","20cl Coca Cola"};
        ArrayList<Parent> arrayParents = new ArrayList<Parent>();
        ArrayList<String> arrayPrice = new ArrayList<String>();
        ArrayList<String> arrayChildren = new ArrayList<String>();

        //here we set the parents and the children
        for (int i = 0; i < drinksArray.length; i++) {
            //for each "i" create a new Parent object to set the title and the children
            Parent parent = new Parent();
            parent.setTitle(drinksArray[i]);

            arrayPrice = new ArrayList<>();
            arrayChildren = new ArrayList<>();
            switch (parent.getTitle()) {
                case "Beer":
                    for (int j = 0; j <= 3; j++) {
                        arrayChildren.add(drinksIngredients[j]);
                        arrayPrice.add(drinkPrices[j]);
                    }
                    break;
                case "Shots":
                    for (int j = 4; j <= 6; j++) {
                        arrayChildren.add(drinksIngredients[j]);
                        arrayPrice.add(drinkPrices[j]);}
                    break;
                case "Gin and Tonic":
                    for (int j = 7; j <= 8; j++) {
                        arrayChildren.add(drinksIngredients[j]);
                        arrayPrice.add(drinkPrices[j]);
                    }
                    break;
                case "Jäeger Bomb":
                    for (int j = 9; j <= 10; j++) {
                        arrayChildren.add(drinksIngredients[j]);
                        arrayPrice.add(drinkPrices[j]);
                    }
                    break;
                case "Rum and Coke":
                    for (int j = 11; j <= 12; j++) {
                        arrayChildren.add(drinksIngredients[j]);
                        arrayPrice.add(drinkPrices[j]);
                    }
                    break;
                case "Whiskey":
                    break;
            }
            parent.setArrayPrices(arrayPrice);
            parent.setArrayChildren(arrayChildren);


            //in this array we add the Parent object. We will use the arrayParents at the setAdapter
            arrayParents.add(parent);

        }
        //sets the adapter that provides data to the list.
        mExpandableList.setAdapter(new CustomAdapter(menu_Activity.this, arrayParents));




    }
}

