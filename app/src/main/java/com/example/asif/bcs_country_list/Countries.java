package com.example.asif.bcs_country_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Countries extends AppCompatActivity {


    TextView textView;
    ArrayList<ModelCountry> models;
    ExpandableListView expListView;
    AdapterCountriesExpandableListView listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        models = (ArrayList<ModelCountry>)bundle.getSerializable("result");

        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        listAdapter = new AdapterCountriesExpandableListView(this, models);

        expListView.setAdapter(listAdapter);
    }

}
