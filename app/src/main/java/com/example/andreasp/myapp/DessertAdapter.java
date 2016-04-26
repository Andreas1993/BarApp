package com.example.andreasp.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Andreasp on 26-04-2016.
 */
public class DessertAdapter extends BaseAdapter {

    String[] data;
    Context context;
    private LayoutInflater dessertInflater;
    TextView dessertText;




    public DessertAdapter(String[] data, Context context){
        super();
        this.data = data;
        this.context = context;
        dessertInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = dessertInflater.inflate(R.layout.dessert_list_layout, parent, false);
        }
        dessertText = (TextView)convertView.findViewById(R.id.dessertListText);

        dessertText.setText(data[position]);

        return convertView;
    }


}
