package com.trial.kk.trial;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

public class Hedefler extends Fragment {

    private Button hedef, pzt, sal, car, per, cu, cm, pz;
    private ScrollView scrollView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hedefler, container, false);

        pzt = view.findViewById(R.id.pzt);
        sal = view.findViewById(R.id.sal);
        car = view.findViewById(R.id.car);
        per = view.findViewById(R.id.per);
        cu = view.findViewById(R.id.cum);
        cm = view.findViewById(R.id.cm);
        pz = view.findViewById(R.id.pzr);

        pzt.setOnClickListener(new ButtonListener(0));
        sal.setOnClickListener(new ButtonListener(1));
        car.setOnClickListener(new ButtonListener(2));
        per.setOnClickListener(new ButtonListener(3));
        cu.setOnClickListener(new ButtonListener(4));
        cm.setOnClickListener(new ButtonListener(5));
        pz.setOnClickListener(new ButtonListener(6));



        scrollView = view.findViewById(R.id.hedefScroll);

        hedef = view.findViewById(R.id.hedef);
        hedef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),HedefPopup.class);
                startActivity(i);
            }
        });

        return view;

    }

    List<MyPostit> myPostits = new ArrayList<>();


    private class ButtonListener implements View.OnClickListener{

        private ArrayList<Integer> pos = new ArrayList<>();
        private int day;

        ButtonListener(int day){
            this.day = day;
            pos.add(130);
            pos.add(500);
            pos.add(870);
            pos.add(1040);
            pos.add(1210);
            pos.add(1380);
            pos.add(1550);
        }

        @Override
        public void onClick(View view) {
            scrollView.post(new Runnable() {
                @Override
                public void run() {
                    scrollView.scrollTo(0,pos.get(day));
                }
            });
        }
    }

}
