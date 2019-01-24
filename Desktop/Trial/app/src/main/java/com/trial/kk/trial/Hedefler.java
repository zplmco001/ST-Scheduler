package com.trial.kk.trial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class Hedefler extends Fragment {

    private Button hedef, pzt, sal, car, per, cu, cm, pz;
    private ScrollView scrollView;
    private GridLayout gl;
    private int count = 0;

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

        gl = view.findViewById(R.id.gridpzt);

        new MyPostit(gl,"asfasf",getContext());
        new MyPostit(gl,"mfmgmg",getContext());

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
    GridLayout getLayout(){

        return gl;
    }

    class MyPostit {


        private TextView tv;

        MyPostit(final GridLayout gl, String text, Context context){

            tv = new TextView(context);
            tv.setText(text);
            tv.setBackgroundDrawable(getResources().getDrawable(R.drawable.note147951_1280));

            gl.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    int pWidth = gl.getWidth();
                    int pHeight = gl.getHeight();
                    int numOfCol = gl.getColumnCount();
                    int numOfRow = gl.getRowCount();
                    int w = pWidth/numOfCol;
                    int h = pHeight/numOfRow;

                    GridLayout.LayoutParams params =
                            (GridLayout.LayoutParams)tv.getLayoutParams();
                    params.width = w - 2*10;
                    params.height = h - 2*10;
                    params.setMargins(10, 10, 10, 10);
                    tv.setLayoutParams(params);
                    tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                }
            });
            gl.setRowCount(2);
            gl.setColumnCount(5);
            gl.addView(tv,count);
            count++;

        }

        public TextView getTv(){
            return tv;
        }

    }


}


