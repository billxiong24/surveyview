package com.example.shreyasingh.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by user on 12/31/15.
 */
public class MenusFragment extends Fragment{

    View myView;
    ListView  menusListView;

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
        imageArray[0] = "https://firebasestorage.googleapis.com/v0/b/quizapp-26149.appspot.com/o/success.png?alt=media&token=23ed29cb-a16f-4a0d-a76d-a8ddf4199b02";
        imageArray[1] = "https://firebasestorage.googleapis.com/v0/b/quizapp-26149.appspot.com/o/x-mark.png?alt=media&token=6b6903a0-bcce-45c0-a031-46943ba03eff";
        imageArray[2] = "https://firebasestorage.googleapis.com/v0/b/quizapp-26149.appspot.com/o/blank.png?alt=media&token=5af928de-9426-460f-b4e6-05bfd808ce41";
        imageArray[3] = "https://firebasestorage.googleapis.com/v0/b/quizapp-26149.appspot.com/o/replay.png?alt=media&token=20a088c3-e6bd-488b-be33-a684d1c54d14";
        MenuList adapter = new
                MenuList(this.getActivity(), optionsArray, imageArray);
        System.out.println("adapter");
        System.out.println(adapter);
        menusListView.setAdapter(adapter);
    }
}
