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

    void changeState(String konu, boolean state){
        int a = 0;
        if (state){
            a = 1;
        }
        String command = "update konular set selected = "+String.valueOf(a)+" where konu = '"+konu+"'";
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
        for (int i=0;i<c.getCount();i++){
            //while(!c.isAfterLast()){
            int item = c.getInt(0);
            list.add(item);
            c.moveToNext();
        }
        c.close();
        return list;
    }

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
