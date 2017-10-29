package com.example.shreyasingh.myapplication;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private ExpandableListView foodList;
    private ExpandableFoodItemAdapter foodAdapter;
    private List<String> foodHeader;
    private HashMap<String, List<String>> foodHash;
    public PopupWindow myPopUp ;
    public ConstraintLayout positionOfPopup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        positionOfPopup = (ConstraintLayout) findViewById(R.id.position);
        initData();
        foodList = (ExpandableListView) findViewById(R.id.foodList);
        foodAdapter = new ExpandableFoodItemAdapter(this, this, foodHeader, foodHash);
        foodList.setAdapter(foodAdapter);

        foodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("ListClikc","Yes");
            }


        });

    }

    private void initData(){
        foodHeader = new ArrayList<>();
        foodHash = new HashMap<>();
        foodHeader.add("Breakfast");
        foodHeader.add("Lunch");
        foodHeader.add("Dinner");

        List<String> breakfast = new ArrayList<>();
        breakfast.add("Eggs");
        breakfast.add("Bacon");
        breakfast.add("Pancake");

        List<String> lunch = new ArrayList<>();
        lunch.add("sandwhich");
        lunch.add("taco");
        lunch.add("wrap");

        List<String> dinner = new ArrayList<>();
        dinner.add("pasta");
        dinner.add("chicken parmesan");
        dinner.add("stir-fry");

        foodHash.put(foodHeader.get(0), breakfast);
        foodHash.put(foodHeader.get(1), lunch);
        foodHash.put(foodHeader.get(2), dinner);

    }

}
