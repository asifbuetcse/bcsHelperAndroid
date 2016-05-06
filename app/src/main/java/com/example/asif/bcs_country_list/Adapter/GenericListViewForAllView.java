package com.example.asif.bcs_country_list.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.asif.bcs_country_list.Model.Country;
import com.example.asif.bcs_country_list.Model.ViewHolder;
import com.example.asif.bcs_country_list.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by root on 5/18/16.
 */
public class GenericListViewForAllView extends BaseAdapter {
    Context context;
    ArrayList<Country> modelCountries;
    TextView name;
    TextView details;
    String methodName;

    public GenericListViewForAllView(Context context, ArrayList<Country> modelCountries, String methodName) {
        this.context = context;
        this.modelCountries = modelCountries;
        this.methodName = methodName;
    }
    @Override
    public int getCount() {
        return modelCountries.size();
    }

    @Override
    public Object getItem(int position) {
        return modelCountries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.generic_list_row, null);

            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.details = (TextView)convertView.findViewById(R.id.details);
            convertView.setTag(viewHolder);
        }

        else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        Country country = modelCountries.get(position);
        viewHolder.name.setText(country.getName());
        viewHolder.details.setText(getDetails(country, methodName));
        return convertView;
    }

    public String getDetails(Country country, String methodName) {
        switch (methodName) {
            case "capital":
                return country.getCapital();
            case "CallingCode":
                return Arrays.toString(country.getCallingCodes()).replaceAll("\\[|\\]", "");
            case "lat_lng":
                return Arrays.toString(country.getLatLong()).replaceAll("\\[|\\]", "");
            case "currencies":
                return Arrays.toString(country.getCurrencies()).replaceAll("\\[|\\]", "");
            case "population":
                return Long.toString(country.getPopulation());
            case "borders":
                return Arrays.toString(country.getBorder()).replaceAll("\\[|\\]", "");
            case "languages":
                return Arrays.toString(country.getLanguages()).replaceAll("\\[|\\]", "");
            default:
                return "none";
        }
    }


}
