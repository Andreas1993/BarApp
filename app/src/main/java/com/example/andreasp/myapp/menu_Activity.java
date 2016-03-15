package com.example.andreasp.myapp;



import android.app.Activity;
import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.security.acl.Group;
import java.util.ArrayList;

public class menu_Activity extends Activity {
    private ExpandableListView mExpandableList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        mExpandableList = (ExpandableListView)findViewById(R.id.drinksMenu);


        int Images[] = {R.drawable.beer,R.drawable.drinks,R.drawable.shots,R.drawable.liquor};
        String[] drinksArray = {"Beer","Drinks","Shots","Hard liquor"};

        String[] drinkPrices = {"1,50$","2,00$","2,50$","1,00$","2,50$","2,20$","2,50$","2,55$","1,00$","1,10$","1,00$","4,00$","2,00$","5,00$"};
        String[] drinksIngredients = {"Carlsberg","Royal Classic","Newcastle","Slots","Dark and stormy","Coke'n'rum","Mojito","Pina Colada","Sour shots","Tequila","Licourice shots","Whiskey","Vodka","Brandy"};
        ArrayList<Parent> arrayParents = new ArrayList<Parent>();
        ArrayList<String> arrayPrice = new ArrayList<String>();
        ArrayList<String> arrayChildren = new ArrayList<String>();

        //here we set the parents and the children
        for (int i = 0; i < drinksArray.length; i++) {
            //for each "i" create a new Parent object to set the title and the children
            Parent parent = new Parent();
            parent.setTitle(drinksArray[i]);
            parent.setImage(Images[i]);

            arrayPrice = new ArrayList<>();
            arrayChildren = new ArrayList<>();
            switch (parent.getTitle()) {
                case "Beer":
                    for (int j = 0; j <= 3; j++) {
                        arrayChildren.add(drinksIngredients[j]);
                        arrayPrice.add(drinkPrices[j]);
                    }
                    break;
                case "Drinks":
                    for (int j = 4; j <= 7; j++) {
                        arrayChildren.add(drinksIngredients[j]);
                        arrayPrice.add(drinkPrices[j]);}
                    break;
                case "Shots":
                    for (int j = 8; j <= 10; j++) {
                        arrayChildren.add(drinksIngredients[j]);
                        arrayPrice.add(drinkPrices[j]);
                    }
                    break;
                case "Hard liquor":
                    for (int j = 11; j <= 13; j++) {
                        arrayChildren.add(drinksIngredients[j]);
                        arrayPrice.add(drinkPrices[j]);
                    }
                    break;

            }
            parent.setArrayPrices(arrayPrice);
            parent.setArrayChildren(arrayChildren);


            //in this array we add the Parent object. We will use the arrayParents at the setAdapter
            arrayParents.add(parent);
            //sets the adapter that provides data to the list.


        }
        mExpandableList.setAdapter(new CustomAdapter(menu_Activity.this, arrayParents));





    }
}

