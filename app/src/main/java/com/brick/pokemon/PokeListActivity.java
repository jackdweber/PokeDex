package com.brick.pokemon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

public class PokeListActivity extends AppCompatActivity {

    private ListView pokeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_list);

        pokeList = (ListView) findViewById(R.id.pokelist);

        

    }
}
