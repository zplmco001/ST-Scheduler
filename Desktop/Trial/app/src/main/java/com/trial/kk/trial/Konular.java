package com.trial.kk.trial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by mehmetcanolgun on 16.01.2019.
 */

public class Konular extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.konular_layout, container, false);


        ConstraintLayout cl = view.findViewById(R.id.cs);

        String[] listOfTitles = new String[10];
        for (int i=0; i<5; i++){
            listOfTitles[i]="Deneme";

        }

        for(String title: listOfTitles){
            TextView field = new TextView(getActivity());
            field.setText(title);

            cl.addView(field);
        }

        return view;
    }
}
