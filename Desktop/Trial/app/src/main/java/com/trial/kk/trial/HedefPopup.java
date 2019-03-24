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

    private Spinner spinner;
    private String arr[] = new String[13];
    private Button btn;
    private EditText soru, dk;
    private Hedefler hedefler = new Hedefler();
    private int day;

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
        arr[1]="Deneme";
        arr[2]="Matematik";
        arr[3]="Fizik";
        arr[4]="Kimya";
        arr[5]="Biyoloji";
        arr[6]="Türkçe";
        arr[7]="Edebiyat";
        arr[8]="Tarih";
        arr[9]="Coğrafya";
        arr[10]="Felsefe";
        arr[11]="Din Kültürü";
        arr[12]="Yabancı Dil";

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
                if (soru.getText().toString().equals("")&&dk.getText().toString().equals("")){

                    AlertDialog.Builder builder = new AlertDialog.Builder(HedefPopup.this);
                    builder.setMessage("Lütfen soru sayısı veya çalışma süresi giriniz");
                    builder.show();
                    return;
                }
                if (soru.getText().toString().equals("")){

                    bundle.putInt("Dk",Integer.parseInt(dk.getText().toString()));
                    bundle.putInt("Soru",0);

                }
                else if (dk.getText().toString().equals("")){

                    bundle.putInt("Dk",0);
                    bundle.putInt("Soru",Integer.parseInt(soru.getText().toString()));

                }
                else{

                    bundle.putInt("Dk",Integer.parseInt(dk.getText().toString()));
                    bundle.putInt("Soru",Integer.parseInt(soru.getText().toString()));
                }

                bundle.putString("Ders",spinner.getSelectedItem().toString());
                bundle.putInt("Integer",day);
                bundle.putInt("Index",spinner.getSelectedItemPosition());
                hedefler.setArguments(bundle);


                finish();

            }
        });

    }

}
