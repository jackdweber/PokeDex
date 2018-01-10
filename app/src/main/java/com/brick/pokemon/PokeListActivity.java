package com.brick.pokemon;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class PokeListActivity extends AppCompatActivity {


    public static final String[] POKEDEX_COLUMNS = {
        "number", "name", "type", "total", "hp", "attack", "defense", "spattack", "spdefense", "speed"
    };


    private ListView pokeList;
    private dbHandler _db;
    private pokeCursor _cAdapter;
    private LinearLayout layout;

    private EditText searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_list);

        _db = new dbHandler(this);
        layout = (LinearLayout) findViewById(R.id.layout_activity_poke_list);

        pokeList = (ListView) findViewById(R.id.pokelist);
        searchBar = (EditText) findViewById(R.id.pk_search);

        loadFirst();

        searchListenerInit();

    }

    private void searchListenerInit(){
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0){
                    loadFirst();
                }
                else{
                    loadWithQuery(charSequence.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void loadFirst() {
        Cursor cr = _db.getAll();
        _cAdapter = new pokeCursor(this, cr, false);
        pokeList.setAdapter(_cAdapter);
    }

    public void loadWithQuery(String s){
        Cursor cr = _db.getWithQuery(s);
        _cAdapter = new pokeCursor(this, cr, false);
        pokeList.setAdapter(_cAdapter);
    }
}
