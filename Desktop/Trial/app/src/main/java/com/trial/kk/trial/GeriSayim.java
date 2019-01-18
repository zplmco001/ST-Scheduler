package com.trial.kk.trial;

import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by mehmetcanolgun on 16.01.2019.
 */

public class GeriSayim extends Fragment{

    private TextView textView;
    private TextView dayText,hourText,minuteText,secondText;
    private TextView textView2;
    private TextView dayText2,hourText2,minuteText2,secondText2;
    private SimpleDateFormat dateFormat;
    private long days,hours,minutes,seconds;
    private Runnable runnable;
    private Handler handler;
    private Date currentDate;
    private Date futureDate;
    private long difference;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.gerisayim_layout, container, false);

        textView = (TextView) view.findViewById(R.id.textView);
        dayText = (TextView) view.findViewById(R.id.dayText);
        hourText =(TextView) view.findViewById(R.id.hourText);
        minuteText = (TextView) view.findViewById(R.id.minuteText);
        secondText = (TextView) view.findViewById(R.id.secondText);

        textView2 = (TextView) view.findViewById(R.id.textView2);
        dayText2 = (TextView) view.findViewById(R.id.dayText2);
        hourText2 = (TextView) view.findViewById(R.id.hourText2);
        minuteText2 = (TextView) view.findViewById(R.id.minuteText2);
        secondText2 = (TextView) view.findViewById(R.id.secondText2);


        countDownStart();

        return view;
    }


    public void countDownStart(){
        handler = new Handler();
        runnable = new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void run() {
                handler.postDelayed(this,1000);

                try {
                    dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    futureDate = dateFormat.parse("2019-06-15 10:15:00");
                    currentDate = new Date();


                    if(!currentDate.after(futureDate)){
                        difference= futureDate.getTime()-currentDate.getTime()-(3*60*60*1000);//milisaniye cinsinden alıp dönüşüm

                        days=  difference/(24*60*60*1000);

                        difference-=days *24 * 60 * 60 * 1000;

                        hours=  difference/(60*60*1000);
                        difference-=hours*60*60*1000;


                        minutes=  difference/(60*1000);
                        difference-=minutes*60*1000;


                        seconds=  difference/1000;

                        dayText.setText(" Gün \n   "+days);
                        hourText.setText("Saat \n   "+hours);
                        minuteText.setText("Dakika \n    "+minutes);
                        secondText.setText("Saniye \n    "+seconds);

                        dayText2.setText(" Gün \n   "+(days+1));
                        hourText2.setText("Saat \n   "+hours);
                        minuteText2.setText("Dakika \n    "+minutes);
                        secondText2.setText("Saniye \n    "+seconds);


                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }


            }
        };
        handler.postDelayed(runnable,1*1000);

    }

}
