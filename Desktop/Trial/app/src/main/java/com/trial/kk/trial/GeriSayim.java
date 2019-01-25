package com.trial.kk.trial;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by mehmetcanolgun on 16.01.2019.
 */

public class GeriSayim extends Fragment{

    private TextView textView;
    private TextView textgün1,textsaat1,textdk1,textsn1;
    private TextView textView2;
    private TextView textgün2,textsaat2,textdk2,textsn2;

    private ProgressBar pbgün1,pbsaat1,pbdk1,pbsn1;
    private ProgressBar pbgün2,pbsaat2,pbdk2,pbsn2;

    private SimpleDateFormat dateFormat;
    private long days,hours,minutes,seconds;
    private Date currentDate;
    private Date futureDate,futureDate2;
    private long difference,difference2;
    private TextView tv;
    private int pStatus;
    private CountDownTimer cdt,cdt1;
    private Drawable drawable;
    private Resources res;



    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.gerisayim_layout, container, false);

        textView = (TextView) view.findViewById(R.id.textView);
        textgün1 = (TextView) view.findViewById(R.id.textgün1);
        textsaat1 =(TextView) view.findViewById(R.id.textsaat1);
        textdk1 = (TextView) view.findViewById(R.id.textdk1);
        textsn1 = (TextView) view.findViewById(R.id.textsn1);

        textView2 = (TextView) view.findViewById(R.id.textView2);
        textgün2 = (TextView) view.findViewById(R.id.textgün2);
        textsaat2 = (TextView) view.findViewById(R.id.textsaat2);
        textdk2 = (TextView) view.findViewById(R.id.textdk2);
        textsn2 = (TextView) view.findViewById(R.id.textsn2);

        res = getResources();
        drawable = res.getDrawable(R.drawable.circular);
        pbgün1= (ProgressBar) view.findViewById(R.id.pbgün1);
        pbgün1.setProgress(0);
        pbgün1.setSecondaryProgress(200);
        pbgün1.setMax(100);
        pbgün1.setProgressDrawable(drawable);

        drawable = res.getDrawable(R.drawable.circular);
        pbsaat1= (ProgressBar) view.findViewById(R.id.pbsaat1);
        pbsaat1.setProgress(0);
        pbsaat1.setSecondaryProgress(200);
        pbsaat1.setMax(100);
        pbsaat1.setProgressDrawable(drawable);

        drawable = res.getDrawable(R.drawable.circular);
        pbdk1= (ProgressBar) view.findViewById(R.id.pbdk1);
        pbdk1.setProgress(0);
        pbdk1.setSecondaryProgress(200);
        pbdk1.setMax(100);
        pbdk1.setProgressDrawable(drawable);

        drawable = res.getDrawable(R.drawable.circular);
        pbsn1= (ProgressBar) view.findViewById(R.id.pbsn1);
        pbsn1.setProgress(0);
        pbsn1.setSecondaryProgress(200);
        pbsn1.setMax(100);
        pbsn1.setProgressDrawable(drawable);

        drawable = res.getDrawable(R.drawable.circular);
        pbgün2= (ProgressBar) view.findViewById(R.id.pbgün2);
        pbgün2.setProgress(0);
        pbgün2.setSecondaryProgress(200);
        pbgün2.setMax(100);
        pbgün2.setProgressDrawable(drawable);

        drawable = res.getDrawable(R.drawable.circular);
        pbsaat2= (ProgressBar) view.findViewById(R.id.pbsaat2);
        pbsaat2.setProgress(0);
        pbsaat2.setSecondaryProgress(200);
        pbsaat2.setMax(100);
        pbsaat2.setProgressDrawable(drawable);

        drawable = res.getDrawable(R.drawable.circular);
        pbdk2= (ProgressBar) view.findViewById(R.id.pbdk2);
        pbdk2.setProgress(0);
        pbdk2.setSecondaryProgress(200);
        pbdk2.setMax(100);
        pbdk2.setProgressDrawable(drawable);

        drawable = res.getDrawable(R.drawable.circular);
        pbsn2= (ProgressBar) view.findViewById(R.id.pbsn2);
        pbsn2.setProgress(0);
        pbsn2.setSecondaryProgress(200);
        pbsn2.setMax(100);
        pbsn2.setProgressDrawable(drawable);



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
                pbgün1.setProgress((int)days*100/365);
                textgün1.setText("  "+days+"\n  Gün");

                hours=difference/(60*60*1000);
                difference-=hours*60*60*1000;
                pbsaat1.setProgress((int)hours*100/24);
                textsaat1.setText("    "+hours+"\n    Saat");

                minutes=  difference/(60*1000);
                difference-=minutes*60*1000;
                pbdk1.setProgress((int) minutes*100/60);
                textdk1.setText(minutes+"\nDakika");


                seconds=  difference/1000;
                pbsn1.setProgress((int) seconds*100/60);
                textsn1.setText(seconds+"\nSaniye");



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
                pbgün2.setProgress((int)days*100/365);
                textgün2.setText(days+"\nGün");

                hours=  difference2/(60*60*1000);
                difference2-=hours*60*60*1000;
                pbsaat2.setProgress((int)hours*100/24);
                textsaat2.setText(hours+"\nSaat");

                minutes=  difference2/(60*1000);
                difference2-=minutes*60*1000;
                pbdk2.setProgress((int)minutes*100/60);
                textdk2.setText(minutes+"\nDakika");


                seconds=  difference2/1000;
                // pStatus=(int) seconds*100/60;
                pbsn2.setProgress((int) seconds*100/60);
                textsn2.setText(seconds+"\nSaniye");
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
