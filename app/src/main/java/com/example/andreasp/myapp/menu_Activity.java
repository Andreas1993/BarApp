package com.example.andreasp.myapp;



import android.app.Activity;
import android.app.ExpandableListActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.acl.Group;
import java.util.ArrayList;

public class menu_Activity extends Activity {
    private ExpandableListView mExpandableList;


//    public Cursor fetchGroup() {
//        String query = "SELECT * FROM rooms";
//        return db.rawQuery(query, null);
//    }
//
//    public Cursor fetchChildren(String room) {
//        String query = "SELECT * FROM devices WHERE id_room = '" + room + "'";
//        return db.rawQuery(query, null);
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        SQL_database myhelper = new SQL_database(this);
        SQLiteDatabase db = myhelper.getWritableDatabase();

        int Images[] = {R.drawable.beer,R.drawable.drinks,R.drawable.shots,R.drawable.liquor};
        String[] drinksArray = {"Beer","Drinks","Shots","Hard liquor"};
        String[] drinkPrices = {"1,50$","2,00$","2,50$","1,00$","2,50$","2,20$","2,50$","2,55$","1,00$","1,10$","1,00$","4,00$","2,00$","5,00$"};
        String[] drinksIngredients = {"Carlsberg","Royal Classic","Newcastle","Slots","Dark and stormy","Coke'n'rum","Mojito","Pina Colada","Sour shots","Tequila","Licourice shots","Whiskey","Vodka","Brandy"};

        for (int i = 0; i < Images.length; i++){
            ContentValues valuesToInsert = new ContentValues();
            valuesToInsert.put(myhelper.DRINKS_IMAGE,Images[i]);
            valuesToInsert.put(myhelper.PARENT_NAME,drinksArray[i]);
            long id = db.insert(myhelper.TABLE_PARENT,null,valuesToInsert);

        }

        for (int i = 0; i < drinksIngredients.length; i++) {
            ContentValues valuesToInsert = new ContentValues();
            valuesToInsert.put(myhelper.CHILD_NAME,drinksIngredients[i]);
            valuesToInsert.put(myhelper.DRINKS_PRICE,drinkPrices[i]);
            long id = db.insert(myhelper.TABLE_CHILD,null,valuesToInsert);
        }

//        int Images[] = {R.drawable.beer,R.drawable.drinks,R.drawable.shots,R.drawable.liquor};
//        String[] drinksArray = {"Beer","Drinks","Shots","Hard liquor"};
//        String[] drinkPrices = {"1,50$","2,00$","2,50$","1,00$","2,50$","2,20$","2,50$","2,55$","1,00$","1,10$","1,00$","4,00$","2,00$","5,00$"};
//        String[] drinksIngredients = {"Carlsberg","Royal Classic","Newcastle","Slots","Dark and stormy","Coke'n'rum","Mojito","Pina Colada","Sour shots","Tequila","Licourice shots","Whiskey","Vodka","Brandy"};
//
//        for (int i = 0; i < Images.length; i++){
//        ContentValues valuesToInsert= new ContentValues();
//        valuesToInsert.put(myhelper.DRINKS_IMAGE,Images[i]);
//        valuesToInsert.put(myhelper.PARENT_NAME,drinksArray[i]);
//        long id = db.insert(myhelper.TABLE_PARENT,null,valuesToInsert);
//        }
//
//        for (int i = 0; i < drinksIngredients.length; i++) {
//            ContentValues valuesToInsert= new ContentValues();
//            valuesToInsert.put(myhelper.CHILD_NAME,drinksIngredients[i]);
//            valuesToInsert.put(myhelper.DRINKS_PRICE,drinkPrices[i]);
//            long id = db.insert(myhelper.TABLE_CHILD,null,valuesToInsert);
//        }


        Toast.makeText(this, "Welcome to the bar!", Toast.LENGTH_SHORT).show();


        mExpandableList = (ExpandableListView)findViewById(R.id.drinksMenu);

        ArrayList<Parent> arrayParents = new ArrayList<Parent>();
        ArrayList<String> arrayPrice;
        ArrayList<String> arrayChildren;

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

