package com.trial.kk.trial;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kursat on 3.02.2019.
 */

public class AytFragment extends Fragment {

    ArrayList <String> matCB = new ArrayList<>();
    ArrayList <String> edebiyatCB = new ArrayList<>();
    ArrayList <String> geometriCB = new ArrayList<>();
    ArrayList <String> fizikCB = new ArrayList<>();
    ArrayList <String> kimyaCB = new ArrayList<>();
    ArrayList <String> biyolojiCB = new ArrayList<>();
    ArrayList <String> tarihCB = new ArrayList<>();
    ArrayList <String> cografyaCB = new ArrayList<>();
    ArrayList <String> felsefeCB = new ArrayList<>();
    ArrayList <String> dinCB = new ArrayList<>();

    static ArrayList<String> konular = new ArrayList<>();
    static int nums [] = {31,15,27,17,18,24,29,6,22,11};

    static ArrayList <String> derslerAYT = new ArrayList<>();
    ArrayList<CheckBox> checkBoxes = new ArrayList<>();

    //Button mat2Button,geo2Button,fizik2Button,kimya2Button,biyo2Button,edebiyatButton,cog2Button,tarih2Button,dinVeFelButton;
    //LinearLayout mat2Layout,geo2Layout,fizik2Layout,kimya2Layout,biyo2Layout,edebiyat2Layout,cog2Layout,tarih2Layout,dinveFelLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ayt_fragment,container,false);


        LinearLayout linearLayout = view.findViewById(R.id.aytLayout);

        KonularView matKonu = new KonularView(getContext(),"Matematik",matCB);
        linearLayout.addView(matKonu.getLinearLayout());

        ArrayList<CheckBox> checks = matKonu.getChecboxes();
        for (int i=0; i<checks.size();i++){
            checkBoxes.add(checks.get(i));
        }


        KonularView edebiyatKonu= new KonularView(getContext(),"Edebiyat",edebiyatCB);
        linearLayout.addView(edebiyatKonu.getLinearLayout());

        checks = edebiyatKonu.getChecboxes();
        for (int i=0; i<checks.size();i++){
            checkBoxes.add(checks.get(i));
        }

        KonularView geometriKonu = new KonularView(getContext(),"Geometri",geometriCB);
        linearLayout.addView(geometriKonu.getLinearLayout());

        checks = geometriKonu.getChecboxes();
        for (int i=0; i<checks.size();i++){
            checkBoxes.add(checks.get(i));
        }

        KonularView fizikKonu = new KonularView(getContext(),"Fizik",fizikCB);
        linearLayout.addView(fizikKonu.getLinearLayout());

        checks = fizikKonu.getChecboxes();
        for (int i=0; i<checks.size();i++){
            checkBoxes.add(checks.get(i));
        }

        KonularView kimyaKonu = new KonularView(getContext(),"Kimya",kimyaCB);
        linearLayout.addView(kimyaKonu.getLinearLayout());

        checks = kimyaKonu.getChecboxes();
        for (int i=0; i<checks.size();i++){
            checkBoxes.add(checks.get(i));
        }

        KonularView biyolojiKonu = new KonularView(getContext(),"Biyoloji",biyolojiCB);
        linearLayout.addView(biyolojiKonu.getLinearLayout());

        checks = biyolojiKonu.getChecboxes();
        for (int i=0; i<checks.size();i++){
            checkBoxes.add(checks.get(i));
        }

        KonularView tarihKonu = new KonularView(getContext(),"Tarih",tarihCB);
        linearLayout.addView(tarihKonu.getLinearLayout());

        checks = tarihKonu.getChecboxes();
        for (int i=0; i<checks.size();i++){
            checkBoxes.add(checks.get(i));
        }

        KonularView cografyaKonu = new KonularView(getContext(),"Coğrafya",cografyaCB);
        linearLayout.addView(cografyaKonu.getLinearLayout());

        checks = cografyaKonu.getChecboxes();
        for (int i=0; i<checks.size();i++){
            checkBoxes.add(checks.get(i));
        }

        KonularView felsefeKonu = new KonularView(getContext(),"Felsefe",felsefeCB);
        linearLayout.addView(felsefeKonu.getLinearLayout());

        checks = felsefeKonu.getChecboxes();
        for (int i=0; i<checks.size();i++){
            checkBoxes.add(checks.get(i));
        }

        KonularView dinKonu = new KonularView(getContext(),"Din Kültürü",dinCB);
        linearLayout.addView(dinKonu.getLinearLayout());

        checks = dinKonu.getChecboxes();
        for (int i=0; i<checks.size();i++){
            checkBoxes.add(checks.get(i));
        }

        for (int i=0;i<checkBoxes.size();i++){
            checkBoxes.get(i).setOnClickListener(new checkListener(checkBoxes.get(i)));
        }

        DatabaseConnection dc = new DatabaseConnection(getContext());
        dc.open();

        List<Integer> list = dc.getState();

        Log.e("ads",""+list.size());

        for (int i=143;i<list.size();i++){
            Log.e("saf",String.valueOf(list.get(i)));
            if (list.get(i) == 1){
                Log.e("asd","afs");
                final CheckBox box = checkBoxes.get(i-143);
                Log.e("konu",box.getText().toString());
                box.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("","checked");
                        box.setChecked(true);
                    }
                });
                Log.e( "index",""+i);
            }
        }

        dc.close();


        return view;
    }



    AytFragment(){
        // DERS ADLARI

        derslerAYT.add("Matematik");
        derslerAYT.add("Türkçe");
        derslerAYT.add("Geometri");
        derslerAYT.add("Fizik");
        derslerAYT.add("Kimya");
        derslerAYT.add("Biyoloji");
        derslerAYT.add("Tarih");
        derslerAYT.add("Coğrafya");
        derslerAYT.add("Felsefe");
        derslerAYT.add("Din Kültürü");

        // MATEMATİK CHECKBOX

        matCB.add("Temel Kavramlar");
        matCB.add("Sayı Basamakları");
        matCB.add("Rasyonel Sayılar");
        matCB.add("Ondalıklı Sayılar");
        matCB.add("Basit Eşitsizlik");
        matCB.add("Mutlak Değer");
        matCB.add("Üslü Sayılar");
        matCB.add("Köklü Sayılar");
        matCB.add("Çarpanlara Ayırma");
        matCB.add("Denklem Çözme");
        matCB.add("Oran-Orantı");
        matCB.add("Problemler");
        matCB.add("Kümeler");
        matCB.add("Fonksiyonlar");
        matCB.add("Permütasyon");
        matCB.add("Kombinasyon");
        matCB.add("Binom");
        matCB.add("Olasılık");
        matCB.add("İstatistik");
        matCB.add("2.Dereceden Denklemler");
        matCB.add("Karmaşık Sayılar");
        matCB.add("Parabol");
        matCB.add("Polinomlar");
        matCB.add("Mantık");
        matCB.add("Eşitsizlikler");
        matCB.add("Logaritma");
        matCB.add("Diziler");
        matCB.add("Seriler");
        matCB.add("Limit ve Süreklilik");
        matCB.add("Türev");
        matCB.add("İntegral");

        for (int i=0;i<matCB.size();i++){
            konular.add(matCB.get(i));
        }

        // EDEBİYAT CHECKBOX

        edebiyatCB.add("Güzel Sanatlar ve Edebiyat");
        edebiyatCB.add("Coşku ve Heyecan Dile Getiren Metinler (Şiir)");
        edebiyatCB.add("Olay Çevresinde Oluşan Edebi Metinler");
        edebiyatCB.add("Öğretici Metinler (Edebiyat 9. Sınıf)");
        edebiyatCB.add("Tarih İçinde Türk Edebiyatı");
        edebiyatCB.add("Destan Dönemi Türk Edebiyatı");
        edebiyatCB.add("İslam Uygarlığı Çevresinde Gelişen Türk Edebiyatı");
        edebiyatCB.add("Batı Tesirindeki Türk Edebiyatına Giriş (Yenileşme Dönemi Türk Edebiyatı)");
        edebiyatCB.add("Tanzimat Dönemi Edebiyatı (1860-1896)\n");
        edebiyatCB.add("Servet-i Fünun Edebiyatı (Edebiyat-ı Cedide) (1896-1901) ve Fecr-i Ati Topluluğu (1909-1912)");
        edebiyatCB.add("Milli Edebiyat Dönemi (1911-1923)");
        edebiyatCB.add("Cumhuriyet Dönemi Türk Edebiyatı (1923-…)");
        edebiyatCB.add("Cumhuriyet Döneminde Öğretici Metinler");
        edebiyatCB.add("Cumhuriyet Döneminde Coşku ve Heyecanı Dile Getiren Metinler (Şiir)\n");
        edebiyatCB.add("Cumhuriyet Döneminde Olay Çevresinde Oluşan Edebi Metinler");

        for (int i=0;i<edebiyatCB.size();i++){
            konular.add(edebiyatCB.get(i));
        }

        // GEOMETRİ CHECKBOX

        geometriCB.add("Doğruda ve Üçgende Açılar");
        geometriCB.add("Dik ve Özel Üçgenler");
        geometriCB.add("Dik Üçgende Trigonemetrik Bağıntılar");
        geometriCB.add("İkizkenar ve Eşkenar Üçgen");
        geometriCB.add("Üçgende Alanlar");
        geometriCB.add("Üçgende Açıortay Bağıntıları");
        geometriCB.add("Üçgende Kenarortay Bağıntıları");
        geometriCB.add("Üçgende Eşlik ve Benzerlik");
        geometriCB.add("Üçgende Açı-Kenar Bağıntıları");
        geometriCB.add("Çokgenler");
        geometriCB.add("Dörtgenler");
        geometriCB.add("Yamuk");
        geometriCB.add("Paralelkenar");
        geometriCB.add("Eşkenar Dörtgen – Deltoid");
        geometriCB.add("Dikdörtgen");
        geometriCB.add("Çemberde Açılar");
        geometriCB.add("Çemberde Uzunluk");
        geometriCB.add("Daire");
        geometriCB.add("Prizmalar");
        geometriCB.add("Piramitler");
        geometriCB.add("Küre");
        geometriCB.add("Koordinat Düzlemi ve Noktanın Analitiği");
        geometriCB.add("Doğrunun Analitiği");
        geometriCB.add("Tekrar Eden, Dönen ve Yansıyan Şekiller");
        geometriCB.add("Dönüşümlerle Geometri");
        geometriCB.add("Trigonometri");
        geometriCB.add("Çemberin Analitiği");

        for (int i=0;i<geometriCB.size();i++){
            konular.add(geometriCB.get(i));
        }

        // FİZİK CHECKBOX

        fizikCB.add("Fizik Bilimine Giriş");
        fizikCB.add("Madde ve Özellikleri");
        fizikCB.add("Hareket ve Kuvvet");
        fizikCB.add("Enerji");
        fizikCB.add("Isı ve Sıcaklık");
        fizikCB.add("Elektrostatik");
        fizikCB.add("Elektrik ve Manyetizma");
        fizikCB.add("Basınç ve Kaldırma Kuvveti");
        fizikCB.add("Dalgalar");
        fizikCB.add("Optik");
        fizikCB.add("Kuvvet ve Hareket");
        fizikCB.add("Çembersel Hareket");
        fizikCB.add("Basit Harmonik Hareket");
        fizikCB.add("Dalga Mekaniği");
        fizikCB.add("Atom Fiziğine Giriş ve Radyoaktive");
        fizikCB.add("Modern Fizik");
        fizikCB.add("Modern Fiziğin Teknolojideki Uygulamaları");

        for (int i=0;i<fizikCB.size();i++){
            konular.add(fizikCB.get(i));
        }

        // KİMYA CHECKBOX

        kimyaCB.add("Kimya Bilimi");
        kimyaCB.add("Atom ve Periyodik Sistem");
        kimyaCB.add("Modern Atom Teorisi");
        kimyaCB.add("Kimyasal Türler Arası Tepkimeler");
        kimyaCB.add("Kimyasal Hesaplamalar");
        kimyaCB.add("Asit, Baz ve Tuz");
        kimyaCB.add("Maddenin Halleri");
        kimyaCB.add("Gazlar");
        kimyaCB.add("Karışımlar");
        kimyaCB.add("Sıvı Çözeltiler");
        kimyaCB.add("Kimya ve Enerji");
        kimyaCB.add("Tepkimelerde Hız ve Denge");
        kimyaCB.add("Kimya ve Elektrik");
        kimyaCB.add("Karbon Kimyasına Giriş");
        kimyaCB.add("Organik Bileşikler");
        kimyaCB.add("Endüstride ve Canlılarda Enerji");
        kimyaCB.add("Kimya Her Yerde");
        kimyaCB.add("Hayatımızdaki Kimya");

        for (int i=0;i<kimyaCB.size();i++){
            konular.add(kimyaCB.get(i));
        }

        // BİYOLOJİ CHECKBOX

        biyolojiCB.add("Biyoloji Bilimi");
        biyolojiCB.add("Canlıların Yapısında Bulunan Temel Bileşenler");
        biyolojiCB.add("Hücrenin Yapısı ve İşlevi");
        biyolojiCB.add("Canlıların Çeşitliliği ve Sınıflandırması");
        biyolojiCB.add("Üreme");
        biyolojiCB.add("İnsanda Üreme Sistemi");
        biyolojiCB.add("Kalıtım");
        biyolojiCB.add("Modern Genetik Uygulamaları");
        biyolojiCB.add("Ekosistem Ekolojisi");
        biyolojiCB.add("Dünyamız");
        biyolojiCB.add("Canlılarda Enerji Dönüşümü");
        biyolojiCB.add("Solunum");
        biyolojiCB.add("İnsan Fizyolojisi");
        biyolojiCB.add("Endokrin Sistemi");
        biyolojiCB.add("Duyu Organları");
        biyolojiCB.add("Destek ve Hareket Sistemi");
        biyolojiCB.add("Sindirim Sistemi");
        biyolojiCB.add("İnsanda Sinir Sistemi");
        biyolojiCB.add("Dolaşım Sistemi");
        biyolojiCB.add("Genden Proteine");
        biyolojiCB.add("Hayatın Başlangıcı ve Evrim");
        biyolojiCB.add("Bitkisel Dokular");
        biyolojiCB.add("Bitki Biyolojisi");
        biyolojiCB.add("Kominite ve Popülasyon Ekolojisi");

        for (int i=0;i<biyolojiCB.size();i++){
            konular.add(biyolojiCB.get(i));
        }

        // TARİH CHECKBOX

        tarihCB.add("Tarih Bilimi");
        tarihCB.add("Uygarlığın Doğuşu ve İlk Uygarlıklar");
        tarihCB.add("İlk Türk Devletleri");
        tarihCB.add("İslam Tarihi ve Uygarlığı");
        tarihCB.add("Türk-İslam Devletleri");
        tarihCB.add("Türkiye Tarihi");
        tarihCB.add("Beylikten Devlete (1300-1453)");
        tarihCB.add("Dünya Gücü: Osmanlı Devleti (1453-1600)");
        tarihCB.add("Arayış Yılları (17. Yüzyıl)");
        tarihCB.add("Avrupa ve Osmanlı Devleti (18. Yüzyıl)");
        tarihCB.add("En Uzun Yüzyıl (1800-1922)");
        tarihCB.add("1881’den 1919’a Mustafa Kemal");
        tarihCB.add("Milli Mücadele’nin Hazırlık Dönemi");
        tarihCB.add("Kurtuluş Savaşı’nda Cepheler");
        tarihCB.add("Türk İnkılabı");
        tarihCB.add("Atatürkçülük ve Atatürk İlkeleri");
        tarihCB.add("Atatürk Dönemi Türk Dış Politikası");
        tarihCB.add("Atatürk’ün Ölümü");
        tarihCB.add("Yüzyılın Başlarında Dünya");
        tarihCB.add("İkinci Dünya Savaşı");
        tarihCB.add("Soğuk Savaş Dönemi");
        tarihCB.add("Yumuşama Dönemi ve Sonrası");
        tarihCB.add("Küreselleşen Dünya");
        tarihCB.add("Türklerde Devlet Teşkilatı");
        tarihCB.add("Türklerde Toplum Yapısı");
        tarihCB.add("Türklerde Hukuk");
        tarihCB.add("Türklerde Ekonomi");
        tarihCB.add("Türklerde Eğitim");
        tarihCB.add("Türklerde Sanat");

        for (int i=0;i<tarihCB.size();i++){
            konular.add(tarihCB.get(i));
        }

        // COĞRAFYA CHECKBOX

        cografyaCB.add("Doğal Sistemler");
        cografyaCB.add("Beşeri Sistemler");
        cografyaCB.add("Mekansal Sentez Türkiye");
        cografyaCB.add("Küresel Ortam: Bölgeler ve Ülkeler");
        cografyaCB.add("Çevre ve Toplum");
        cografyaCB.add("Ekonomik Faaliyetler");

        for (int i=0;i<cografyaCB.size();i++){
            konular.add(cografyaCB.get(i));
        }

        // FELSEFE CHECKBOX

        felsefeCB.add("Felsefe’nin Konusu");
        felsefeCB.add("Bilgi Felsefesi");
        felsefeCB.add("Varlık Felsefesi");
        felsefeCB.add("Ahlak Felsefesi");
        felsefeCB.add("Sanat Felsefesi");
        felsefeCB.add("Din Felsefesi");
        felsefeCB.add("Siyaset Felsefesi");
        felsefeCB.add("Bilim Felsefesi");
        felsefeCB.add("Mantığa Giriş");
        felsefeCB.add("Klasik Mantık");
        felsefeCB.add("Mantık ve Dil");
        felsefeCB.add("Sembolik Mantık");
        felsefeCB.add("Psikoloji Bilimini Tanıyalım");
        felsefeCB.add("Psikolojinin Temel Süreçleri");
        felsefeCB.add("Öğrenme Bellek Düşünme");
        felsefeCB.add("Ruh Sağlığının Temelleri");
        felsefeCB.add("Sosyolojiye Giriş");
        felsefeCB.add("Birey ve Toplum");
        felsefeCB.add("Toplumsal Yapı");
        felsefeCB.add("Toplumsal Değişme ve Gelişme");
        felsefeCB.add("Toplum ve Kültür");
        felsefeCB.add("Toplumsal Kurumlar");

        for (int i=0;i<felsefeCB.size();i++){
            konular.add(felsefeCB.get(i));
        }

        // DİN KÜLTÜRÜ CHECKBOX

        dinCB.add("Kur’an-ı Kerim’in Anlaşılması ve Kavranması");
        dinCB.add("İnsan ve Din");
        dinCB.add("İslam ve İbadetler");
        dinCB.add("İslam Düşüncesinde Yorumlar, Mezhepler");
        dinCB.add("Muhammed’in Hayatı, Örnekliği ve Onu Anlama");
        dinCB.add("İslam ve Bilim, Estetik, Barış");
        dinCB.add("Yaşayan Dinler ve Benzer Özellikleri");
        dinCB.add("İslam Düşüncesinde Tasavvu");
        dinCB.add("Yaşayan Dinler ve Benzer Özellikler");
        dinCB.add("Hazreti Muhammed");
        dinCB.add("Vahiy ve Akıl Kur’an Yorumları");

        for (int i=0;i<dinCB.size();i++){
            konular.add(dinCB.get(i));
        }

    }

    class checkListener implements View.OnClickListener{

        private CheckBox cb;

        checkListener(CheckBox checkBox){
            this.cb = checkBox;
        }

        @Override
        public void onClick(View view) {
            DatabaseConnection dc = new DatabaseConnection(getContext());
            dc.open();
            if (cb.isChecked()){
                dc.changeState((String) cb.getText(),"ayt",true);
            }
            else
                dc.changeState((String) cb.getText(),"ayt",false);
            dc.close();
        }
    }

}
