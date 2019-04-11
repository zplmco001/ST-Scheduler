package com.trial.kk.trial;

import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * Created by mehmetcanolgun on 17.01.2019.
 */

public class AnaSayfa extends Fragment implements SurfaceHolder.Callback{

    private TextView tv;
    private TextView ilerlemeText;
    private ProgressBar ilerleme;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.content_hmp,container,false);

        TextView textView = view.findViewById(R.id.anasayfapostit);

        tv = view.findViewById(R.id.name);

        final ArrayList <Point> points = new ArrayList<>();

        Point point = new Point(1,400);
        Point point2 = new Point(2,370);
        Point point1 = new Point(3,100);
        Point point5 = new Point(0,0);

        points.add(point);
        points.add(point2);
        points.add(point1);
        points.add(point5);

        final GraphView graph = view.findViewById(R.id.graph);



        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                int width = graph.getWidth();
                int height = graph.getHeight();
                graph.setSize(width, height);
                graph.setPoints(points);
            }
        });




        ilerlemeText = view.findViewById(R.id.ilerlemeText);
        ilerleme = view.findViewById(R.id.ilerleme);



        Log.e("",String.valueOf(Calendar.MONDAY));
        Log.e("",""+Calendar.TUESDAY);
        Log.e("",""+Calendar.WEDNESDAY);
        Log.e("",""+Calendar.THURSDAY);
        Log.e("",""+Calendar.FRIDAY);
        Log.e("",""+Calendar.SATURDAY);
        Log.e("",""+Calendar.SUNDAY);

        DatabaseConnection db = new DatabaseConnection(getContext());
        db.open();
        List<Integer> listState = db.getState();
        List<NewPostit> list = db.hedefAl();
        db.close();

        int counter = 0;
        for (int i=0;i<listState.size();i++){
            if (listState.get(i) == 1){
                counter++;
                Log.e("counter",""+counter);
            }
        }



        float yuzde = ((float) counter/(float) listState.size())*100;

        Log.e("yuzde",""+yuzde);
        Log.e("size",listState.size()+"");

        ilerlemeText.setText("Genel İlerleme\n%"+Math.round(yuzde));

        ProgressBarAnimation anim = new ProgressBarAnimation(ilerleme, 0, Math.round(yuzde));
        anim.setDuration(1000);
        ilerleme.startAnimation(anim);


        int sure=0, soru=0;

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        for (int i=0;i<list.size();i++){
            if ((day-2)%7==list.get(i).gun){
                sure += list.get(i).sure;
                soru += list.get(i).soru;
            }
        }

        String daytext="";

        switch (day) {
            case Calendar.SUNDAY:
                daytext = "Pazar";
                break;
            case Calendar.MONDAY:
                daytext = "Pazartesi";
                break;
            case Calendar.TUESDAY:
                daytext = "Salı";
                break;
            case Calendar.WEDNESDAY:
                daytext = "Çarşamba";
                break;
            case Calendar.THURSDAY:
                daytext = "Perşembe";
                break;
            case Calendar.FRIDAY:
                daytext = "Cuma";
                break;
            case Calendar.SATURDAY:
                daytext = "Cumartesi";
                break;

        }
        textView.setText(daytext+"\n"+soru+" soru\n"+sure+" dk");
        textView.setTextSize(30);
        textView.setTextColor(Color.BLACK);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Typeface tp = Typeface.createFromAsset(getContext().getAssets(), "Architext.ttf");
        textView.setTypeface(tp);


        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String name = preferences.getString("example_text","");
        tv.setText(name);

        Log.e("name1",name);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public void cnsDraw(SurfaceHolder holder){
        Canvas canvas = holder.lockCanvas();
        if (canvas == null) {
            Log.e("sfads", "Cannot draw onto the canvas as it's null");
        } else {
            drawMyStuff(canvas);
            holder.unlockCanvasAndPost(canvas);
        }
    }

    private void drawMyStuff(final Canvas canvas) {
        Random random = new Random();
        Log.i("afs", "Drawing...");
        canvas.drawRGB(255, 128, 128);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        cnsDraw(surfaceHolder);
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        cnsDraw(surfaceHolder);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

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
