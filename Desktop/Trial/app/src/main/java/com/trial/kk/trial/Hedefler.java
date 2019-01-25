package com.trial.kk.trial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
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
    int drawable[] = {R.drawable.note147951_1280,R.drawable.mavipostit1196,R.drawable.mavipostit2196,R.drawable.morpostit196,R.drawable.yesilpostit1196,
    R.drawable.yesilpostit2196,R.drawable.yesilpostit3196};

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

        hedef = view.findViewById(R.id.hedef);

        new MyPostit(gl,"Matematik",getContext(),0);
        new MyPostit(gl,"Türkçe",getContext(),1);
        new MyPostit(gl,"Fizik",getContext(),2);
        new MyPostit(gl,"Kimya",getContext(),3);
        new MyPostit(gl,"Tarih",getContext(),4);
        new MyPostit(gl,"Coğrafya",getContext(),5);
        new MyPostit(gl,"Din",getContext(),6);
        new MyPostit(gl,"Biyoloji",getContext(),7);


        int width = gl.getWidth()/3 - 2*10;
        hedef.setWidth(width);
        hedef.setHeight(width);

        scrollView = view.findViewById(R.id.hedefScroll);


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

    private class MyPostit {


        private TextView tv;

        MyPostit(final GridLayout gl, String text, Context context, int a){

            DisplayMetrics displaymetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            int height = displaymetrics.heightPixels;
            int width = displaymetrics.widthPixels;

            tv = new TextView(context);
            tv.setText(text);
            tv.setBackgroundDrawable(getResources().getDrawable(drawable[a%7]));

            gl.setRowCount(3);
            gl.setColumnCount(3);
            gl.setMinimumWidth(width);
            gl.setMinimumHeight(height/2);

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
                    params.height = w - 2*10;
                    params.setMargins(10, 10, 10, 10);
                    tv.setLayoutParams(params);
                    tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);


                    GridLayout.LayoutParams prm = (GridLayout.LayoutParams)hedef.getLayoutParams();
                    prm.width = w - 2*10;
                    prm.height = w - 2*10;

                    prm.setMargins(10,10,10,10);
                    hedef.setLayoutParams(prm);
                    hedef.setPadding(0,50,0,0);
                }
            });


            gl.addView(tv,count);
            count++;

        }

        public TextView getTv(){
            return tv;
        }

    }


}


