package com.example.shreyasingh.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;x
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shreyasingh on 10/29/17.
 */

public class ExpandableFoodItemEditorAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> foodHeaders;
    private HashMap<String, List<String>> foodHashMap;
    private EditMenuActivity activity;

    public ExpandableFoodItemEditorAdapter(Context context, EditMenuActivity activity, List<String> foodHeaders, HashMap<String, List<String>> foodHashMap) {
        this.context = context;
        this.foodHeaders = foodHeaders;
        this.activity = activity;
        this.foodHashMap = foodHashMap;
    }

    @Override
    public int getGroupCount() {
        return foodHeaders.size() + 1 ;
    }

    @Override
    public int getChildrenCount(int i) {
        return foodHashMap.get(foodHeaders.get(i)).size() + 1;
    }

    @Override
    public Object getGroup(int i) {
        if(i == foodHeaders.size()){
            return "add";
        }
        return foodHeaders.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        if(i1 == foodHashMap.get(
                foodHeaders.get(i)).size()){
            return "add";
        }
        return foodHashMap.get(
                foodHeaders.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {

        return i;
    }

    @Override
    public long getChildId(int i, int i1) {

        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String headerTitle = (String) getGroup(i);
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.editable_food_group, null);

        }
        if(i == foodHeaders.size()){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.add_group, null);
            return view;
        }


        EditText menuHeader = (EditText) view.findViewById(R.id.menuName);
        menuHeader.setTypeface(null, Typeface.BOLD);
        menuHeader.setText(headerTitle);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        final String childText = (String) getChild(i, i1);
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.editable_food_item, null);

        }

        if(i1 == foodHashMap.get(foodHeaders.get(i)).size()){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.add_food_item, null);
            return view;
        }
        EditText foodName = (EditText) view.findViewById(R.id.foodName);
        foodName.setText(childText);
        view.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        //ExpandableFoodItemAdapter.this.context.startActivity(new Intent(ExpandableFoodItemAdapter.this.activity, FoodInfo.class));

                                        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                        View customView = inflater.inflate(R.layout.food_popup, null);
                                        activity.myPopUp = new PopupWindow(
                                                customView,
                                                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                                                ConstraintLayout.LayoutParams.WRAP_CONTENT);

                                        ImageButton closePopUp = (ImageButton) customView.findViewById(R.id.close);
                                        closePopUp.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                activity.myPopUp.dismiss();
                                            }
                                        });

                                        activity.myPopUp.showAtLocation(activity.positionOfPopup, Gravity.CENTER,0,0);

                                    }


                                }
        );
        return view;
    }



    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}