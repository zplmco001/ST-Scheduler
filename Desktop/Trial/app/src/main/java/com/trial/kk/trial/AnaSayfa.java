package com.trial.kk.trial;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

/**
 * Created by mehmetcanolgun on 17.01.2019.
 */

public class AnaSayfa extends Fragment {

    TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_hmp,container,false);

        TextView textView = view.findViewById(R.id.anasayfapostit);

        tv = view.findViewById(R.id.name);






        Log.e("",String.valueOf(Calendar.MONDAY));
        Log.e("",""+Calendar.TUESDAY);
        Log.e("",""+Calendar.WEDNESDAY);
        Log.e("",""+Calendar.THURSDAY);
        Log.e("",""+Calendar.FRIDAY);
        Log.e("",""+Calendar.SATURDAY);
        Log.e("",""+Calendar.SUNDAY);

        DatabaseConnection db = new DatabaseConnection(getContext());
        db.open();
        List<NewPostit> list = db.hedefAl();
        db.close();

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
        String name = preferences.getString("example_text","def");
        tv.setText(name);

        Log.e("name1",name);
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
