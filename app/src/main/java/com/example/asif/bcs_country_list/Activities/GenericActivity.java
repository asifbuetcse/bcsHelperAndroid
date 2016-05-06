package com.example.asif.bcs_country_list.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.asif.bcs_country_list.Adapter.GenericListViewForAllView;
import com.example.asif.bcs_country_list.Model.Country;
import com.example.asif.bcs_country_list.R;

import java.util.ArrayList;

public class GenericActivity extends AppCompatActivity {
    ArrayList<Country> models;
    ListView listView;
    GenericListViewForAllView listViewAdapterForAllView;
    String methodName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic);


        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        methodName = intent.getStringExtra("methodName");
        setTitle(methodName);
        listView = (ListView)findViewById(R.id.listViewGeneric);

        models = (ArrayList<Country>)bundle.getSerializable("result");
        listViewAdapterForAllView = new GenericListViewForAllView(this, models, methodName);
        listView.setAdapter(listViewAdapterForAllView);
    }

}
