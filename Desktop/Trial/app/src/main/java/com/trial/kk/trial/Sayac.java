package com.trial.kk.trial;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import static com.trial.kk.trial.Hmp.kontrol;


/**
 * Created by mehmetcanolgun on 16.01.2019.
 */

public class Sayac extends Fragment{

    private EditText hourEdit;
    private EditText minuteEdit;
    private EditText secondEdit;
    private TextView space1;
    private TextView space2;
    private Button start;
    private Button stop;
    private Button reset;
    private String hour,minute,second;
    private CountDownTimer countDownTimer;
    private long totalTime,total,h,m,s;
    private ProgressBar progressBar;
    private int progress = 0,check=0;
    private Resources res;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sayac_layout, container, false);

        hourEdit=(EditText) view.findViewById(R.id.hourEdit);
        minuteEdit=(EditText) view.findViewById(R.id.minuteEdit);
        secondEdit=(EditText) view.findViewById(R.id.secondEdit);

        space1=(TextView) view.findViewById(R.id.space1);
        space2=(TextView) view.findViewById(R.id.space2);

        start =(Button) view.findViewById(R.id.start);
        stop=(Button) view.findViewById(R.id.stop);
        reset=(Button) view.findViewById(R.id.reset);

        progressBar = view.findViewById(R.id.progressBar);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check=1;
                start.setEnabled(false);

                hourEdit.setEnabled(false);
                minuteEdit.setEnabled(false);
                secondEdit.setEnabled(false);
                hour = hourEdit.getText().toString();
                minute = minuteEdit.getText().toString();
                second = secondEdit.getText().toString();
                totalTime = (Integer.parseInt(hour)*60*60*1000)+(Integer.parseInt(minute)*60*1000)+(Integer.parseInt(second)*1000) ;
                total=totalTime;
                progressBar.setMax((int) totalTime);
                countDownTimer=new CountDownTimer(totalTime, 1000) {
                    @Override
                    public void onTick(long totalTime) {
                        kontrol=0;
                        progressBar.setProgress(progress);
                        h=totalTime/(60*60*1000);
                        totalTime-=h*60*60*1000;
                        if(h<10){
                            hourEdit.setText("0"+String.valueOf(h));
                        }else{
                            hourEdit.setText(String.valueOf(h));
                        }

                        m=totalTime/(60*1000);
                        totalTime-=m*60*1000;
                        if(m<10){
                            minuteEdit.setText("0"+String.valueOf(m));
                        }else{
                            minuteEdit.setText(String.valueOf(m));
                        }


                        s=totalTime/1000;
                        if(s<10){
                            secondEdit.setText("0"+String.valueOf(s));
                        }else{
                            secondEdit.setText(String.valueOf(s));
                        }
                        progress += 1000;

                    }

                    @Override
                    public void onFinish() {
                        secondEdit.setText("00");
                        progressBar.setProgress(0);
                        kontrol=1;
                        hourEdit.setEnabled(true);
                        minuteEdit.setEnabled(true);
                        secondEdit.setEnabled(true);
                        progress = 0;
                        start.setEnabled(true);
                        Hmp.alert(getContext());

                    }
                }.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check==1){
                    countDownTimer.cancel();
                    start.setEnabled(true);
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check==1){
                    countDownTimer.cancel();
                    hourEdit.setText("00");
                    minuteEdit.setText("00");
                    secondEdit.setText("00");
                    hourEdit.setEnabled(true);
                    minuteEdit.setEnabled(true);
                    secondEdit.setEnabled(true);
                    start.setEnabled(true);
                    progressBar.setProgress(0);
                }
            }
        });
        //start.setOnClickListener(new butonStart());
        //stop.setOnClickListener(new butonStop());
        //reset.setOnClickListener(new butonReset());





        return view;
    }





   /* class butonStart implements View.OnClickListener{

        int h1,m1,s1;

        @Override
        public void onClick(View view) {

        }
    }*/


   /* class butonStop implements View.OnClickListener{



        @Override
        public void onClick(View view) {


        }
    }

    class butonReset implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(check==1){
                countDownTimer.cancel();
                hourEdit.setText("00");
                minuteEdit.setText("00");
                secondEdit.setText("00");
                hourEdit.setEnabled(true);
                minuteEdit.setEnabled(true);
                secondEdit.setEnabled(true);
                start.setEnabled(true);
                progressBar.setProgress(0);
            }

        }
    }*/
}
