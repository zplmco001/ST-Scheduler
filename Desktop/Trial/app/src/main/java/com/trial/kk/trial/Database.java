package com.trial.kk.trial;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mehmetcanolgun on 3.02.2019.
 */

public class Database extends SQLiteOpenHelper {

    Database(Context context){
        super(context,"database",null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String command = "create table konular (sinav text, ders text, konu, text, selected integer)";
        sqLiteDatabase.execSQL(command);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exist konular");
    }
}
