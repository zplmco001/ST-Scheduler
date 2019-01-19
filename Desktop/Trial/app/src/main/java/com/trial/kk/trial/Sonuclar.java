package com.trial.kk.trial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Sonuclar extends Fragment {

    private EditText yksFizikDogru,dipNot,türkDogru,türkYanlıs;
    private EditText matDogru,matYanlıs,sosDogru,sosYanlıs,fenDogru;
    private EditText yksMatDogru,yksMatYanlıs,yksFizikYanlıs,fenYanlıs;
    private EditText yksEdbDogru,yksEdbYanlıs,yksTarih1Dogru,yksTarih1Yanlıs;
    private EditText yksCogDogru,yksBioDogru,yksKimyaDogru,yksKimyaYanlıs;
    private EditText yksBioYanlıs,yksTarih2Dogru,yksCog2Dogru,yksFelsDogru;
    private EditText yksDinDogru,yksDilDogru,yksCogYanlıs,yksTarih2Yanlıs;
    private EditText yksCog2Yanlıs,yksFelsYanlıs,yksDinYanlıs,yksDilYanlıs;

    private Button hesapla,temizle,kaydet;

    private double trNet,sosNet,matNet,fenNet,dipPuan;
    private double yksMatNet,yksFizNet,yksKimNet,yksBioNet;
    private double yksEdbNet,yksTrh1Net,yksCogNet,yksTrh2Net,yksCog2Net;
    private double yksFelNet,yksDinNet,yksDilNet;
    private double tytHamPuan,tytYerPuan,mfHamPuan,mfYerPuan,tmHamPuan,tmYerPuan;
    private double tsHamPuan,tsYerPuan,dilHamPuan,dilYerPuan,tyt2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.sonuclar_layout, container, false);

        dipNot = (EditText) view.findViewById(R.id.dipNot);
        türkDogru = (EditText) view.findViewById(R.id.türkDogru);
        türkYanlıs = (EditText) view.findViewById(R.id.türkYanlıs);
        sosDogru = (EditText) view.findViewById(R.id.sosDogru);
        sosYanlıs = (EditText) view.findViewById(R.id.sosYanlıs);
        matDogru = (EditText) view.findViewById(R.id.matDogru);
        matYanlıs = (EditText) view.findViewById(R.id.matYanlıs);
        fenDogru = (EditText) view.findViewById(R.id.fenDogru);
        fenYanlıs = (EditText) view.findViewById(R.id.fenYanlıs);

        yksMatDogru = (EditText) view.findViewById(R.id.yksMatDogru);
        yksMatYanlıs = (EditText) view.findViewById(R.id.yksMatYanlıs);
        yksFizikDogru = (EditText) view.findViewById(R.id.yksFizikDogru);
        yksFizikYanlıs = (EditText) view.findViewById(R.id.yksFizikYanlıs);
        yksKimyaDogru = (EditText) view.findViewById(R.id.yksKimyaDogru);
        yksKimyaYanlıs = (EditText) view.findViewById(R.id.yksKimyaYanlıs);
        yksBioDogru = (EditText) view.findViewById(R.id.yksBioDogru);
        yksBioYanlıs = (EditText) view.findViewById(R.id.yksBioYanlıs);

        yksEdbDogru = (EditText) view.findViewById(R.id.yksEdbDogru);
        yksEdbYanlıs = (EditText) view.findViewById(R.id.yksEdbYanlıs);
        yksTarih1Dogru = (EditText) view.findViewById(R.id.yksTarih1Dogru);
        yksTarih1Yanlıs = (EditText) view.findViewById(R.id.yksTarih1Yanlıs);
        yksCogDogru = (EditText) view.findViewById(R.id.yksCogDogru);
        yksCogYanlıs = (EditText) view.findViewById(R.id.yksCogYanlıs);

        yksTarih2Dogru = (EditText) view.findViewById(R.id.yksTarih2Dogru);
        yksTarih2Yanlıs = (EditText) view.findViewById(R.id.yksTarih2Yanlıs);
        yksCog2Dogru = (EditText) view.findViewById(R.id.yksCog2Dogru);
        yksCog2Yanlıs = (EditText) view.findViewById(R.id.yksCog2Yanlıs);
        yksFelsDogru = (EditText) view.findViewById(R.id.yksFelsDogru);
        yksFelsYanlıs = (EditText) view.findViewById(R.id.yksFelsYanlıs);
        yksDilDogru = (EditText) view.findViewById(R.id.yksDilDogru);
        yksDilYanlıs = (EditText) view.findViewById(R.id.yksDilYanlıs);
        yksDinDogru = (EditText) view.findViewById(R.id.yksDinDogru);
        yksDinYanlıs = (EditText) view.findViewById(R.id.yksDinYanlıs);

        hesapla = (Button) view.findViewById(R.id.hesapla);
        temizle = (Button) view.findViewById(R.id.temizle);
        kaydet = (Button) view.findViewById(R.id.kaydet);


        dipNot.setFilters(new InputFilter[]{new MinMaxFilter("0","100")});
        türkDogru.setFilters(new InputFilter[]{new MinMaxFilter("0","40")});
        türkYanlıs.setFilters(new InputFilter[]{new MinMaxFilter("0","40")});
        sosDogru.setFilters(new InputFilter[]{new MinMaxFilter("0","20")});
        sosYanlıs.setFilters(new InputFilter[]{new MinMaxFilter("0","20")});
        matDogru.setFilters(new InputFilter[]{new MinMaxFilter("0","40")});
        matYanlıs.setFilters(new InputFilter[]{new MinMaxFilter("0","40")});
        fenDogru.setFilters(new InputFilter[]{new MinMaxFilter("0","20")});
        fenYanlıs.setFilters(new InputFilter[]{new MinMaxFilter("0","20")});

        yksMatDogru.setFilters(new InputFilter[]{new MinMaxFilter("0","40")});
        yksMatYanlıs.setFilters(new InputFilter[]{new MinMaxFilter("0","40")});
        yksFizikDogru.setFilters(new InputFilter[]{new MinMaxFilter("0","14")});
        yksFizikYanlıs.setFilters(new InputFilter[]{new MinMaxFilter("0","14")});
        yksKimyaDogru.setFilters(new InputFilter[]{new MinMaxFilter("0","13")});
        yksKimyaYanlıs.setFilters(new InputFilter[]{new MinMaxFilter("0","13")});
        yksBioDogru.setFilters(new InputFilter[]{new MinMaxFilter("0","13")});
        yksBioYanlıs.setFilters(new InputFilter[]{new MinMaxFilter("0","13")});

        yksEdbDogru.setFilters(new InputFilter[]{new MinMaxFilter("0","24")});
        yksEdbYanlıs.setFilters(new InputFilter[]{new MinMaxFilter("0","24")});
        yksTarih1Dogru.setFilters(new InputFilter[]{new MinMaxFilter("0","10")});
        yksTarih1Yanlıs.setFilters(new InputFilter[]{new MinMaxFilter("0","10")});
        yksCogDogru.setFilters(new InputFilter[]{new MinMaxFilter("0","6")});
        yksCogYanlıs.setFilters(new InputFilter[]{new MinMaxFilter("0","6")});
        yksTarih2Dogru.setFilters(new InputFilter[]{new MinMaxFilter("0","11")});
        yksTarih2Yanlıs.setFilters(new InputFilter[]{new MinMaxFilter("0","11")});
        yksCog2Dogru.setFilters(new InputFilter[]{new MinMaxFilter("0","11")});
        yksCog2Yanlıs.setFilters(new InputFilter[]{new MinMaxFilter("0","11")});

        yksFelsDogru.setFilters(new InputFilter[]{new MinMaxFilter("0","12")});
        yksFelsYanlıs.setFilters(new InputFilter[]{new MinMaxFilter("0","12")});
        yksDinDogru.setFilters(new InputFilter[]{new MinMaxFilter("0","6")});
        yksDinYanlıs.setFilters(new InputFilter[]{new MinMaxFilter("0","6")});
        yksDilDogru.setFilters(new InputFilter[]{new MinMaxFilter("0","80")});
        yksDilYanlıs.setFilters(new InputFilter[]{new MinMaxFilter("0","80")});





        hesapla.setOnClickListener(new hesapla());
        temizle.setOnClickListener(new temizle());
        kaydet.setOnClickListener(new kaydet());

        return view;
    }

    //editText sa

    class hesapla implements View.OnClickListener{

        @Override
        public void onClick(View view) {

            isItNull(dipNot);
            isItNull(türkDogru);
            isItNull(türkYanlıs);
            isItNull(sosDogru);
            isItNull(sosYanlıs);
            isItNull(matDogru);
            isItNull(matYanlıs);
            isItNull(fenDogru);
            isItNull(fenYanlıs);
            isItNull(yksMatDogru);
            isItNull(yksMatYanlıs);
            isItNull(yksFizikDogru);
            isItNull(yksFizikYanlıs);
            isItNull(yksKimyaDogru);
            isItNull(yksKimyaYanlıs);
            isItNull(yksBioDogru);
            isItNull(yksBioYanlıs);
            isItNull(yksEdbDogru);
            isItNull(yksEdbYanlıs);
            isItNull(yksTarih1Dogru);
            isItNull(yksTarih1Yanlıs);
            isItNull(yksCogDogru);
            isItNull(yksCogYanlıs);
            isItNull(yksTarih2Dogru);
            isItNull(yksTarih2Yanlıs);
            isItNull(yksCog2Dogru);
            isItNull(yksCog2Yanlıs);
            isItNull(yksFelsDogru);
            isItNull(yksFelsYanlıs);
            isItNull(yksDilDogru);
            isItNull(yksDilYanlıs);
            isItNull(yksDinDogru);
            isItNull(yksDinYanlıs);


            dipPuan = Integer.parseInt(dipNot.getText().toString())*0.6;
            trNet = (Integer.parseInt(türkDogru.getText().toString()))-((Integer.parseInt(türkYanlıs.getText().toString()))*0.25);
            sosNet = (Integer.parseInt(sosDogru.getText().toString()))-((Integer.parseInt(sosYanlıs.getText().toString()))*0.25);
            matNet = (Integer.parseInt(matDogru.getText().toString()))-((Integer.parseInt(matYanlıs.getText().toString()))*0.25);
            fenNet = (Integer.parseInt(fenDogru.getText().toString()))-((Integer.parseInt(fenYanlıs.getText().toString()))*0.25);

            yksMatNet = (Integer.parseInt(yksMatDogru.getText().toString()))-((Integer.parseInt(yksMatYanlıs.getText().toString()))*0.25);
            yksFizNet = (Integer.parseInt(yksFizikDogru.getText().toString()))-((Integer.parseInt(yksFizikYanlıs.getText().toString()))*0.25);
            yksKimNet = (Integer.parseInt(yksKimyaDogru.getText().toString()))-((Integer.parseInt(yksKimyaYanlıs.getText().toString()))*0.25);
            yksBioNet = (Integer.parseInt(yksBioDogru.getText().toString()))-((Integer.parseInt(yksBioYanlıs.getText().toString()))*0.25);

            yksEdbNet = (Integer.parseInt(yksEdbDogru.getText().toString()))-((Integer.parseInt(yksEdbYanlıs.getText().toString()))*0.25);
            yksTrh1Net = (Integer.parseInt(yksTarih1Dogru.getText().toString()))-((Integer.parseInt(yksTarih1Yanlıs.getText().toString()))*0.25);
            yksCogNet = (Integer.parseInt(yksCogDogru.getText().toString()))-((Integer.parseInt(yksCogYanlıs.getText().toString()))*0.25);
            yksTrh2Net = (Integer.parseInt(yksTarih2Dogru.getText().toString()))-((Integer.parseInt(yksTarih2Yanlıs.getText().toString()))*0.25);

            yksCog2Net = (Integer.parseInt(yksCog2Dogru.getText().toString()))-((Integer.parseInt(yksCog2Yanlıs.getText().toString()))*0.25);
            yksFelNet = (Integer.parseInt(yksFelsDogru.getText().toString()))-((Integer.parseInt(yksFelsYanlıs.getText().toString()))*0.25);
            yksDilNet = (Integer.parseInt(yksDilDogru.getText().toString()))-((Integer.parseInt(yksDilYanlıs.getText().toString()))*0.25);
            yksDinNet = (Integer.parseInt(yksDinDogru.getText().toString()))-((Integer.parseInt(yksDinYanlıs.getText().toString()))*0.25);


            tytHamPuan = (trNet*3.3)+(matNet*3.3)+(sosNet*3.4)+(fenNet*3.3)+102;
            tytYerPuan = tytHamPuan+dipPuan;

            tyt2 = (trNet*1.32)+(matNet*1.32)+(sosNet*1.36)+(fenNet*1.36)+100;

            mfHamPuan = (yksMatNet*3)+(yksFizNet*2.85)+(yksKimNet*3.07)+(yksBioNet*3.07)+tyt2;
            tmHamPuan = (yksMatNet*3)+(yksEdbNet*3)+(yksTrh1Net*2.8)+(yksCogNet*3.33)+tyt2;
            tsHamPuan = (yksEdbNet*3)+(yksTrh1Net*2.8)+(yksCogNet*3.33)+(yksTrh2Net*2.91)+(yksCog2Net*2.91)+(yksFelNet*3)+(yksDinNet*3.33)+tyt2;
            dilHamPuan = (yksDilNet*3)+tyt2;

            mfYerPuan = mfHamPuan+dipPuan;
            tmYerPuan = tmHamPuan+dipPuan;
            tsYerPuan = tsHamPuan+dipPuan;
            dilYerPuan = dilHamPuan+dipPuan;

            System.out.println("Tyt ham puan: "+tytHamPuan+"\nTyt yer puan: "+tytYerPuan+"\nMf ham puan: "+mfHamPuan+"\nMf yer puan: "+mfYerPuan+
            "\nTm ham puan: "+tmHamPuan+"\nTm yer puan: "+tmYerPuan+"\nTs ham puan: "+tsHamPuan+"\nTs yer puan: "+tsYerPuan+"\nDil ham puan: "+dilHamPuan+"\nDil yer puan: "
            +dilYerPuan);


        }

    }


    class kaydet implements View.OnClickListener{

        @Override
        public void onClick(View view) {

        }
    }
    class temizle implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            clearText(dipNot);
            clearText(türkDogru);
            clearText(türkYanlıs);
            clearText(sosDogru);
            clearText(sosYanlıs);
            clearText(matDogru);
            clearText(matYanlıs);
            clearText(fenDogru);
            clearText(fenYanlıs);
            clearText(yksMatDogru);
            clearText(yksMatYanlıs);
            clearText(yksFizikDogru);
            clearText(yksFizikYanlıs);
            clearText(yksKimyaDogru);
            clearText(yksKimyaYanlıs);
            clearText(yksBioDogru);
            clearText(yksBioYanlıs);
            clearText(yksEdbDogru);
            clearText(yksEdbYanlıs);
            clearText(yksTarih1Dogru);
            clearText(yksTarih1Yanlıs);
            clearText(yksCogDogru);
            clearText(yksCogYanlıs);
            clearText(yksTarih2Dogru);
            clearText(yksTarih2Yanlıs);
            clearText(yksCog2Dogru);
            clearText(yksCog2Yanlıs);
            clearText(yksFelsDogru);
            clearText(yksFelsYanlıs);
            clearText(yksDilDogru);
            clearText(yksDilYanlıs);
            clearText(yksDinDogru);
            clearText(yksDinYanlıs);

        }
    }

    class MinMaxFilter  implements InputFilter {

        private int mIntMin, mIntMax;

        public MinMaxFilter(int minValue, int maxValue) {
            this.mIntMin = minValue;
            this.mIntMax = maxValue;
        }

        public MinMaxFilter(String minValue, String maxValue) {
            this.mIntMin = Integer.parseInt(minValue);
            this.mIntMax = Integer.parseInt(maxValue);
        }

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            try {
                int input = Integer.parseInt(dest.toString() + source.toString());
                if (isInRange(mIntMin, mIntMax, input))
                    return null;
            } catch (NumberFormatException nfe) { }
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Hatalı Değer");
            builder.setMessage("Lütfen ("+mIntMin+"-"+mIntMax+") aralığında değer giriniz!");
            builder.show();
            return "";
        }

        private boolean isInRange(int a, int b, int c) {
            return b > a ? c >= a && c <= b : c >= b && c <= a;
        }
    }

    public void isItNull(EditText editText){
        if(editText.getText().toString().equals("")){
            editText.setText("0");
        }
    }

    public void clearText(EditText editText){
        if(!editText.getText().toString().equals("")){
            editText.setText("0");
        }
    }



}
