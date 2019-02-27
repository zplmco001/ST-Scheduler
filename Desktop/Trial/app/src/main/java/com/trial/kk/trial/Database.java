package com.trial.kk.trial;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by mehmetcanolgun on 3.02.2019.
 */

public class Database extends SQLiteOpenHelper {

    Database(Context context){
        super(context,"database",null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String konularCommand = "create table konular (sinav text, ders text, konu text, selected integer)";
        sqLiteDatabase.execSQL(konularCommand);
        int a = 0;
        Log.e("sizeout",""+TytFragment.dersler.size());
        for (int i = 0;i<TytFragment.dersler.size();i++) {
            for (int j = 0; j < TytFragment.num[i]; j++) {
                sqLiteDatabase.execSQL("insert into konular (sinav,ders,konu,selected) values ('tyt' , '" + TytFragment.dersler.get(i) + "','" + TytFragment.checkBoxes.get(a+j).getText() + "',0)");
                Log.e("","insert into konular (sinav,ders,konu,selected) values ('tyt' , '" + TytFragment.dersler.get(i) + "','" + TytFragment.checkBoxes.get(j).getText() + "',0)");
            }
            a += TytFragment.num[i];
        }
        a=0;
        Log.e("sizein",""+AytFragment.derslerAYT.size());
        for (int i=0; i<AytFragment.derslerAYT.size();i++){
            for (int j=0;j<AytFragment.nums[i];j++){
                Log.e("asd","içerde");
                sqLiteDatabase.execSQL("insert into konular (sinav,ders,konu,selected) values ('ayt' , '" + AytFragment.derslerAYT.get(i) + "','" + AytFragment.konular.get(a+j) + "',0)");
                Log.e("","insert into konular (sinav,ders,konu,selected) values ('ayt' , '" + AytFragment.derslerAYT.get(i) + "','" + AytFragment.konular.get(a+j) + "',0)");
            }
            a += AytFragment.nums[i];
        }

        String hedeflerCommand = "create table hedefler (gun integer, ders text, soru integer, sure integer, dersindex integer)";
        sqLiteDatabase.execSQL(hedeflerCommand);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exist konular");
    }
}
