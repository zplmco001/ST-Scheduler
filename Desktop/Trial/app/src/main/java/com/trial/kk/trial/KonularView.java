package com.trial.kk.trial;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mehmetcanolgun on 8.02.2019.
 */

public class KonularView {

    private Button dersBtn;
    private ArrayList<CheckBox> checkArray = new ArrayList<>();
    private LinearLayout general, konu;

    KonularView(Context context, String ders, List<String> konular){

        dersBtn = new Button(context);
        dersBtn.setText(ders);

        general = new LinearLayout(context);
        general.setOrientation(LinearLayout.VERTICAL);
        general.addView(dersBtn);

        this.konu = new LinearLayout(context);
        konu.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(430, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_HORIZONTAL;

        for (int i=0;i<konular.size();i++){
            CheckBox checkBox = new CheckBox(context);
            //checkBox.setWidth(430);
            checkBox.setText(konular.get(i));
            checkBox.setLayoutParams(params);
            checkArray.add(checkBox);
            this.konu.addView(checkBox);
        }

        general.addView(konu);

        dersBtn.setOnClickListener(new butonListener(konu));

    }

    LinearLayout getLinearLayout(){
        return general;
    }

    ArrayList<CheckBox> getChecboxes(){
        return checkArray;
    }

    class butonListener implements View.OnClickListener{

        private LinearLayout ln;
        @Override
        public void onClick(View view) {

            if (ln.getVisibility() == View.INVISIBLE){
                ln.setVisibility(View.VISIBLE);
                ViewGroup.LayoutParams params = ln.getLayoutParams();
                params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                ln.setLayoutParams(params);
            }else{
                ln.setVisibility(View.INVISIBLE);
                ViewGroup.LayoutParams params = ln.getLayoutParams();
                params.height = 0;
                ln.setLayoutParams(params);

            }

        }

        butonListener(LinearLayout linearLayout){
            this.ln = linearLayout;
            ln.setVisibility(View.INVISIBLE);
            ViewGroup.LayoutParams params = ln.getLayoutParams();
            params.height = 0;
            ln.setLayoutParams(params);
        }
    }
}
