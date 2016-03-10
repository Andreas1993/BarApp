package com.example.andreasp.myapp;

/**
 * Created by Andreasp on 08-03-2016.
 */

import java.util.ArrayList;

public class Parent {
    private String mTitle;
    private ArrayList<String> mArrayChildren;
    private ArrayList<String> mArrayPrices;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public ArrayList<String> getArrayChildren() {
        return mArrayChildren;
    }
    public ArrayList<String> getArrayPrices(){
        return mArrayPrices;
    }

    public void setArrayChildren(ArrayList<String> arrayChildren) {
        mArrayChildren = arrayChildren;
    }
    public void setArrayPrices(ArrayList<String> arrayPrice) {
        mArrayPrices = arrayPrice;
    }
}
