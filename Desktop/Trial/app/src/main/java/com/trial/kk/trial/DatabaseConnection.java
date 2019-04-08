package com.trial.kk.trial;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mehmetcanolgun on 3.02.2019.
 */

public class DatabaseConnection {

    private SQLiteDatabase sqLiteDatabase;
    private Database database;

    DatabaseConnection(Context context){
        database = new Database(context);
    }

    void open(){
        sqLiteDatabase = database.getWritableDatabase();
    }

    void  close(){
        database.close();
    }

    void changeState(String konu, String sinav, boolean state){
        int a = 0;
        if (state){
            a = 1;
        }
        String command = "update konular set selected = "+String.valueOf(a)+" where konu = '"+konu+"' and sinav = '"+sinav+"'";
        Log.e("cmd",command);
        sqLiteDatabase.execSQL(command);
    }

    void hedefEkle(int gun, String ders, int soru, int sure, int dersindex){
        String cmd = "insert into hedefler (gun, ders, soru , sure, dersindex) values ('"+gun+"','"+ders+"',"+String.valueOf(soru)+
                ","+String.valueOf(sure)+","+String.valueOf(dersindex)+")";
        sqLiteDatabase.execSQL(cmd);
    }

    List<Integer> getState(){
        String columns[] = {"selected"};
        Cursor c = sqLiteDatabase.query("konular",columns,null,null,null,null,null);
        List<Integer> list = new ArrayList<>();
        c.moveToFirst();
        Log.e("size",""+c.getCount());
        for (int i=0;i<c.getCount();i++){
            //while(!c.isAfterLast()){
            int item = c.getInt(0);
            list.add(item);
            c.moveToNext();
        }
        c.close();
        return list;
    }

    void initializeKonular(){
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
    }

   /* void printList(){
        String columns[] = {"konu","selected"};
        Cursor c = sqLiteDatabase.query("konular",columns,null,null,null,null,null);
        c.moveToFirst();
        for (int i=0;i<c.getCount();i++){
            Log.e(c.getString(c.getColumnIndex("konu")),c.getString(c.getColumnIndex("selected"))+i);
            c.moveToNext();
        }
    }*/

    List<NewPostit> hedefAl(){
        String columns[] = {"gun", "ders", "soru" , "sure", "dersindex"};
        Cursor c = sqLiteDatabase.query("hedefler", columns,null,null,null,null,null);
        List<NewPostit> list = new ArrayList<>();
        c.moveToFirst();
        for (int i=0;i<c.getCount();i++){

            int gun = c.getInt(c.getColumnIndex("gun"));
            String ders = c.getString(c.getColumnIndex("ders"));
            int soru = c.getInt(c.getColumnIndex("soru"));
            int sure = c.getInt(c.getColumnIndex("sure"));
            int index = c.getInt(c.getColumnIndex("dersindex"));

            list.add(new NewPostit(gun,ders,soru,sure,index));
            c.moveToNext();

        }
        c.close();
        return list;
    }

    void hedefSil(String ders, int gun, String miktar, String tip){
        String command = "";
        if (tip.equals("soru")){
            command = "delete from hedefler where ders = '"+ders+"' and gun = '"+gun+"' and soru = '"+miktar+"'";
        }else{
            command = "delete from hedefler where ders = '"+ders+"' and gun = '"+gun+"'and sure = '"+miktar+"'";
        }
        sqLiteDatabase.execSQL(command);

    }


}
