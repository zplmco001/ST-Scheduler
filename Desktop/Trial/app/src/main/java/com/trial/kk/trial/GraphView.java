package com.trial.kk.trial;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

/**
 * Created by mehmetcanolgun on 21.03.2019.
 */

public class GraphView extends View {

    private Path path = new Path();
    private Paint paint = new Paint();
    List<Point> list;
    private Canvas canvas;

    public GraphView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        canvas.drawRect(50,590,1000,600,paint);
        canvas.drawRect(50,50,60,590,paint);

    }

    public void drawPoints(){
        for (Point p: list){
            canvas.drawPoint(p.x,p.y,paint);
        }
    }

}
