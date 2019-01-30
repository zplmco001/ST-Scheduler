package com.trial.kk.trial;

import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by mehmetcanolgun on 16.01.2019.
 */

public class GeriSayim extends Fragment{


    private TextView textsaat,textgün,textdk,textsn,textsaat1,textgün1,textdk1,textsn1,sınavtext;
    private TextView gün,saat,saniye,dakika;


    private SimpleDateFormat dateFormat;
    private long days,hours,minutes,seconds;
    private Date currentDate;
    private Date futureDate,futureDate2;
    private long difference,difference2;
    private TextView tv;
    private CountDownTimer cdt,cdt1;
    private LinearLayout tytlay,aytlay;
    private Animation animation;





    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.gerisayim_layout, container, false);

        //((AppCompatActivity) getActivity()) .getSupportActionBar().hide();

        gün = (TextView) view.findViewById(R.id.gün);
        saat = (TextView) view.findViewById(R.id.saat);
        dakika = (TextView) view.findViewById(R.id.dakika);
        saniye = (TextView) view.findViewById(R.id.saniye);

        textgün = (TextView) view.findViewById(R.id.textgün);
        textsaat = (TextView) view.findViewById(R.id.textsaat);
        textdk = (TextView) view.findViewById(R.id.textdk);
        textsn = (TextView) view.findViewById(R.id.textsn);

        textgün1 = (TextView) view.findViewById(R.id.textgün1);
        textsaat1 = (TextView) view.findViewById(R.id.textsaat1);
        textdk1 = (TextView) view.findViewById(R.id.textdk1);
        textsn1 = (TextView) view.findViewById(R.id.textsn1);

        sınavtext = (TextView) view.findViewById(R.id.sınavtext);

        tytlay = (LinearLayout) view.findViewById(R.id.tytlay);
        aytlay = (LinearLayout) view.findViewById(R.id.aytlay);

        tytlay.setVisibility(View.VISIBLE);
        aytlay.setVisibility(View.INVISIBLE);

        tytlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlphaAnimation anim = new AlphaAnimation(1.0f, 0.0f);
                anim.setDuration(400);
                anim.setRepeatCount(1);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        tytlay.setVisibility(View.INVISIBLE);
                        sınavtext.setText("AYT GERİ SAYIM");
                        aytlay.setVisibility(View.VISIBLE);
                    }
                });

                sınavtext.startAnimation(anim);
                tytlay.startAnimation(anim);
                textsaat.startAnimation(anim);
                gün.startAnimation(anim);
                saat.startAnimation(anim);
                dakika.startAnimation(anim);
                saniye.startAnimation(anim);


            }
        });

        aytlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlphaAnimation anim = new AlphaAnimation(1.0f, 0.0f);
                anim.setDuration(400);
                anim.setRepeatCount(1);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        aytlay.setVisibility(View.INVISIBLE);
                        sınavtext.setText("TYT GERİ SAYIM");
                        tytlay.setVisibility(View.VISIBLE);
                    }
                });

                sınavtext.startAnimation(anim);
                aytlay.startAnimation(anim);
                textsaat.startAnimation(anim);
                gün.startAnimation(anim);
                saat.startAnimation(anim);
                dakika.startAnimation(anim);
                saniye.startAnimation(anim);

            }
        });

        try {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            futureDate = dateFormat.parse("2019-06-16 08:00:00");

        } catch (ParseException e) {
            e.printStackTrace();
        }
        currentDate = new Date();
        difference= futureDate.getTime()-currentDate.getTime()-(3*60*60*1000);


        cdt = new CountDownTimer(difference,1000) {
            @Override
            public void onTick(long difference) {
                days=  difference/(24*60*60*1000);
                difference-=days *24 * 60 * 60 * 1000;
                if(days<10){
                    textgün.setText("0"+days);
                }else{
                    textgün.setText(String.valueOf(days));
                }


                hours=difference/(60*60*1000);
                difference-=hours*60*60*1000;
                if(hours<10){
                    textsaat.setText("0"+hours);
                }else{
                    textsaat.setText(String.valueOf(hours));
                }


                minutes=  difference/(60*1000);
                difference-=minutes*60*1000;
                if(minutes<10){
                    textdk.setText("0"+minutes);
                }else{
                    textdk.setText(String.valueOf(minutes));
                }



                seconds=  difference/1000;
                if(seconds<10){
                    textsn.setText("0"+seconds);
                }else{
                    textsn.setText(String.valueOf(seconds));
                }




            }

            @Override
            public void onFinish() {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("TYT SINAVI");
                builder.setMessage("Sınav günü!Başarılar :)");
                builder.show();

            }
        }.start();

        difference2=difference+(24*60*60*1000);

        cdt1 = new CountDownTimer(difference2,1000) {
            @Override
            public void onTick(long difference2) {
                days=  difference2/(24*60*60*1000);
                difference2-=days *24 * 60 * 60 * 1000;
                if(days<10){
                    textgün1.setText("0"+days);
                }else{
                    textgün1.setText(String.valueOf(days));
                }


                hours=difference2/(60*60*1000);
                difference2-=hours*60*60*1000;
                if(hours<10){
                    textsaat1.setText("0"+hours);
                }else{
                    textsaat1.setText(String.valueOf(hours));
                }


                minutes=  difference2/(60*1000);
                difference2-=minutes*60*1000;
                if(minutes<10){
                    textdk1.setText("0"+minutes);
                }else{
                    textdk1.setText(String.valueOf(minutes));
                }



                seconds=  difference2/1000;
                if(seconds<10){
                    textsn1.setText("0"+seconds);
                }else{
                    textsn1.setText(String.valueOf(seconds));
                }
            }

            @Override
            public void onFinish() {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("AYT SINAVI");
                builder.setMessage("Sınav günü!Başarılar :)");
                builder.show();
            }
        }.start();

        return view;
    }


}
