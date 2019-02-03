package com.trial.kk.trial;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
        String command = "update konular set 'selected' = "+String.valueOf(a)+" where 'konu' = "+konu;
    }
}
