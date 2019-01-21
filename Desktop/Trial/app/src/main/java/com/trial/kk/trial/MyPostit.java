package com.trial.kk.trial;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.jar.Attributes;

/**
 * Created by mehmetcanolgun on 21.01.2019.
 */

public class MyPostit extends View {


    public MyPostit(Context context, AttributeSet attributes) {
        super(context,attributes);

        GridLayout gl = new GridLayout(context);
        gl.setColumnCount(5);
        gl.setRowCount(2);

    }




}
