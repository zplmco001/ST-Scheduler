package com.trial.kk.trial;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class HedefPopup extends AppCompatActivity {

    private Spinner spinner, spinner2;
    private String arr[] = new String[11];
    private Button btn;
    private String gunler[] = {"Gün Seçiniz","Pazartesi","Salı","Çarşamba","Perşembe","Cuma","Cumartesi","Pazar"};
    private EditText soru, dk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hedef_popup);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        btn = (Button) findViewById(R.id.Ekle);
        soru = (EditText) findViewById(R.id.editText2);
        dk = (EditText) findViewById(R.id.editText);

        arr[0]="Ders Seçiniz";
        arr[1]="Matematik";
        arr[2]="Fizik";
        arr[3]="Kimya";
        arr[4]="Biyoloji";
        arr[5]="Edebiyat";
        arr[6]="Tarih";
        arr[7]="Coğrafya";
        arr[8]="Felsefe";
        arr[9]="Din Kültürü";
        arr[10]="Yabancı Dil";

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arr){

            @Override
            public boolean isEnabled(int position) {
                if (position==0)
                    return false;
                else
                    return true;
            }


            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        spinner.setAdapter(adapter);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,gunler){
            @Override
            public boolean isEnabled(int position) {
                if (position==0)
                    return false;
                else
                    return true;
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        spinner2.setAdapter(adapter1);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*.9),(int) (height*.6));



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // Intent i = new Intent(HedefPopup.this, Hmp.class);
               // startActivity(i);
               /* Hedefler hedefler = new Hedefler();
                GridLayout gl = hedefler.getLayout();
                Log.e("mgs",String.valueOf(gl.getRowCount()));
                MyPostit postit = new MyPostit(gl,((String) spinner.getSelectedItem())+soru.getText()+dk.getText(),getBaseContext());*/
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Hedefler());
                //finish();



            }
        });

    }

}
