package com.trial.kk.trial;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
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
import android.widget.Toast;

public class HedefPopup extends AppCompatActivity {

    private Spinner spinner, spinner2;
    private String arr[] = new String[11];
    private Button btn;
    private EditText soru, dk;
    private Hedefler hedefler = new Hedefler();
    private int day;
    String gun[] = {"Pazartesi","Salı","Çarşamba","Perşembe","Cuma","Cumartesi","Pazar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hedef_popup);

        spinner = (Spinner) findViewById(R.id.spinner);

        btn = (Button) findViewById(R.id.Ekle);
        soru = (EditText) findViewById(R.id.editText2);
        dk = (EditText) findViewById(R.id.editText);

        day = getIntent().getIntExtra("day",0);

        Log.e("Gün",String.valueOf(day));

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
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        spinner.setAdapter(adapter);
        

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*.9),(int) (height*.6));



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = Hedefler.bund;

                if (spinner.getSelectedItemPosition()==0){

                    AlertDialog.Builder builder = new AlertDialog.Builder(HedefPopup.this);
                    builder.setMessage("Lütfen ders seçiniz");
                    builder.show();
                    return;
                }
                if (soru.getText().toString().equals("")){

                    bundle.putString("Text1",spinner.getSelectedItem()+"\n"+dk.getText()+" dk");

                }
                else if (dk.getText().toString().equals("")){

                    bundle.putString("Text1",spinner.getSelectedItem()+"\n"+soru.getText()+" soru");
                }
                else{
                    bundle.putString("Text1", spinner.getSelectedItem()+"\n"+soru.getText()+" dk");
                    bundle.putString("Text2",spinner.getSelectedItem()+"\n"+dk.getText()+" soru");

                }
                bundle.putInt("Integer",day);
                hedefler.setArguments(bundle);

                finish();



            }
        });

    }

}
