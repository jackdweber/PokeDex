package com.brick.pokemon;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by jack on 1/7/18.
 */

public class pokeCursor extends CursorAdapter {

    private HashMap<String, String> dict = new HashMap<>();

    public pokeCursor(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.pokemon_list_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        dict.put("number", cursor.getString(cursor.getColumnIndex("number")));
        dict.put("name", cursor.getString(cursor.getColumnIndex("name")));
        dict.put("type", cursor.getString(cursor.getColumnIndex("type")));
        dict.put("hp", cursor.getString(cursor.getColumnIndex("hp")));
        dict.put("attack", cursor.getString(cursor.getColumnIndex("attack")));
        dict.put("defense", cursor.getString(cursor.getColumnIndex("defense")));
        dict.put("spattack", cursor.getString(cursor.getColumnIndex("spattack")));
        dict.put("spdefense", cursor.getString(cursor.getColumnIndex("spdefense")));
        dict.put("speed", cursor.getString(cursor.getColumnIndex("speed")));

        TextView pk_number = (TextView) view.findViewById(R.id.pk_number);
        TextView pk_name = (TextView) view.findViewById(R.id.pk_name);
        TextView pk_type = (TextView) view.findViewById(R.id.pk_type);

        pk_number.setText(dict.get("number"));
        pk_name.setText(dict.get("name"));
        pk_type.setText(dict.get("type"));
    }

    public HashMap<String, String> getDict(){
        return dict;
    };

}
