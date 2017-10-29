package com.example.shreyasingh.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by shreyasingh on 10/29/17.
 */

public class MyMenusFragment extends Fragment {

    View myView;
    ListView menusListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.menu_layout, container, false);
        return myView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        menusListView = (ListView) getView().findViewById(R.id.quizlistView);
    }

    @Override
    public void onStart() {
        super.onStart();
        String[] optionsArray = new String[4];
        String[] imageArray = new String[4];
        optionsArray[0] = "ABP";
        optionsArray[1] = "Il Forno";
        optionsArray[2] = "Cafe";
        optionsArray[3] = "Tandoor";
        MyMenuListItem adapter = new
                MyMenuListItem(this.getActivity(), optionsArray);
        System.out.println("adapter");
        System.out.println(adapter);
        menusListView.setAdapter(adapter);
    }
}