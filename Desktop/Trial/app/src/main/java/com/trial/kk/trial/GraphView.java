package com.trial.kk.trial;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
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
    private int width, height;

    public GraphView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        Log.e("canvas",canvas+"");

        canvas.drawRect(width/20,height*6/7,width*19/20,height*6/7+10,paint);
        canvas.drawRect(width/20,height/20,width/20+10,height*6/7,paint);

        drawPoints(canvas);

    }

    public void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void setPoints(List<Point> list){
        this.list = list;
        Log.e("inside",""+this.list.size());
    }

    public void drawPoints(Canvas canvas){

        int r1 = width*19/20;
        int r2 = width/20+10;
        int t1 = height*6/7;
        int t2 = height/20;

       // Log.e("inside",""+this.list.size());

        int wRange = r1-r2;
        int hRAnge = t1-t2;

        Log.e("RAnge",""+hRAnge);

        int x = r2;
        int y = t1;

        if (hRAnge>0){
            for (int i=0;i<this.list.size();i++){
                canvas.drawCircle(wRange*(i+1)/list.size()+r2,t1-hRAnge*list.get(i).y/500,10,paint);
                canvas.drawLine(x,y,wRange*(i+1)/list.size()+r2,t1-hRAnge*list.get(i).y/500,paint);
                x = wRange*(i+1)/list.size()+r2;
                y = t1-hRAnge*list.get(i).y/500;
            }
        }



    }

}
