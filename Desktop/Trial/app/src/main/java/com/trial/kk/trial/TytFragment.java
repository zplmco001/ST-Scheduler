package com.trial.kk.trial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

/**
 * Created by kursat on 3.02.2019.
 */

public class TytFragment extends Fragment {

    Button matButton,turkceButton,geoButton,fizButton,kimyaButton,biyoButton,tarihButton,cogButton,felButton,dinButton;

    LinearLayout matLayout,turkceLayout,geoLayout,fizikLayout,kimyaLayout,biyoLayout,
                    tarihLayout,cogLayout,felLayout, dinLayout;

    //MATEMATİK
    CheckBox sayilarCB,sayiBasCB,bolmeBolCB,obebOkekCB,rasSayCB,basitEsitCB,mutlakCB,usluSayilarCB,kokluCB,carpAyirCB,
            oranOrantiCB,denklemlerCB,problemCB,kumelerKarCB,fonksiyonCB,permutasyonCB,kombinasyonCB,binomCB,olasilikCB,
            istatistikCB,karmasikSayiCB,polinomCB,ikinciDerCB;

    //TÜRKÇE
    CheckBox sozcukteAnlamCB,sozYorumCB,deyimAtasozuCB,cumleAnlamCB,cumleYorumCB,paragTekCB,paragAnaCB,paragYarCB,
            sesBilCB,yazKurCB,nokIsaretCB,sozcukYapCB,sozcukTurCB,fiillerCB,sozcukGrupCB,cumleOgeCB,cumleTurCB,
            anlatimBozCB;

    //GEOMETRİ
    CheckBox ucgenAciCB,dikOzelCB,dikUcgenTrigoCB,ikizEsCB,ucgenAlanCB,ucgenAciortayCB,ucgenKenarOrtCB,ucgenBenzCB,
            ucgenAciKenarCB,cokgenlerCB,dikdortgenlerCB,yamukCB,paralelKenarCB,esDortCB,cemberCB,
            cemberUzunlukCB,daireCB,prizmaCB,piramitCB,kureCB,koordinatCB,dogruAnalitikCB,yansiyanSekCB;

    //FİZİK
    CheckBox fizikBilCB,maddeOzCB,hareketKuvvetCB,enerjiCB,isiSicaklikCB,elektrostatikCB,elektrikManyetizmaCB,
            basincKaldirmaKuvCB,
            dalgaCB,optikCB;

    //KİMYA
    CheckBox kimyaBilCB,atomPerSisCB,atomTeoCB,tepkimelerCB,kimyaHesapCB,asitBazTuzCB,maddeHalCB,gazlarCB,karisimlarCB,
            canlilardaEnerjiCB,kimyaHerYerdeCB;

    //BİYOLOJİ
    CheckBox biyoBilimiCB,temelBilCB,hucreCB,canliSinifCB,uremeCB,insandaUSCB,kalitimCB,modernGenCB,ekosistemCB,
            dunyamizCB,canliEnerjiCB,solunumCB,fizyolojiCB;

    //TARİH
    CheckBox tarihBilCB,ilkUygCB,ilkTurkDevCB,islamTarUygCB,turkIslamDevCB,turkTarihiCB,beyliktenDevleteCB,osmanliDevletiCB,
            arayisYillariCB,avrOsmanliDevCB,enUzunYilCB,yirminciYYOsmanliDevCB,birDunyaSavCB,kurtulusSavCB,turkInkCB,
            ataturkIlkeCB,turkDisPolCB;

    //COGRAFYA
    CheckBox cogBolCB,parMerCB,dunyaSekliCB,haritaBilCB,iklimBilCB,yerinSekliCB,nufusYerlesmeCB,ulasimYollariCB,
            ekonomikFaalCB,
            bolgeCB,dogalAfetCB;

    //FELSEFE
    CheckBox felKonuCB,bilgiFelCB,varlikFelCB,ahlakFelCB,sanatFelCB,dinFelCB,siyasetFelCB,bilimFelCB;

    //DİN KÜLTÜRÜ
    CheckBox kuranAnlasilmasiCB,insanVeDinCB,islamİbadetCB,islamMezhepCB,hzMuhHayatiCB,islamBilimCB,yasayanDinlerCB;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tyt_fragment,container,false);

       // ve  = new VeritabaniErisim(getContext());

        // BUTONLAR

        matButton = (Button) view.findViewById(R.id.matButton);
        turkceButton = (Button) view.findViewById(R.id.turkceButton);
        geoButton = (Button) view.findViewById(R.id.geoButton);
        biyoButton = (Button) view.findViewById(R.id.biyoButton);
        tarihButton = (Button) view.findViewById(R.id.tarihButton);
        kimyaButton = (Button) view.findViewById(R.id.kimyaButton);
        fizButton = (Button) view.findViewById(R.id.fizButton);
        dinButton = (Button) view.findViewById(R.id.dinButton);
        felButton = (Button) view.findViewById(R.id.felButton);
        cogButton = (Button) view.findViewById(R.id.cogButton);

        // LAYOUTLAR

        matLayout = (LinearLayout) view.findViewById(R.id.matLayout);
        turkceLayout = (LinearLayout) view.findViewById(R.id.turkceLayout);
        geoLayout = (LinearLayout) view.findViewById(R.id.matLayout);
        biyoLayout = (LinearLayout) view.findViewById(R.id.biyoLayout);
        tarihLayout = (LinearLayout) view.findViewById(R.id.tarihLayout);
        kimyaLayout = (LinearLayout) view.findViewById(R.id.kimyaLayout);
        fizikLayout = (LinearLayout) view.findViewById(R.id.fizikLayout);
        dinLayout = (LinearLayout) view.findViewById(R.id.dinLayout);
        felLayout = (LinearLayout) view.findViewById(R.id.felLayout);
        cogLayout = (LinearLayout) view.findViewById(R.id.cogLayout);

        // MATEMATİK CHECKBOX

        sayilarCB = view.findViewById(R.id.sayilarCB);
        sayiBasCB = view.findViewById(R.id.sayiBasCB);
        bolmeBolCB = view.findViewById(R.id.bolmeBolCB);
        obebOkekCB = view.findViewById(R.id.obekOkekCB);
        rasSayCB = view.findViewById(R.id.rasSayCB);
        basitEsitCB = view.findViewById(R.id.basitEsitCB);
        mutlakCB = view.findViewById(R.id.mutlakCB);
        usluSayilarCB = view.findViewById(R.id.usluSayilarCB);
        kokluCB = view.findViewById(R.id.kokluCB);
        carpAyirCB = view.findViewById(R.id.carpAyirCB);
        oranOrantiCB = view.findViewById(R.id.oranOrantiCB);
        denklemlerCB = view.findViewById(R.id.denklemCB);
        problemCB = view.findViewById(R.id.problemCB);
        kumelerKarCB = view.findViewById(R.id.kumelerKarCB);
        fonksiyonCB = view.findViewById(R.id.fonksiyonCB);
        permutasyonCB = view.findViewById(R.id.permutasyonCB);
        kombinasyonCB = view.findViewById(R.id.kombinasyonCB);
        binomCB = view.findViewById(R.id.binomCB);
        olasilikCB = view.findViewById(R.id.olasilikCB);
        istatistikCB = view.findViewById(R.id.istatistikCB);
        karmasikSayiCB = view.findViewById(R.id.karmasikSayiCB);
        polinomCB = view.findViewById(R.id.polinomCB);
        ikinciDerCB = view.findViewById(R.id.ikinciDerCB);

        // TÜRKÇE CHECKBOX

        sozcukteAnlamCB = view.findViewById(R.id.sozcukteAnlamCB);
        sozYorumCB = view.findViewById(R.id.sozYorumCB);
        deyimAtasozuCB = view.findViewById(R.id.deyimAtasozuCB);
        cumleAnlamCB = view.findViewById(R.id.cumleAnlamCB);
        cumleYorumCB = view.findViewById(R.id.cumleYorumCB);
        paragTekCB = view.findViewById(R.id.paragTekCB);
        paragAnaCB = view.findViewById(R.id.paragAnaCB);
        paragYarCB = view.findViewById(R.id.paragYarCB);
        sesBilCB = view.findViewById(R.id.sesBilCB);
        yazKurCB = view.findViewById(R.id.yazKurCB);
        nokIsaretCB = view.findViewById(R.id.nokIsaretCB);
        sozcukYapCB = view.findViewById(R.id.sozcukYapCB);
        sozcukTurCB = view.findViewById(R.id.sozcukTurCB);
        fiillerCB = view.findViewById(R.id.fiillerCB);
        sozcukGrupCB = view.findViewById(R.id.sozcukGrupCB);
        cumleOgeCB = view.findViewById(R.id.cumleOgeCB);
        cumleTurCB = view.findViewById(R.id.cumleTurCB);
        anlatimBozCB = view.findViewById(R.id.anlatimBozCB);

        // GEOMETRİ CHECKBOX

        ucgenAciCB = view.findViewById(R.id.ucgenAciCB);
        dikOzelCB = view.findViewById(R.id.dikOzelCB);
        dikUcgenTrigoCB = view.findViewById(R.id.dikdortgenCB);
        ikizEsCB = view.findViewById(R.id.ikizEsCB);
        ucgenAlanCB = view.findViewById(R.id.ucgenAlanCB);
        ucgenAciortayCB = view.findViewById(R.id.ucgenAciortayCB);
        ucgenKenarOrtCB = view.findViewById(R.id.ucgenKenarOrtCB);
        ucgenBenzCB = view.findViewById(R.id.ucgenBenzCB);
        ucgenAciKenarCB = view.findViewById(R.id.ucgenAciKenarCB);
        cokgenlerCB = view.findViewById(R.id.cokgenlerCB);
        dikdortgenlerCB = view.findViewById(R.id.dikdortgenCB);
        yamukCB = view.findViewById(R.id.yamukCB);
        paralelKenarCB = view.findViewById(R.id.paralelKenarCB);
        esDortCB = view.findViewById(R.id.esDortCB);
        cemberCB = view.findViewById(R.id.cemberCB);
        cemberUzunlukCB = view.findViewById(R.id.cemberUzunlukCB);
        daireCB = view.findViewById(R.id.daireCB);
        prizmaCB = view.findViewById(R.id.prizmaCB);
        piramitCB = view.findViewById(R.id.piramitCB);
        kureCB = view.findViewById(R.id.kureCB);
        koordinatCB = view.findViewById(R.id.koordinatCB);
        dogruAnalitikCB = view.findViewById(R.id.dogruAnalitikCB);
        yansiyanSekCB = view.findViewById(R.id.yansiyanSekCB);

        // FİZİK CHECKBOX

        fizikBilCB = view.findViewById(R.id.fizikBilCB);
        maddeOzCB = view.findViewById(R.id.maddeOzCB);
        hareketKuvvetCB = view.findViewById(R.id.hareketKuvvetCB);
        enerjiCB = view.findViewById(R.id.enerjiCB);
        isiSicaklikCB = view.findViewById(R.id.isiSicaklikCB);
        elektrostatikCB = view.findViewById(R.id.elektrikManyetizmaCB);
        elektrikManyetizmaCB = view.findViewById(R.id.elektrikManyetizmaCB);
        basincKaldirmaKuvCB = view.findViewById(R.id.basincKaldirmaKuvCB);
        dalgaCB = view.findViewById(R.id.dalgaCB);
        optikCB = view.findViewById(R.id.optikCB);

        // KİMYA CHECKBOX

        kimyaBilCB = view.findViewById(R.id.kimyaBilCB);
        atomPerSisCB = view.findViewById(R.id.atomPerSisCB);
        atomTeoCB = view.findViewById(R.id.atomTeoCB);
        tepkimelerCB = view.findViewById(R.id.tepkimelerCB);
        kimyaHesapCB = view.findViewById(R.id.kimyaHesapCB);
        asitBazTuzCB = view.findViewById(R.id.asitBazTuzCB);
        maddeHalCB = view.findViewById(R.id.maddeHalCB);
        gazlarCB = view.findViewById(R.id.gazlarCB);
        karisimlarCB = view.findViewById(R.id.karisimlarCB);
        canlilardaEnerjiCB = view.findViewById(R.id.canlilardaEnerjiCB);
        kimyaHerYerdeCB = view.findViewById(R.id.kimyaHerYerdeCB);

        // BİYOLOJİ CHECKBOX

        biyoBilimiCB = view.findViewById(R.id.biyoBilimiCB);
        temelBilCB = view.findViewById(R.id.temelBilCB);
        hucreCB = view.findViewById(R.id.hucreCB);
        canliSinifCB = view.findViewById(R.id.canliSinifCB);
        uremeCB = view.findViewById(R.id.uremeCB);
        insandaUSCB = view.findViewById(R.id.insandaUSCB);
        kalitimCB = view.findViewById(R.id.kalitimCB);
        modernGenCB = view.findViewById(R.id.modernGenCB);
        ekosistemCB = view.findViewById(R.id.ekosistemCB);
        dunyamizCB = view.findViewById(R.id.dunyamizCB);
        canliEnerjiCB = view.findViewById(R.id.canlilardaEnerjiCB);
        solunumCB = view.findViewById(R.id.solunumCB);
        fizyolojiCB = view.findViewById(R.id.fizyolojiCB);

        // TARİH CHECKBOX

        tarihBilCB = view.findViewById(R.id.tarihBilCB);
        ilkUygCB = view.findViewById(R.id.ilkUygCB);
        ilkTurkDevCB = view.findViewById(R.id.ilkTurkDevCB);
        islamTarUygCB = view.findViewById(R.id.islamTarUygCB);
        turkIslamDevCB = view.findViewById(R.id.turkIslamDevCB);
        turkTarihiCB = view.findViewById(R.id.turkTarihiCB);
        beyliktenDevleteCB = view.findViewById(R.id.beyliktenDevleteCB);
        osmanliDevletiCB = view.findViewById(R.id.osmanliDevletiCB);
        arayisYillariCB = view.findViewById(R.id.arayisYillariCB);
        avrOsmanliDevCB = view.findViewById(R.id.avrOsmanliDevCB);
        enUzunYilCB = view.findViewById(R.id.enUzunYilCB);
        yirminciYYOsmanliDevCB = view.findViewById(R.id.yirminciYYOsmanliDevCB);
        birDunyaSavCB = view.findViewById(R.id.birDunyaSavCB);
        kurtulusSavCB = view.findViewById(R.id.kurtulusSavCB);
        turkInkCB = view.findViewById(R.id.turkInkCB);
        ataturkIlkeCB = view.findViewById(R.id.ataturkIlkeCB);
        turkDisPolCB = view.findViewById(R.id.turkDisPolCB);

        // COĞRAFYA CHECKBOX

        cogBolCB = view.findViewById(R.id.cogBolCB);
        parMerCB = view.findViewById(R.id.parMerCB);
        dunyaSekliCB = view.findViewById(R.id.dunyaSekliCB);
        haritaBilCB = view.findViewById(R.id.haritaBilCB);
        iklimBilCB = view.findViewById(R.id.iklimBilCB);
        yerinSekliCB = view.findViewById(R.id.yerinSekliCB);
        nufusYerlesmeCB = view.findViewById(R.id.nufusYerlesmeCB);
        ulasimYollariCB = view.findViewById(R.id.ulasimYollariCB);
        ekonomikFaalCB = view.findViewById(R.id.ekonomikFaalCB);
        bolgeCB = view.findViewById(R.id.bolgeCB);
        dogalAfetCB = view.findViewById(R.id.dogalAfetCB);

        // FELSEFE CHECKBOX

        felKonuCB = view.findViewById(R.id.felKonuCB);
        bilgiFelCB = view.findViewById(R.id.bilgiFelCB);
        varlikFelCB = view.findViewById(R.id.varlikFelCB);
        ahlakFelCB = view.findViewById(R.id.ahlakFelCB);
        sanatFelCB = view.findViewById(R.id.sanatFelCB);
        dinFelCB = view.findViewById(R.id.dinFelCB);
        siyasetFelCB = view.findViewById(R.id.siyasetFelCB);
        bilimFelCB = view.findViewById(R.id.bilimFelCB);

        // DİN KÜLTÜRÜ CHECKBOX

        kuranAnlasilmasiCB = view.findViewById(R.id.kuranAnlasilmasiCB);
        insanVeDinCB = view.findViewById(R.id.insanVeDinCB);
        islamİbadetCB = view.findViewById(R.id.islamİbadetCB);
        islamMezhepCB = view.findViewById(R.id.islamMezhepCB);
        hzMuhHayatiCB = view.findViewById(R.id.hzMuhHayatiCB);
        islamBilimCB = view.findViewById(R.id.islamBilimCB);
        yasayanDinlerCB = view.findViewById(R.id.yasayanDinlerCB);

        // VERİTABANI KISMI

        /* sayilarCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ve.open();
                if (sayilarCB.isChecked()){

                    ve.add((String) sayilarCB.getText(),1);
                }else{
                    ve.add((String) sayilarCB.getText(),0);
                }
                ve.close();
            }
        });
        ve.open();
        if (ve.get(0)==1){
            sayilarCB.setChecked(true);
        }
        ve.close();  */

        matButton.setOnClickListener(new butonListener(matLayout));
        turkceButton.setOnClickListener(new butonListener(turkceLayout));
        geoButton.setOnClickListener(new butonListener(geoLayout));
        fizButton.setOnClickListener(new butonListener(fizikLayout));
        kimyaButton.setOnClickListener(new butonListener(kimyaLayout));
        biyoButton.setOnClickListener(new butonListener(biyoLayout));
        tarihButton.setOnClickListener(new butonListener(tarihLayout));
        cogButton.setOnClickListener(new butonListener(cogLayout));
        felButton.setOnClickListener(new butonListener(felLayout));
        dinButton.setOnClickListener(new butonListener(dinLayout));

        return view;
    }

    class butonListener implements View.OnClickListener{

        private LinearLayout ln;
        @Override
        public void onClick(View view) {

            if (ln.getVisibility() == View.INVISIBLE){
                ln.setVisibility(View.VISIBLE);
                ln.setMinimumHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
            }else{
                ln.setVisibility(View.INVISIBLE);
                ln.setMinimumHeight(0);
            }

        }

        butonListener(LinearLayout linearLayout){
            this.ln = linearLayout;
        }
    }
}
