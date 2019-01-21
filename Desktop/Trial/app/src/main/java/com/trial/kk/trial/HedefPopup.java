package com.trial.kk.trial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class HedefPopup extends AppCompatActivity {

    private Spinner spinner;
    private String arr[] = new String[10];
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hedef_popup);

        spinner = (Spinner) findViewById(R.id.spinner);
        btn = (Button) findViewById(R.id.Ekle);

        arr[0]="Matematik";
        arr[1]="Fizik";
        arr[2]="Kimya";
        arr[3]="Biyoloji";
        arr[4]="Edebiyat";
        arr[5]="Tarih";
        arr[6]="Coğrafya";
        arr[7]="Felsefe";
        arr[8]="Din Kültürü";
        arr[9]="Yabancı Dil";

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,arr);
        spinner.setAdapter(adapter);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*.9),(int) (height*.6));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
