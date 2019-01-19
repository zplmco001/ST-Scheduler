package com.trial.kk.trial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PopResult extends AppCompatActivity {

    private EditText tythampuan,tytyerpuan,mfhampuan,mfyerpuan,tmhampuan,tmyerpuan;
    private EditText tshampuan,tsyerpuan,dilhampuan,dilyerpuan;
    private Button kaydet,geridön;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_result);

        tythampuan = (EditText) findViewById(R.id.tythampuan);
        tytyerpuan = (EditText) findViewById(R.id.tytyerpuan);
        mfhampuan = (EditText) findViewById(R.id.mfhampuan);
        mfyerpuan = (EditText) findViewById(R.id.mfyerpuan);
        tmhampuan = (EditText) findViewById(R.id.tmhampuan);
        tmyerpuan = (EditText) findViewById(R.id.tmyerpuan);
        tshampuan = (EditText) findViewById(R.id.tshampuan);
        tsyerpuan = (EditText) findViewById(R.id.tsyerpuan);
        dilhampuan = (EditText) findViewById(R.id.dilhampuan);
        dilyerpuan = (EditText) findViewById(R.id.dilyerpuan);

        kaydet = (Button) findViewById(R.id.button3);
        geridön = (Button) findViewById(R.id.button4);



        Intent incoming = getIntent();

        tythampuan.setText("TYT HAM PUAN : "+incoming.getStringExtra("tythampuan"));
        tytyerpuan.setText("TYT YERLEŞTİRME PUANI : "+incoming.getStringExtra("tytyerpuan"));
        mfhampuan.setText("MF HAM PUAN : "+incoming.getStringExtra("mfhampuan"));
        mfyerpuan.setText("MF YERLEŞTİRME PUANI : "+incoming.getStringExtra("mfyerpuan"));
        tmhampuan.setText("TM HAM PUAN : "+incoming.getStringExtra("tmhampuan"));
        tmyerpuan.setText("TM YERLEŞTİRME PUANI : "+incoming.getStringExtra("tmyerpuan"));
        tshampuan.setText("TS HAM PUAN : "+incoming.getStringExtra("tshampuan"));
        tsyerpuan.setText("TS YERLEŞTİRME PUANI : "+incoming.getStringExtra("tsyerpuan"));
        dilhampuan.setText("DİL HAM PUAN : "+incoming.getStringExtra("dilhampuan"));
        dilyerpuan.setText("DİL YERLEŞTİRME PUANI : "+incoming.getStringExtra("dilyerpuan"));


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*1),(int)(height*1));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x=0;
        params.y=-20;

        getWindow().setAttributes(params);

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Sonuçlar kaydedildi.",Toast.LENGTH_LONG).show();
            }
        });

        geridön.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
