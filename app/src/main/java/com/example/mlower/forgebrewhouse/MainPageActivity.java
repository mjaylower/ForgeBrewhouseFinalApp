package com.example.mlower.forgebrewhouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainPageActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView bomberList;
    ListView tapList;
    String[] bomber;
    String[] tap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main_page);
        Objects.requireNonNull (getSupportActionBar ()).setDisplayShowHomeEnabled (true);
        getSupportActionBar ().setLogo (R.mipmap.ic_launcher);
        getSupportActionBar ().setDisplayUseLogoEnabled (true);

        bomberList = findViewById (R.id.bomberToGoList);
        tapList = findViewById (R.id.tapList);

        bomber = getResources ().getStringArray (R.array.bomberList);
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<> (this, android.R.layout.simple_list_item_1, bomber);

        tap = getResources ().getStringArray (R.array.tapList);
        ArrayAdapter<String> arrayAdapter2= new ArrayAdapter<> (this, android.R.layout.simple_list_item_1, tap);
        bomberList.setAdapter (arrayAdapter);
        bomberList.setOnItemClickListener(this);
        tapList.setAdapter(arrayAdapter2);
        tapList.setOnItemClickListener (this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tv=(TextView)view;
        Toast.makeText (this, "You clicked on" + tv.getText (), Toast.LENGTH_SHORT).show();
    }
}
