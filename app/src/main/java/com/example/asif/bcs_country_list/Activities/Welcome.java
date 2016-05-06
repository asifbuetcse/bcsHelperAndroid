package com.example.asif.bcs_country_list.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.asif.bcs_country_list.Adapter.WelcomeCustomGridView;
import com.example.asif.bcs_country_list.AsyncTask.AsyncTaskUrlAccess;
import com.example.asif.bcs_country_list.Interface.AsyncResponse;
import com.example.asif.bcs_country_list.Model.Country;
import com.example.asif.bcs_country_list.Model.AdapterWelcome;
import com.example.asif.bcs_country_list.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Welcome extends AppCompatActivity implements AsyncResponse {

    AsyncTaskUrlAccess asyncTaskUrlAccess;
    public String result = null;
    GridView gridView;
    WelcomeCustomGridView welcomeCustomGridView;
    ArrayList<AdapterWelcome> gridArray;
    Intent myIntent;
    Country country;
    ArrayList<Country> countryCollection;
    String methodName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initialize();
        asyncTaskUrlAccess.execute(getString(R.string.urlToExecute));
        addItem();
        setAdapter();
    }

    private void setAdapter() {
        welcomeCustomGridView = new WelcomeCustomGridView(this, R.layout.welcome_row_grid, gridArray);
        gridView.setAdapter(welcomeCustomGridView);
        gridView.setOnItemClickListener(itemClickListener);
    }

    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (position != 0) {
                selectMethodName(position);
                myIntent = new Intent(Welcome.this, GenericActivity.class);
            } else {
                myIntent = new Intent(Welcome.this, Countries.class);
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("result", countryCollection);
            myIntent.putExtras(bundle);
            myIntent.putExtra("methodName", methodName);
            Welcome.this.startActivity(myIntent);
        }
    };

    @Override
    public void processFinish(String output)  {
        try {
            JSONArray jsonArray = new JSONArray(output);
            for(int i = 0; i < jsonArray.length(); i++)
            {
                JSONObject object = new JSONObject(jsonArray.getString(i));
                country = new Country();
                country.setName(object.getString("name"));
                country.setCapital(object.getString("capital"));
                country.setRegion(object.getString("region"));
                country.setCallingCodes(convertStringToArrayString(object.getString("callingCodes")));
                country.setPopulation(object.getLong("population"));
                country.setBorder(convertStringToArrayString(object.getString("borders")));
                country.setCurrencies(convertStringToArrayString(object.getString("currencies")));
                country.setLatLong(convertStringToArrayString(object.getString("latlng")));
                country.setLanguages(convertStringToArrayString(object.getString("languages")));
                countryCollection.add(country);
            }
        }
        catch (Exception e) {

        }

    }


    public String[] convertStringToArrayString(String input) {
        String[] output = null;
        try {
            JSONArray jsonArray = new JSONArray(input);
             output = new String[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); i++) {
                output[i] = jsonArray.getString(i);
            }

        }
        catch (Exception e) {

        }
        return output;
    }

    public void initialize() {
        asyncTaskUrlAccess = new AsyncTaskUrlAccess();
        gridArray = new ArrayList<AdapterWelcome>();
        asyncTaskUrlAccess.delegate = this;
        gridView = (GridView)findViewById(R.id.gridView);
        countryCollection = new ArrayList<Country>();
    }

    public void addItem() {
        gridArray.add(new AdapterWelcome("Country"));
        gridArray.add(new AdapterWelcome("Capital"));
        gridArray.add(new AdapterWelcome("Currency"));
        gridArray.add(new AdapterWelcome("Calling"));
        gridArray.add(new AdapterWelcome("Population"));
        gridArray.add(new AdapterWelcome("Lat-long"));
        gridArray.add(new AdapterWelcome("Border"));
        gridArray.add(new AdapterWelcome("Language"));
        gridArray.add(new AdapterWelcome("Quiz"));
    }

    public void selectMethodName(int position) {
        switch(position) {
            case 1:
                methodName = "capital";

                break;
            case 2:
                methodName = "currencies";
                break;
            case 3:
                methodName = "CallingCode";
                break;
            case 4:
                methodName = "population";
                break;
            case 5:
                methodName = "lat_lng";
                break;
            case 6:
                methodName = "borders";
                break;
            case 7:
                methodName = "languages";
                break;
            case 8:
                break;
            default:
                methodName = "none";
                break;
        }
    }
}
