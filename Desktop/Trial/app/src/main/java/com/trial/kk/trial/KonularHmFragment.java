package com.trial.kk.trial;

import android.content.ClipData;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

/**
 * Created by kursat on 3.02.2019.
 */

public class KonularHmFragment extends Fragment {

    private int[] numTyt = {23,19,24,10,11,13,17,11,8,7};
    private int numsAyt [] = {31,15,27,17,18,24,29,6,22,11};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.konular_hm_fragment,container,false);

        final ToggleButton tb = view.findViewById(R.id.toggleButton);
        tb.setText("TYT");
        tb.setTextOff("TYT");
        tb.setTextOn("AYT");

        tb.callOnClick();

        final ProgressBar bars[] = {view.findViewById(R.id.ilerlemeMat),view.findViewById(R.id.ilerlemeTur),
                view.findViewById(R.id.ilerlemeGeo),view.findViewById(R.id.ilerlemeFiz),
                view.findViewById(R.id.ilerlemeKim),view.findViewById(R.id.ilerlemeBiy),
                view.findViewById(R.id.ilerlemeTar),view.findViewById(R.id.ilerlemeCog),
                view.findViewById(R.id.ilerlemeFel),view.findViewById(R.id.ilerlemeDin)};
        final TextView texts[] = {view.findViewById(R.id.ilerlemeMatText),view.findViewById(R.id.ilerlemeTurText),
                view.findViewById(R.id.ilerlemeGeoText),view.findViewById(R.id.ilerlemeFizText),
                view.findViewById(R.id.ilerlemeKimText),view.findViewById(R.id.ilerlemeBiyText),
                view.findViewById(R.id.ilerlemeTarText),view.findViewById(R.id.ilerlemeCogText),
                view.findViewById(R.id.ilerlemeFelText),view.findViewById(R.id.ilerlemeDinText)};
        final String ders[] = {"Matematik","Türkçe","Geometri","Fizik","Kimya","Biyoloji","Tarih",
                        "Coğrafya","Felsefe","Din Kültürü ve Ahlak Bilgisi"};

        DatabaseConnection db = new DatabaseConnection(getContext());
        db.open();
        final List<Integer> listState = db.getState();
        db.close();

        ders[1] = "Türkçe";

        int sub = 0;
        for (int i=0;i<numTyt.length;i++){
            int counter = 0;
            for (int j=0;j<numTyt[i];j++){
                if (listState.get(j+sub)==1){
                    counter++;
                }
            }
            float yuzde = ((float) counter/(float) numTyt[i])*100;
            ProgressBarAnimation anim = new ProgressBarAnimation(bars[i], 0, Math.round(yuzde));
            anim.setDuration(1000);
            bars[i].startAnimation(anim);
            texts[i].setText(ders[i]+"\n%"+Math.round(yuzde));
            sub += numTyt[i];
        }


        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (tb.isChecked()){
                    ders[1] = "Edebiyat";


                    int sub = 0;
                    for (int i=0;i<numsAyt.length;i++){
                        int counter = 0;
                        for (int j=0;j<numsAyt[i];j++){
                            if (listState.get(j+sub+143)==1){
                                counter++;
                            }
                        }
                        float yuzde = ((float) counter/(float) numsAyt[i])*100;
                        ProgressBarAnimation anim = new ProgressBarAnimation(bars[i], 0, Math.round(yuzde));
                        anim.setDuration(1000);
                        bars[i].startAnimation(anim);
                        //bars[i].setProgress((int)yuzde);
                        texts[i].setText(ders[i]+"\n%"+Math.round(yuzde));
                        sub += numsAyt[i];
                    }


                }else{

                    ders[1] = "Türkçe";

                    int sub = 0;
                    for (int i=0;i<numTyt.length;i++){
                        int counter = 0;
                        for (int j=0;j<numTyt[i];j++){
                            if (listState.get(j+sub)==1){
                                counter++;
                            }
                        }
                        float yuzde = ((float) counter/(float) numTyt[i])*100;
                        ProgressBarAnimation anim = new ProgressBarAnimation(bars[i], 0, Math.round(yuzde));
                        anim.setDuration(1000);
                        bars[i].startAnimation(anim);
                        //bars[i].setProgress((int)yuzde);
                        texts[i].setText(ders[i]+"\n%"+Math.round(yuzde));
                        sub += numTyt[i];
                    }

                }
            }
        });



        return view;
    }
    class ProgressBarAnimation extends Animation {
        private ProgressBar progressBar;
        private float from;
        private float  to;

        public ProgressBarAnimation(ProgressBar progressBar, float from, float to) {
            super();
            this.progressBar = progressBar;
            this.from = from;
            this.to = to;
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            float value = from + (to - from) * interpolatedTime;
            progressBar.setProgress((int) value);
        }

    }

}
