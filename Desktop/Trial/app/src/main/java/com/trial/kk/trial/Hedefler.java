package com.trial.kk.trial;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class Hedefler extends Fragment {

    private Button pzt, sal, car, per, cu, cm, pz;
    private ImageButton hedefpzt, hedefsal, hedefcar, hedefper, hedefcum, hedefcmt, hedefpaz;
    private ScrollView scrollView;
    private GridLayout glpzt, glsal, glcar, glper, glcum, glcmt, glpaz;
    private int count = 0;
    int drawable[] = {R.drawable.note147951_1280,R.drawable.mavipostit1196,R.drawable.mavipostit2196,R.drawable.morpostit196,R.drawable.yesilpostit1196,
    R.drawable.yesilpostit2196,R.drawable.yesilpostit3196};
    public ArrayList<MyPostit> postits = new ArrayList<>();

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

        glpzt = view.findViewById(R.id.gridpzt);
        glsal = view.findViewById(R.id.gridsali);
        glcar = view.findViewById(R.id.gridcarsamba);
        glper = view.findViewById(R.id.gridpersembe);
        glcum = view.findViewById(R.id.gridcuma);
        glcmt = view.findViewById(R.id.gridcumartesi);
        glpaz = view.findViewById(R.id.gridpazar);

        hedefpzt = view.findViewById(R.id.hedefpzt);
        hedefpzt.setOnClickListener(new HedefListener(0));

        hedefsal = view.findViewById(R.id.hedefsal);
        hedefsal.setOnClickListener(new HedefListener(1));

        hedefcar = view.findViewById(R.id.hedefcar);
        hedefcar.setOnClickListener(new HedefListener(2));

        hedefper = view.findViewById(R.id.hedefper);
        hedefper.setOnClickListener(new HedefListener(3));

        hedefcum = view.findViewById(R.id.hedefcum);
        hedefcum.setOnClickListener(new HedefListener(4));

        hedefcmt = view.findViewById(R.id.hedefcmt);
        hedefcmt.setOnClickListener(new HedefListener(5));

        hedefpaz = view.findViewById(R.id.hedefpaz);
        hedefpaz.setOnClickListener(new HedefListener(6));



        new MyPostit(glpzt,hedefpzt,"Matematik",getContext(),0);
        new MyPostit(glpzt,hedefpzt,"Türkçe",getContext(),1);
        new MyPostit(glpzt,hedefpzt,"Fizik",getContext(),2);
        new MyPostit(glpzt,hedefpzt,"Kimya",getContext(),3);
        new MyPostit(glpzt,hedefpzt,"Tarih",getContext(),4);
        new MyPostit(glpzt,hedefpzt,"Coğrafya",getContext(),5);
        new MyPostit(glpzt,hedefpzt,"Din",getContext(),6);
        new MyPostit(glpzt,hedefpzt,"Biyoloji",getContext(),7);
        new MyPostit(glpzt,hedefpzt,"Biyoloji",getContext(),8);
        new MyPostit(glsal,hedefsal,"Biyoloji",getContext(),0);
        //new MyPostit(glsal,hedefsal,"Biyoloji",getContext(),1);

        setButtonSize(hedefpzt, glpzt);
        setButtonSize(hedefsal, glsal);
        setButtonSize(hedefcar,glcar);
        setButtonSize(hedefper,glper);
        setButtonSize(hedefcum,glcum);
        setButtonSize(hedefcmt,glcmt);
        setButtonSize(hedefpaz,glpaz);


       /* GridLayout.LayoutParams prm = (GridLayout.LayoutParams) hedefpzt.getLayoutParams();
        prm.width = glpzt.getWidth()-10;
        prm.height = glpzt.getWidth()-10;
        prm.setMargins(5,5,5,5);
        hedefpzt.setLayoutParams(prm);*/

        scrollView = view.findViewById(R.id.hedefScroll);

        return view;

    }

    void setButtonSize(ImageButton btn, GridLayout gl){



        //int pWidth = gl.getWidth();
        int pWidth = getActivity().getWindowManager().getDefaultDisplay().getWidth()-42;
        int numOfCol = gl.getColumnCount();

        int w = pWidth/numOfCol;
        Log.e("btnsize",String.valueOf(getActivity().getWindowManager().getDefaultDisplay().getWidth()));
        GridLayout.LayoutParams prm = (GridLayout.LayoutParams) btn.getLayoutParams();

        prm.width = w - 10;
        prm.height = w - 10;
        prm.setMargins(5,5,5,5);
        btn.setLayoutParams(prm);

    }

    private class HedefListener implements View.OnClickListener{

        String gun[] = {"Pazartesi","Salı","Çarşamba","Perşembe","Cuma","Cumartesi","Pazar"};
        int index;

        HedefListener(int index){
            this.index = index;
        }

        @Override
        public void onClick(View view) {

            Intent i = new Intent(getContext(), HedefPopup.class);
            startActivity(i);

        }
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


    class MyPostit {


        private TextView tv;

        MyPostit(final GridLayout gl,final ImageButton btn, String text, Context context, int a){

            DisplayMetrics displaymetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            int height = displaymetrics.heightPixels;
            int width = displaymetrics.widthPixels;

            tv = new TextView(context);
            tv.setText(text);
            tv.setBackgroundDrawable(getResources().getDrawable(drawable[a%7]));

            gl.setRowCount(4);
            gl.setColumnCount(3);
            gl.setMinimumWidth(width);
            gl.setMinimumHeight(height/2);

            gl.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {

                    gl.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                    int pWidth = gl.getWidth();
                    int pHeight = gl.getHeight();
                    int numOfCol = gl.getColumnCount();
                    int numOfRow = gl.getRowCount();
                    int w = pWidth/numOfCol;
                   // int h = pHeight/numOfRow;


                    GridLayout.LayoutParams params =
                            (GridLayout.LayoutParams)tv.getLayoutParams();
                    params.width = w - 10;
                    params.height = w - 10;
                    params.setMargins(5, 5, 5, 5);

                    tv.setLayoutParams(params);
                    tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                    setButtonSize(btn, gl);
                    /*setButtonSize(hedefsal, glsal);
                    setButtonSize(hedefcar,glcar);
                    setButtonSize(hedefper,glper);
                    setButtonSize(hedefcum,glcum);
                    setButtonSize(hedefcmt,glcmt);
                    setButtonSize(hedefpaz,glpaz);*/

                }
            });


            gl.addView(tv,a);
            count++;

        }

    }

}


