package com.example.shreyasingh.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by shreyasingh on 10/29/17.
 */

public class MyMenuListItem extends ArrayAdapter<String> {
    private final Activity context;

    public MyMenuListItem(Activity context, String[] menuName) {
        super(context, R.layout.menu_item, menuName);
        this.context = context;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.my_menu_item, null, true);
        TextView menuName = (TextView) rowView.findViewById(R.id.menuName);
        TextView location = (TextView) rowView.findViewById(R.id.location);
        TextView responses = (TextView) rowView.findViewById(R.id.responses);
        ImageView editButton = (ImageView) rowView.findViewById(R.id.editButton);
        ImageView analyzeButton = (ImageView) rowView.findViewById(R.id.analyzeButton);

        editButton.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              context.startActivity(new Intent(context, EditMenuActivity.class));
                                          }
                                      });

                location.setText("West Union");
        return rowView;
    }

}
