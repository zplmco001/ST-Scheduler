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

    List<Integer> getState(){
        String columns[] = {"selected"};
        Cursor c = sqLiteDatabase.query("konular",columns,null,null,null,null,null);
        List<Integer> list = new ArrayList<Integer>();
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
}
