package com.example.asif.bcs_country_list.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.asif.bcs_country_list.Adapter.CountriesExpandableListView;
import com.example.asif.bcs_country_list.Model.Country;
import com.example.asif.bcs_country_list.R;

import java.util.ArrayList;

public class Countries extends AppCompatActivity {


    TextView textView;
    ArrayList<Country> models;
    ExpandableListView expListView;
    CountriesExpandableListView listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        models = (ArrayList<Country>)bundle.getSerializable("result");

        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        listAdapter = new CountriesExpandableListView(this, models);

        expListView.setAdapter(listAdapter);
    }

}
