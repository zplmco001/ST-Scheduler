package com.trial.kk.trial;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

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
            anlatimBozCB,paragYapCB;

    //GEOMETRİ
    CheckBox ucgenAciCB,dikOzelCB,dikUcgenTrigoCB,ikizEsCB,ucgenAlanCB,ucgenAciortayCB,ucgenKenarOrtCB,ucgenBenzCB,
            ucgenAciKenarCB,cokgenlerCB,dikdortgenlerCB,yamukCB,paralelKenarCB,esDortCB,cemberCB,
            cemberUzunlukCB,daireCB,prizmaCB,piramitCB,kureCB,koordinatCB,dogruAnalitikCB,yansiyanSekCB,dortgenlerCB;

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

    static ArrayList<CheckBox> checkBoxes = new ArrayList<>();
    static ArrayList<String> dersler = new ArrayList<>();
    static int[] num = {23,19,24,10,11,13,17,11,8,7};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tyt_fragment,container,false);


        dersler.add("Matematik");
        dersler.add("Türkçe");
        dersler.add("Geometri");
        dersler.add("Fizik");
        dersler.add("Kimya");
        dersler.add("Biyoloji");
        dersler.add("Tarih");
        dersler.add("Coğrafya");
        dersler.add("Felsefe");
        dersler.add("Din Kültürü");

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
        geoLayout = (LinearLayout) view.findViewById(R.id.geoLayout);
        biyoLayout = (LinearLayout) view.findViewById(R.id.biyoLayout);
        tarihLayout = (LinearLayout) view.findViewById(R.id.tarihLayout);
        kimyaLayout = (LinearLayout) view.findViewById(R.id.kimyaLayout);
        fizikLayout = (LinearLayout) view.findViewById(R.id.fizikLayout);
        dinLayout = (LinearLayout) view.findViewById(R.id.dinLayout);
        felLayout = (LinearLayout) view.findViewById(R.id.felLayout);
        cogLayout = (LinearLayout) view.findViewById(R.id.cogLayout);

        // MATEMATİK CHECKBOX

        sayilarCB = view.findViewById(R.id.sayilarCB);
        checkBoxes.add(sayilarCB);
        sayiBasCB = view.findViewById(R.id.sayiBasCB);
        checkBoxes.add(sayiBasCB);
        bolmeBolCB = view.findViewById(R.id.bolmeBolCB);
        checkBoxes.add(bolmeBolCB);
        obebOkekCB = view.findViewById(R.id.obekOkekCB);
        checkBoxes.add(obebOkekCB);
        rasSayCB = view.findViewById(R.id.rasSayCB);
        checkBoxes.add(rasSayCB);
        basitEsitCB = view.findViewById(R.id.basitEsitCB);
        checkBoxes.add(basitEsitCB);
        mutlakCB = view.findViewById(R.id.mutlakCB);
        checkBoxes.add(mutlakCB);
        usluSayilarCB = view.findViewById(R.id.usluSayilarCB);
        checkBoxes.add(usluSayilarCB);
        kokluCB = view.findViewById(R.id.kokluCB);
        checkBoxes.add(kokluCB);
        carpAyirCB = view.findViewById(R.id.carpAyirCB);
        checkBoxes.add(carpAyirCB);
        oranOrantiCB = view.findViewById(R.id.oranOrantiCB);
        checkBoxes.add(oranOrantiCB);
        denklemlerCB = view.findViewById(R.id.denklemCB);
        checkBoxes.add(denklemlerCB);
        problemCB = view.findViewById(R.id.problemCB);
        checkBoxes.add(problemCB);
        kumelerKarCB = view.findViewById(R.id.kumelerKarCB);
        checkBoxes.add(kumelerKarCB);
        fonksiyonCB = view.findViewById(R.id.fonksiyonCB);
        checkBoxes.add(fonksiyonCB);
        permutasyonCB = view.findViewById(R.id.permutasyonCB);
        checkBoxes.add(permutasyonCB);
        kombinasyonCB = view.findViewById(R.id.kombinasyonCB);
        checkBoxes.add(kombinasyonCB);
        binomCB = view.findViewById(R.id.binomCB);
        checkBoxes.add(binomCB);
        olasilikCB = view.findViewById(R.id.olasilikCB);
        checkBoxes.add(olasilikCB);
        istatistikCB = view.findViewById(R.id.istatistikCB);
        checkBoxes.add(istatistikCB);
        ikinciDerCB = view.findViewById(R.id.ikinciDerCB);
        checkBoxes.add(ikinciDerCB);
        karmasikSayiCB = view.findViewById(R.id.karmasikSayiCB);
        checkBoxes.add(karmasikSayiCB);
        polinomCB = view.findViewById(R.id.polinomCB);
        checkBoxes.add(polinomCB);


        // TÜRKÇE CHECKBOX

        sozcukteAnlamCB = view.findViewById(R.id.sozcukteAnlamCB);
        checkBoxes.add(sozcukteAnlamCB);
        sozYorumCB = view.findViewById(R.id.sozYorumCB);
        checkBoxes.add(sozYorumCB);
        deyimAtasozuCB = view.findViewById(R.id.deyimAtasozuCB);
        checkBoxes.add(deyimAtasozuCB);
        cumleAnlamCB = view.findViewById(R.id.cumleAnlamCB);
        checkBoxes.add(cumleAnlamCB);
        cumleYorumCB = view.findViewById(R.id.cumleYorumCB);
        checkBoxes.add(cumleYorumCB);
        paragTekCB = view.findViewById(R.id.paragTekCB);
        checkBoxes.add(paragTekCB);
        paragAnaCB = view.findViewById(R.id.paragAnaCB);
        checkBoxes.add(paragAnaCB);
        paragYarCB = view.findViewById(R.id.paragYarCB);
        checkBoxes.add(paragYarCB);
        paragYapCB = view.findViewById(R.id.paragYapCB);
        checkBoxes.add(paragYapCB);
        sesBilCB = view.findViewById(R.id.sesBilCB);
        checkBoxes.add(sesBilCB);
        yazKurCB = view.findViewById(R.id.yazKurCB);
        checkBoxes.add(yazKurCB);
        nokIsaretCB = view.findViewById(R.id.nokIsaretCB);
        checkBoxes.add(nokIsaretCB);
        sozcukYapCB = view.findViewById(R.id.sozcukYapCB);
        checkBoxes.add(sozcukYapCB);
        sozcukTurCB = view.findViewById(R.id.sozcukTurCB);
        checkBoxes.add(sozcukTurCB);
        fiillerCB = view.findViewById(R.id.fiillerCB);
        checkBoxes.add(fiillerCB);
        sozcukGrupCB = view.findViewById(R.id.sozcukGrupCB);
        checkBoxes.add(sozcukGrupCB);
        cumleOgeCB = view.findViewById(R.id.cumleOgeCB);
        checkBoxes.add(cumleOgeCB);
        cumleTurCB = view.findViewById(R.id.cumleTurCB);
        checkBoxes.add(cumleTurCB);
        anlatimBozCB = view.findViewById(R.id.anlatimBozCB);
        checkBoxes.add(anlatimBozCB);

        // GEOMETRİ CHECKBOX

        ucgenAciCB = view.findViewById(R.id.ucgenAciCB);
        checkBoxes.add(ucgenAciCB);
        dikOzelCB = view.findViewById(R.id.dikOzelCB);
        checkBoxes.add(dikOzelCB);
        dikUcgenTrigoCB = view.findViewById(R.id.dikUcgenTrigoCB);
        checkBoxes.add(dikUcgenTrigoCB);
        ikizEsCB = view.findViewById(R.id.ikizEsCB);
        checkBoxes.add(ikizEsCB);
        ucgenAlanCB = view.findViewById(R.id.ucgenAlanCB);
        checkBoxes.add(ucgenAlanCB);
        ucgenAciortayCB = view.findViewById(R.id.ucgenAciortayCB);
        checkBoxes.add(ucgenAciortayCB);
        ucgenKenarOrtCB = view.findViewById(R.id.ucgenKenarOrtCB);
        checkBoxes.add(ucgenKenarOrtCB);
        ucgenBenzCB = view.findViewById(R.id.ucgenBenzCB);
        checkBoxes.add(ucgenBenzCB);
        ucgenAciKenarCB = view.findViewById(R.id.ucgenAciKenarCB);
        checkBoxes.add(ucgenAciKenarCB);
        cokgenlerCB = view.findViewById(R.id.cokgenlerCB);
        checkBoxes.add(cokgenlerCB);
        dortgenlerCB = view.findViewById(R.id.dortgenlerCB);
        checkBoxes.add(dortgenlerCB);
        yamukCB = view.findViewById(R.id.yamukCB);
        checkBoxes.add(yamukCB);
        paralelKenarCB = view.findViewById(R.id.paralelKenarCB);
        checkBoxes.add(paralelKenarCB);
        esDortCB = view.findViewById(R.id.esDortCB);
        checkBoxes.add(esDortCB);
        dikdortgenlerCB = view.findViewById(R.id.dikdortgenCB);
        checkBoxes.add(dikdortgenlerCB);
        cemberCB = view.findViewById(R.id.cemberCB);
        checkBoxes.add(cemberCB);
        cemberUzunlukCB = view.findViewById(R.id.cemberUzunlukCB);
        checkBoxes.add(cemberUzunlukCB);
        daireCB = view.findViewById(R.id.daireCB);
        checkBoxes.add(daireCB);
        prizmaCB = view.findViewById(R.id.prizmaCB);
        checkBoxes.add(prizmaCB);
        piramitCB = view.findViewById(R.id.piramitCB);
        checkBoxes.add(piramitCB);
        kureCB = view.findViewById(R.id.kureCB);
        checkBoxes.add(kureCB);
        koordinatCB = view.findViewById(R.id.koordinatCB);
        checkBoxes.add(koordinatCB);
        dogruAnalitikCB = view.findViewById(R.id.dogruAnalitikCB);
        checkBoxes.add(dogruAnalitikCB);
        yansiyanSekCB = view.findViewById(R.id.yansiyanSekCB);
        checkBoxes.add(yansiyanSekCB);

        // FİZİK CHECKBOX

        fizikBilCB = view.findViewById(R.id.fizikBilCB);
        checkBoxes.add(fizikBilCB);
        maddeOzCB = view.findViewById(R.id.maddeOzCB);
        checkBoxes.add(maddeOzCB);
        hareketKuvvetCB = view.findViewById(R.id.hareketKuvvetCB);
        checkBoxes.add(hareketKuvvetCB);
        enerjiCB = view.findViewById(R.id.enerjiCB);
        checkBoxes.add(enerjiCB);
        isiSicaklikCB = view.findViewById(R.id.isiSicaklikCB);
        checkBoxes.add(isiSicaklikCB);
        elektrostatikCB = view.findViewById(R.id.elektrikManyetizmaCB);
        checkBoxes.add(elektrostatikCB);
        elektrikManyetizmaCB = view.findViewById(R.id.elektrikManyetizmaCB);
        checkBoxes.add(elektrikManyetizmaCB);
        basincKaldirmaKuvCB = view.findViewById(R.id.basincKaldirmaKuvCB);
        checkBoxes.add(basincKaldirmaKuvCB);
        dalgaCB = view.findViewById(R.id.dalgaCB);
        checkBoxes.add(dalgaCB);
        optikCB = view.findViewById(R.id.optikCB);
        checkBoxes.add(optikCB);

        // KİMYA CHECKBOX

        kimyaBilCB = view.findViewById(R.id.kimyaBilCB);
        checkBoxes.add(kimyaBilCB);
        atomPerSisCB = view.findViewById(R.id.atomPerSisCB);
        checkBoxes.add(atomPerSisCB);
        atomTeoCB = view.findViewById(R.id.atomTeoCB);
        checkBoxes.add(atomTeoCB);
        tepkimelerCB = view.findViewById(R.id.tepkimelerCB);
        checkBoxes.add(tepkimelerCB);
        kimyaHesapCB = view.findViewById(R.id.kimyaHesapCB);
        checkBoxes.add(kimyaHesapCB);
        asitBazTuzCB = view.findViewById(R.id.asitBazTuzCB);
        checkBoxes.add(asitBazTuzCB);
        maddeHalCB = view.findViewById(R.id.maddeHalCB);
        checkBoxes.add(maddeHalCB);
        gazlarCB = view.findViewById(R.id.gazlarCB);
        checkBoxes.add(gazlarCB);
        karisimlarCB = view.findViewById(R.id.karisimlarCB);
        checkBoxes.add(karisimlarCB);
        canlilardaEnerjiCB = view.findViewById(R.id.canlilardaEnerjiCB);
        checkBoxes.add(canlilardaEnerjiCB);
        kimyaHerYerdeCB = view.findViewById(R.id.kimyaHerYerdeCB);
        checkBoxes.add(kimyaHerYerdeCB);

        // BİYOLOJİ CHECKBOX

        biyoBilimiCB = view.findViewById(R.id.biyoBilimiCB);
        checkBoxes.add(biyoBilimiCB);
        temelBilCB = view.findViewById(R.id.temelBilCB);
        checkBoxes.add(temelBilCB);
        hucreCB = view.findViewById(R.id.hucreCB);
        checkBoxes.add(hucreCB);
        canliSinifCB = view.findViewById(R.id.canliSinifCB);
        checkBoxes.add(canliSinifCB);
        uremeCB = view.findViewById(R.id.uremeCB);
        checkBoxes.add(uremeCB);
        insandaUSCB = view.findViewById(R.id.insandaUSCB);
        checkBoxes.add(insandaUSCB);
        kalitimCB = view.findViewById(R.id.kalitimCB);
        checkBoxes.add(kalitimCB);
        modernGenCB = view.findViewById(R.id.modernGenCB);
        checkBoxes.add(modernGenCB);
        ekosistemCB = view.findViewById(R.id.ekosistemCB);
        checkBoxes.add(ekosistemCB);
        dunyamizCB = view.findViewById(R.id.dunyamizCB);
        checkBoxes.add(dunyamizCB);
        canliEnerjiCB = view.findViewById(R.id.canlilardaEnerjiCB);
        checkBoxes.add(canliEnerjiCB);
        solunumCB = view.findViewById(R.id.solunumCB);
        checkBoxes.add(solunumCB);
        fizyolojiCB = view.findViewById(R.id.fizyolojiCB);
        checkBoxes.add(fizyolojiCB);

        // TARİH CHECKBOX

        tarihBilCB = view.findViewById(R.id.tarihBilCB);
        checkBoxes.add(tarihBilCB);
        ilkUygCB = view.findViewById(R.id.ilkUygCB);
        checkBoxes.add(ilkUygCB);
        ilkTurkDevCB = view.findViewById(R.id.ilkTurkDevCB);
        checkBoxes.add(ilkTurkDevCB);
        islamTarUygCB = view.findViewById(R.id.islamTarUygCB);
        checkBoxes.add(islamTarUygCB);
        turkIslamDevCB = view.findViewById(R.id.turkIslamDevCB);
        checkBoxes.add(turkIslamDevCB);
        turkTarihiCB = view.findViewById(R.id.turkTarihiCB);
        checkBoxes.add(turkTarihiCB);
        beyliktenDevleteCB = view.findViewById(R.id.beyliktenDevleteCB);
        checkBoxes.add(beyliktenDevleteCB);
        osmanliDevletiCB = view.findViewById(R.id.osmanliDevletiCB);
        checkBoxes.add(osmanliDevletiCB);
        arayisYillariCB = view.findViewById(R.id.arayisYillariCB);
        checkBoxes.add(arayisYillariCB);
        avrOsmanliDevCB = view.findViewById(R.id.avrOsmanliDevCB);
        checkBoxes.add(avrOsmanliDevCB);
        enUzunYilCB = view.findViewById(R.id.enUzunYilCB);
        checkBoxes.add(enUzunYilCB);
        yirminciYYOsmanliDevCB = view.findViewById(R.id.yirminciYYOsmanliDevCB);
        checkBoxes.add(yirminciYYOsmanliDevCB);
        birDunyaSavCB = view.findViewById(R.id.birDunyaSavCB);
        checkBoxes.add(birDunyaSavCB);
        kurtulusSavCB = view.findViewById(R.id.kurtulusSavCB);
        checkBoxes.add(kurtulusSavCB);
        turkInkCB = view.findViewById(R.id.turkInkCB);
        checkBoxes.add(turkInkCB);
        ataturkIlkeCB = view.findViewById(R.id.ataturkIlkeCB);
        checkBoxes.add(ataturkIlkeCB);
        turkDisPolCB = view.findViewById(R.id.turkDisPolCB);
        checkBoxes.add(turkDisPolCB);

        // COĞRAFYA CHECKBOX

        cogBolCB = view.findViewById(R.id.cogBolCB);
        checkBoxes.add(cogBolCB);
        parMerCB = view.findViewById(R.id.parMerCB);
        checkBoxes.add(parMerCB);
        dunyaSekliCB = view.findViewById(R.id.dunyaSekliCB);
        checkBoxes.add(dunyaSekliCB);
        haritaBilCB = view.findViewById(R.id.haritaBilCB);
        checkBoxes.add(haritaBilCB);
        iklimBilCB = view.findViewById(R.id.iklimBilCB);
        checkBoxes.add(iklimBilCB);
        yerinSekliCB = view.findViewById(R.id.yerinSekliCB);
        checkBoxes.add(yerinSekliCB);
        nufusYerlesmeCB = view.findViewById(R.id.nufusYerlesmeCB);
        checkBoxes.add(nufusYerlesmeCB);
        ulasimYollariCB = view.findViewById(R.id.ulasimYollariCB);
        checkBoxes.add(ulasimYollariCB);
        ekonomikFaalCB = view.findViewById(R.id.ekonomikFaalCB);
        checkBoxes.add(ekonomikFaalCB);
        bolgeCB = view.findViewById(R.id.bolgeCB);
        checkBoxes.add(bolgeCB);
        dogalAfetCB = view.findViewById(R.id.dogalAfetCB);
        checkBoxes.add(dogalAfetCB);

        // FELSEFE CHECKBOX

        felKonuCB = view.findViewById(R.id.felKonuCB);
        checkBoxes.add(felKonuCB);
        bilgiFelCB = view.findViewById(R.id.bilgiFelCB);
        checkBoxes.add(bilgiFelCB);
        varlikFelCB = view.findViewById(R.id.varlikFelCB);
        checkBoxes.add(varlikFelCB);
        ahlakFelCB = view.findViewById(R.id.ahlakFelCB);
        checkBoxes.add(ahlakFelCB);
        sanatFelCB = view.findViewById(R.id.sanatFelCB);
        checkBoxes.add(sanatFelCB);
        dinFelCB = view.findViewById(R.id.dinFelCB);
        checkBoxes.add(dinFelCB);
        siyasetFelCB = view.findViewById(R.id.siyasetFelCB);
        checkBoxes.add(siyasetFelCB);
        bilimFelCB = view.findViewById(R.id.bilimFelCB);
        checkBoxes.add(bilimFelCB);

        // DİN KÜLTÜRÜ CHECKBOX

        kuranAnlasilmasiCB = view.findViewById(R.id.kuranAnlasilmasiCB);
        checkBoxes.add(kuranAnlasilmasiCB);
        insanVeDinCB = view.findViewById(R.id.insanVeDinCB);
        checkBoxes.add(insanVeDinCB);
        islamİbadetCB = view.findViewById(R.id.islamİbadetCB);
        checkBoxes.add(islamİbadetCB);
        islamMezhepCB = view.findViewById(R.id.islamMezhepCB);
        checkBoxes.add(islamMezhepCB);
        hzMuhHayatiCB = view.findViewById(R.id.hzMuhHayatiCB);
        checkBoxes.add(hzMuhHayatiCB);
        islamBilimCB = view.findViewById(R.id.islamBilimCB);
        checkBoxes.add(islamBilimCB);
        yasayanDinlerCB = view.findViewById(R.id.yasayanDinlerCB);
        checkBoxes.add(yasayanDinlerCB);

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

        for (int i=0;i<checkBoxes.size();i++){
            checkBoxes.get(i).setOnClickListener(new checkListener(checkBoxes.get(i)));
        }

        DatabaseConnection dc = new DatabaseConnection(getContext());
        dc.open();

        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        if (preferences.getInt("intValue",0)!=1){
            dc.initializeKonular();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("intValue",1);
            editor.apply();
        }



        List<Integer> list = dc.getState();

        Log.e("ads",""+list.size());

        for (int i=0;i<143;i++){
            Log.e("fas",String.valueOf(list.get(i)));
            if (list.get(i) == 1){
                Log.e("asd","afs");
                final CheckBox box = checkBoxes.get(i);
                box.post(new Runnable() {
                    @Override
                    public void run() {
                        box.setChecked(true);
                    }
                });
                Log.e( "index",""+i);
            }
        }

        dc.close();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();


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
                dc.changeState((String) cb.getText(),"tyt",true);
            }
            else
                dc.changeState((String) cb.getText(),"tyt",false);
            dc.close();
        }
    }

    class butonListener implements View.OnClickListener{

        private LinearLayout ln;
        @Override
        public void onClick(View view) {

            if (ln.getVisibility() == View.INVISIBLE){
                ln.setVisibility(View.VISIBLE);
                ViewGroup.LayoutParams params = ln.getLayoutParams();
                params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                ln.setLayoutParams(params);
            }else{
                ln.setVisibility(View.INVISIBLE);
                ViewGroup.LayoutParams params = ln.getLayoutParams();
                params.height = 0;
                ln.setLayoutParams(params);
                
            }

        }

        butonListener(LinearLayout linearLayout){
            this.ln = linearLayout;
            ln.setVisibility(View.INVISIBLE);
            ViewGroup.LayoutParams params = ln.getLayoutParams();
            params.height = 0;
            ln.setLayoutParams(params);
        }
    }
}
