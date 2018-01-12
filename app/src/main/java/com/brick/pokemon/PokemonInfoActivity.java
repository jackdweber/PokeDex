package com.brick.pokemon;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class PokemonInfoActivity extends AppCompatActivity {

    private String name;
    private dbHandler _db;
    private HashMap<String, String> dict = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_info);

        //Initialize the database handler and get it ready.

        _db = new dbHandler(this);

        //Get the name of the pokemon from extras.

        name = (String) getIntent().getExtras().get("name");

        //Go ahead and set the name of the pokemon

        TextView tv = findViewById(R.id.pk_info_name);
        tv.setText(name);

        //Get the data for that pokemon.

        String q = "select * from pokemon where name='" + name + "'";
        Cursor cursor = _db.getWithSpecificQuery(q);
        cursor.moveToFirst();
        dict.put("number", cursor.getString(cursor.getColumnIndex("number")));
        dict.put("name", cursor.getString(cursor.getColumnIndex("name")));
        dict.put("total", cursor.getString(cursor.getColumnIndex("total")));
        dict.put("type", cursor.getString(cursor.getColumnIndex("type")));
        dict.put("hp", cursor.getString(cursor.getColumnIndex("hp")));
        dict.put("attack", cursor.getString(cursor.getColumnIndex("attack")));
        dict.put("defense", cursor.getString(cursor.getColumnIndex("defense")));
        dict.put("spattack", cursor.getString(cursor.getColumnIndex("spattack")));
        dict.put("spdefense", cursor.getString(cursor.getColumnIndex("spdefense")));
        dict.put("speed", cursor.getString(cursor.getColumnIndex("speed")));

        //Set the textviews to display the info.

        tv = findViewById(R.id.pk_info_number);
        tv.setText(dict.get("number"));
        tv = findViewById(R.id.pk_info_type);
        tv.setText(dict.get("type"));
        tv = findViewById(R.id.pk_info_total);
        tv.setText(dict.get("total"));
        tv = findViewById(R.id.pk_info_hp);
        tv.setText(dict.get("hp"));
        tv = findViewById(R.id.pk_info_attack);
        tv.setText(dict.get("attack"));
        tv = findViewById(R.id.pk_info_defense);
        tv.setText(dict.get("defense"));
        tv = findViewById(R.id.pk_info_spattack);
        tv.setText(dict.get("spattack"));
        tv = findViewById(R.id.pk_info_spdefense);
        tv.setText(dict.get("spdefense"));
        tv = findViewById(R.id.pk_info_speed);
        tv.setText(dict.get("speed"));

        //Set the image to the correct pokemon.

        String item = "poke_" + dict.get("number");
        int img_id = getResources().getIdentifier(item, "drawable", getPackageName());
        Log.e(item, Integer.toString(img_id));
        ImageView iv = findViewById(R.id.pk_info_img);
        iv.setImageDrawable(getResources().getDrawable(img_id));

    }
}
