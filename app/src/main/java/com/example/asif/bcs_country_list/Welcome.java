package com.example.asif.bcs_country_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Welcome extends AppCompatActivity implements InterfaceAsyncResponse {

    AsyncTaskUrlAccess asyncTaskUrlAccess;
    public String result = null;
    GridView gridView;
    AdapterWelcomeCustomGridView adapterWelcomeCustomGridView;
    ArrayList<ModelAdapterWelcome> gridArray;
    Intent myIntent;
    ModelCountry modelCountry;
    ArrayList<ModelCountry> countryCollection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initialize();
        asyncTaskUrlAccess.execute("https://restcountries.eu/rest/v1/all");
        addItem();

        adapterWelcomeCustomGridView = new AdapterWelcomeCustomGridView(this, R.layout.welcome_row_grid, gridArray);
        gridView.setAdapter(adapterWelcomeCustomGridView);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectActivity(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("result", countryCollection);
                myIntent.putExtras(bundle);
                Welcome.this.startActivity(myIntent);
            }
        });

    }

    @Override
    public void processFinish(String output)  {
        try {
            JSONArray jsonArray = new JSONArray(output);
            for(int i = 0; i < jsonArray.length(); i++)
            {
                JSONObject object = new JSONObject(jsonArray.getString(i));
                modelCountry = new ModelCountry();
                modelCountry.setName(object.getString("name"));
                modelCountry.setCapital(object.getString("capital"));
                countryCollection.add(modelCountry);
            }
        }
        catch (Exception e) {

        }

    }

    public void initialize() {
        asyncTaskUrlAccess = new AsyncTaskUrlAccess();
        gridArray = new ArrayList<ModelAdapterWelcome>();
        asyncTaskUrlAccess.delegate = this;
        gridView = (GridView)findViewById(R.id.gridView);
        countryCollection = new ArrayList<ModelCountry>();
    }

    public void addItem() {
        gridArray.add(new ModelAdapterWelcome("Country"));
        gridArray.add(new ModelAdapterWelcome("Capital"));
        gridArray.add(new ModelAdapterWelcome("Currency"));
        gridArray.add(new ModelAdapterWelcome("Calling"));
        gridArray.add(new ModelAdapterWelcome("Population"));
        gridArray.add(new ModelAdapterWelcome("Lat-long"));
        gridArray.add(new ModelAdapterWelcome("Border"));
        gridArray.add(new ModelAdapterWelcome("Language"));
        gridArray.add(new ModelAdapterWelcome("Quiz"));
    }

    public void selectActivity(int position) {
        switch(position) {
            case 0:
                myIntent = new Intent(Welcome.this, Countries.class);
                break;
            case 1:
                myIntent = new Intent(Welcome.this, Capitals.class);
                break;
            case 2:
                myIntent = new Intent(Welcome.this, Currencies.class);
                break;
            case 3:
                myIntent = new Intent(Welcome.this, CallingCodes.class);
                break;
            case 4:
                myIntent = new Intent(Welcome.this, Population.class);
                break;
            case 5:
                myIntent = new Intent(Welcome.this, Lat_long.class);
                break;
            case 6:
                myIntent = new Intent(Welcome.this, Borders.class);
                break;
            case 7:
                myIntent = new Intent(Welcome.this, Languages.class);
                break;
            case 8:
                myIntent = new Intent(Welcome.this, Quiz.class);
                break;
            default:
                myIntent = new Intent(Welcome.this, Welcome.class);
        }
    }
}
