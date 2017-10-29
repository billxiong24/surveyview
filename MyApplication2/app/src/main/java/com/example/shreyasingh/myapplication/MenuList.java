package com.example.shreyasingh.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Ritler on 9/30/17.
 */

public class MenuList extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] web;
    private final String[] imageId;
    public MenuList(Activity context,
                      String[] web, String[] imageId) {
        super(context, R.layout.menu_item, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.menu_item, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        TextView location = (TextView) rowView.findViewById(R.id.loc) ;
        txtTitle.setText(web[position]);
        location.setText("West Union");
        //loadImageFromUrl(imageId[position], imageView);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                context.startActivity(new Intent(context, MenuActivity.class));
            }
        });
        return rowView;
    }
    public void loadImageFromUrl(String url, ImageView imageView){
        Picasso.with(context).load(url).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView, new com.squareup.picasso.Callback(){

                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}