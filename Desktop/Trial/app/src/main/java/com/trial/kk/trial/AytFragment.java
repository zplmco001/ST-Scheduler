package com.trial.kk.trial;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by kursat on 3.02.2019.
 */

public class AytFragment extends Fragment {

    String ders[] = {"Matematik","Türkçe"};
    ArrayList<String> matKonu = new ArrayList<>();
    ArrayList<String> turKonu = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ayt_fragment,container,false);

        LinearLayout linearLayout = view.findViewById(R.id.aytLayout);

        matKonu.add("Konu1jknçbxşlbn");
        matKonu.add("Konu2");
        matKonu.add("Konu3");

        turKonu.add("KonuA");
        turKonu.add("KonuB");


        KonularView konu = new KonularView(getContext(),ders[0],matKonu);
        linearLayout.addView(konu.getLinearLayout());

        KonularView konu1= new KonularView(getContext(),ders[1],turKonu);
        linearLayout.addView(konu1.getLinearLayout());


        return view;
    }
}
