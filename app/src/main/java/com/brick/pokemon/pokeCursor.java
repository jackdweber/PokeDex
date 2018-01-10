package com.brick.pokemon;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by jack on 1/7/18.
 */

public class pokeCursor extends CursorAdapter {

    public pokeCursor(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.pokemon_list_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView pk_number = (TextView) view.findViewById(R.id.pk_number);
        TextView pk_name = (TextView) view.findViewById(R.id.pk_name);
        TextView pk_type = (TextView) view.findViewById(R.id.pk_type);

        pk_number.setText(cursor.getString(cursor.getColumnIndex("number")));
        pk_name.setText(cursor.getString(cursor.getColumnIndex("name")));
        pk_type.setText(cursor.getString(cursor.getColumnIndex("average")));


    }
}
