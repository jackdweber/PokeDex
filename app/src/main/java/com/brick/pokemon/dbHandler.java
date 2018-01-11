package com.brick.pokemon;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by jack on 1/7/18.
 */

public class dbHandler extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "pokedex.db";
    private static final int DATABASE_VERSION = 3;

    public dbHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        setForcedUpgrade();
    }

    public Cursor getAll(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select * from pokemon", null);
    }

    public Cursor getWithQuery(String s){
        SQLiteDatabase db = this.getReadableDatabase();
        String q = "select * from pokemon where name like '" + s + "%'";
        return db.rawQuery(q, null);
    }

    public Cursor getWithSpecificQuery(String s){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(s, null);
    }

}
