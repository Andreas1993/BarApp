package com.example.andreasp.myapp;

/**
 * Created by Andreasp on 08-03-2016.
 */

import java.util.ArrayList;

public class Parent {
    private String mTitle;
    private ArrayList<String> mArrayChildren;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public ArrayList<String> getArrayChildren() {
        return mArrayChildren;
    }

    public void setArrayChildren(ArrayList<String> arrayChildren) {
        mArrayChildren = arrayChildren;
    }
}
