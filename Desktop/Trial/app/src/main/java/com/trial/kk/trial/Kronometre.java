package com.trial.kk.trial;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

/**
 * Created by HP on 24.01.2019.
 */

public class Kronometre extends Fragment {

    private EditText houredit,minuteedit,secondedit;
    private Button start,stop,reset;
    private Button tytsüre,aytsüre,ydtsüre;
    private ProgressBar progressBar;
    private Drawable drawable;
    private Resources res;
    private CountDownTimer countDownTimer;
    private AlertDialog.Builder builder;
    private LinearLayout linearLayout;


    private int hour,minute,second;
    private double h,m,s;
    private int progress=0,check=0,click=0;
    private double totaltime;
    private int flag=0;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.kronometre_layout, container, false);

        houredit = (EditText) view.findViewById(R.id.houredit);
        minuteedit = (EditText) view.findViewById(R.id.minuteedit);
        secondedit = (EditText) view.findViewById(R.id.secondedit);

        houredit.setCursorVisible(false);
        minuteedit.setCursorVisible(false);
        secondedit.setCursorVisible(false);

        linearLayout = view.findViewById(R.id.linearLayout);

        linearLayout.bringToFront();


        start  = (Button) view.findViewById(R.id.start);
        stop  = (Button) view.findViewById(R.id.stop);
        reset  = (Button) view.findViewById(R.id.reset);

        tytsüre = (Button) view.findViewById(R.id.tytsüre);
        aytsüre = (Button) view.findViewById(R.id.aytsüre);
        ydtsüre = (Button) view.findViewById(R.id.ydtsüre);


        res = getResources();
        drawable = res.getDrawable(R.drawable.circular);
        progressBar = (ProgressBar) view.findViewById(R.id.sayac);
        progressBar.setProgress(0);
        progressBar.setSecondaryProgress(200);
        progressBar.setMax(100);
        progressBar.setProgressDrawable(drawable);

        stop.setEnabled(false);
        reset.setEnabled(true);

        tytsüre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag=1;
                houredit.setText("02");
                minuteedit.setText("15");
                secondedit.setText("00");
                houredit.setEnabled(false);
                minuteedit.setEnabled(false);
                secondedit.setEnabled(false);
                reset.setEnabled(true);
            }
        });

        aytsüre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag=2;
                houredit.setText("03");
                minuteedit.setText("00");
                secondedit.setText("00");
                houredit.setEnabled(false);
                minuteedit.setEnabled(false);
                secondedit.setEnabled(false);
                reset.setEnabled(true);
            }
        });

        ydtsüre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag=3;
                houredit.setText("02");
                minuteedit.setText("00");
                secondedit.setText("00");
                houredit.setEnabled(false);
                minuteedit.setEnabled(false);
                secondedit.setEnabled(false);
                reset.setEnabled(true);
            }
        });


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(houredit.getText().toString().equals("") && minuteedit.getText().toString().equals("") && secondedit.getText().toString().equals("")){

                }else{
                    check=1;
                    start.setEnabled(false);
                    stop.setEnabled(true);
                    reset.setEnabled(true);
                    tytsüre.setEnabled(false);
                    aytsüre.setEnabled(false);
                    ydtsüre.setEnabled(false);

                    houredit.setEnabled(false);
                    minuteedit.setEnabled(false);
                    secondedit.setEnabled(false);

                    if(houredit.getText().toString().equals("")){
                        houredit.setText("00");
                    }
                    if(minuteedit.getText().toString().equals("")){
                        minuteedit.setText("00");
                    }
                    if(secondedit.getText().toString().equals("")){
                        secondedit.setText("00");
                    }

                    if(Integer.parseInt(minuteedit.getText().toString())>59){
                        minuteedit.setText("59");
                    }
                    if(Integer.parseInt(secondedit.getText().toString())>59){
                        secondedit.setText("59");
                    }
                    hour=Integer.parseInt(houredit.getText().toString());
                    minute=Integer.parseInt(minuteedit.getText().toString());
                    second=Integer.parseInt(secondedit.getText().toString());

                    totaltime=(hour*60*60*1000)+(minute*60*1000)+(second*1000);
                    Log.e("ilk tot", "onTick: "+totaltime);
                    if(click==1){
                        totaltime+=500;
                    }else{
                        progressBar.setMax((int)totaltime-1000);
                    }


                    countDownTimer=new CountDownTimer((long)totaltime,500) {
                        @Override
                        public void onTick(long totaltime) {


                            progressBar.setProgress(progress);

                            h=totaltime/(60*60*1000);
                            totaltime-=h*60*60*1000;
                            if(h<10){
                                houredit.setText("0"+h);
                            }else{
                                houredit.setText(String.valueOf(h));
                            }

                            m=totaltime/(60*1000);
                            totaltime-=m*60*1000;
                            if(m<10){
                                minuteedit.setText("0"+m);
                            }else{
                                minuteedit.setText(String.valueOf(m));
                            }



                            s=totaltime/1000;
                            if(s<10){
                                secondedit.setText("0"+(s));
                            }else{

                                secondedit.setText(String.valueOf(s));
                            }

                            progress+=500;


                        }

                        @Override
                        public void onFinish() {
                            progressBar.setProgress(0);
                            progress=0;
                            click=0;
                            houredit.setEnabled(true);
                            minuteedit.setEnabled(true);
                            secondedit.setEnabled(true);
                            start.setEnabled(true);
                            stop.setEnabled(false);
                            reset.setEnabled(false);
                            tytsüre.setEnabled(true);
                            aytsüre.setEnabled(true);
                            ydtsüre.setEnabled(true);
                            houredit.setText("");
                            minuteedit.setText("");
                            secondedit.setText("");
                            switch (flag){
                                case 0:
                                    builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Koz Karo");
                                    builder.setMessage("Süre tamamlandı!");
                                    builder.show();
                                    break;

                                case 1:
                                    builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("TYT SINAVI");
                                    builder.setMessage("TYT SINAVI SONA ERDİ.LÜTFEN KALEMLERİ BIRAKIN!");
                                    builder.show();
                                    break;

                                case 2:
                                    builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("AYT SINAVI");
                                    builder.setMessage("AYT SINAVI SONA ERDİ.LÜTFEN KALEMLERİ BIRAKIN!");
                                    builder.show();
                                    break;

                                case 3:
                                    builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("YDT SINAVI");
                                    builder.setMessage("YDT SINAVI SONA ERDİ.LÜTFEN KALEMLERİ BIRAKIN!");
                                    builder.show();
                                    break;
                            }
                        }
                    }.start();
                }
            }
        });


        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check==1){
                    click=1;
                    countDownTimer.cancel();
                    start.setEnabled(true);
                    tytsüre.setEnabled(true);
                    aytsüre.setEnabled(true);
                    ydtsüre.setEnabled(true);
                }
            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flag>0 || flag<4){
                    if(check==1){
                        countDownTimer.cancel();
                    }
                    flag=0;
                    houredit.setText("");
                    minuteedit.setText("");
                    secondedit.setText("");
                    houredit.setEnabled(true);
                    minuteedit.setEnabled(true);
                    secondedit.setEnabled(true);
                    start.setEnabled(true);
                    stop.setEnabled(false);
                    tytsüre.setEnabled(true);
                    aytsüre.setEnabled(true);
                    ydtsüre.setEnabled(true);
                    progress=0;
                    click=0;
                    progressBar.setProgress(0);
                }
            }
        });


        return view;
    }

}