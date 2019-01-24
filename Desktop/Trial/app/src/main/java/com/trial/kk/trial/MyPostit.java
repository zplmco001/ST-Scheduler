package com.trial.kk.trial;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.jar.Attributes;

/**
 * Created by mehmetcanolgun on 21.01.2019.
 */

public class MyPostit {


   /* public MyPostit(Context context, AttributeSet attributes) {
        super(context,attributes);

        GridLayout gl = new GridLayout(context);
        gl.setColumnCount(5);
        gl.setRowCount(2);

    }*/

    private TextView tv;

    public MyPostit(GridLayout gl, String text, Context context){

        tv = new TextView(context);
        tv.setText(text);
        //tv.setBackground(Drawable.createFromPath("drawable/note147951_1280"));
        gl.addView(tv);

    }

    public TextView getTv(){
        return tv;
    }

}
