package com.trial.kk.trial;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
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
    private int drawable[] = {R.drawable.note147951_1280,R.drawable.mavipostit1196,R.drawable.mavipostit2196,R.drawable.morpostit196,R.drawable.yesilpostit1196,
    R.drawable.yesilpostit2196,R.drawable.yesilpostit3196};

    ArrayList<MyPostit> postits = new ArrayList<>();
    private ImageButton[] buttons  = new ImageButton[7];
    private GridLayout[] gridLayouts = new GridLayout[7];
    private TextView pazartesi, sali, carsamba, persembe, cuma, cumartesi, pazar;
    private ArrayList<Integer> pos = new ArrayList<>();

    public static Bundle bund;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hedefler, container, false);

        bund = new Bundle();

        pzt = view.findViewById(R.id.pzt);
        sal = view.findViewById(R.id.sal);
        car = view.findViewById(R.id.car);
        per = view.findViewById(R.id.per);
        cu = view.findViewById(R.id.cum);
        cm = view.findViewById(R.id.cm);
        pz = view.findViewById(R.id.pzr);

        pazartesi = view.findViewById(R.id.Pazartesi);
        sali = view.findViewById(R.id.Sali);
        carsamba = view.findViewById(R.id.Carsamba);
        persembe = view.findViewById(R.id.Persembe);
        cuma = view.findViewById(R.id.Cuma);
        cumartesi = view.findViewById(R.id.Cumartesi);
        pazar = view.findViewById(R.id.Pazar);

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

        gridLayouts[0] = glpzt;
        gridLayouts[1] = glsal;
        gridLayouts[2] = glcar;
        gridLayouts[3] = glper;
        gridLayouts[4] = glcum;
        gridLayouts[5] = glcmt;
        gridLayouts[6] = glpaz;

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

        buttons[0] = hedefpzt;
        buttons[1] = hedefsal;
        buttons[2] = hedefcar;
        buttons[3] = hedefper;
        buttons[4] = hedefcum;
        buttons[5] = hedefcmt;
        buttons[6] = hedefpaz;


        new MyPostit(glpzt,hedefpzt,"Matematik","Matematik",getContext(),0);
        new MyPostit(glpzt,hedefpzt,"Türkçe","Matematik",getContext(),1);
        new MyPostit(glpzt,hedefpzt,"Fizik","Matematik",getContext(),2);
        new MyPostit(glpzt,hedefpzt,"Kimya","Matematik",getContext(),3);
        new MyPostit(glpzt,hedefpzt,"Tarih","Matematik",getContext(),4);
        new MyPostit(glpzt,hedefpzt,"Coğrafya","Matematik",getContext(),5);
        new MyPostit(glpzt,hedefpzt,"Din","Matematik",getContext(),6);
        new MyPostit(glpzt,hedefpzt,"Biyoloji","Matematik",getContext(),7);
        new MyPostit(glpzt,hedefpzt,"Biyoloji","Matematik",getContext(),8);
        new MyPostit(glsal,hedefsal,"Biyoloji","Matematik",getContext(),0);
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

    @Override
    public void onResume() {
        super.onResume();

        if(!bund.isEmpty()){
            Log.e("Bundle",String.valueOf(bund.size()));
            int index = bund.getInt("Integer");
            Log.e("Day",String.valueOf(index));
            String front,back;
            if (bund.size()==2){
                front = bund.getString("Text1");
                back = "";
            }
            else {
                front = bund.getString("Text1");
                back = bund.getString("Text2");
            }
            int set = gridLayouts[index].getChildCount()-1;
            postits.add(new MyPostit(gridLayouts[index],buttons[index],front,back,getContext(),set));
        }

        //Log.e("Tag",bund.getString("String"));
        //Log.e("TAG",getArguments().getString("String"));

        Log.e("resume","resume");

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

        int index;

        HedefListener(int index){
            this.index = index;
        }

        @Override
        public void onClick(View view) {

            Intent i = new Intent(getContext(), HedefPopup.class);

            i.putExtra("day",index);

            startActivity(i);

        }
    }



    private class ButtonListener implements View.OnClickListener{


        private int day;

        ButtonListener(int day){
            this.day = day;

            pos.add(0);
            int[] location = new int[2];
            //sali.getLocationOnScreen(location);
            sali.getLocationInWindow(location);

            pos.add(sali.getTop());

            carsamba.getLocationOnScreen(location);
            pos.add(carsamba.getTop());

            persembe.getLocationOnScreen(location);
            pos.add(persembe.getTop());

            cuma.getLocationOnScreen(location);
            pos.add(cuma.getTop());

            cumartesi.getLocationOnScreen(location);
            pos.add(cumartesi.getTop());

            pazar.getLocationOnScreen(location);
            pos.add(pazar.getTop());
            Log.e("Pos",String.valueOf(pos.get(pos.size()-1)));

        }


        @Override
        public void onClick(View view) {
            scrollView.post(new Runnable() {
                @Override
                public void run() {
                    scrollView.smoothScrollTo(0,pos.get(day));
                }
            });
        }
    }


    class MyPostit {


        private TextView tv;
        private int flag = 0;

        MyPostit(final GridLayout gl, final ImageButton btn, final String front, final String back, Context context, int a){

            DisplayMetrics displaymetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            int height = displaymetrics.heightPixels;
            int width = displaymetrics.widthPixels;

            tv = new TextView(context);
            tv.setText(front);
            tv.setBackgroundDrawable(getResources().getDrawable(drawable[a%7]));
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag == 0&& !back.equals("")){
                        flag = 1;
                        tv.setText(back);
                    }
                    else {
                        flag = 0;
                        tv.setText(front);
                    }
                }
            });

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
                    tv.setTextSize(20);
                    tv.setTextColor(Color.BLACK);
                    tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                    setButtonSize(btn, gl);


                }
            });

            gl.addView(tv,a);

        }

    }

}


