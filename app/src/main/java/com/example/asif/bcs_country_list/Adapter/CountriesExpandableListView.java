package com.example.asif.bcs_country_list.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.asif.bcs_country_list.Model.Country;
import com.example.asif.bcs_country_list.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by asif on 5/6/16.
 */
public class CountriesExpandableListView extends BaseExpandableListAdapter{

    private Context context;
    private List<String> listDataheader;
    private ArrayList<Country> listDataChild;

    public CountriesExpandableListView(Context context, ArrayList<Country> listDataChild) {
        this.context = context;
        this.listDataChild = listDataChild;
        List<String> tempHeader = new ArrayList<String>();
        for (int i = 0; i < listDataChild.size(); i++) tempHeader.add(listDataChild.get(i).getName());
        this.listDataheader = tempHeader;
    }
    @Override
    public int getGroupCount() {
        return this.listDataheader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listDataheader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listDataChild.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.countries_list_group, null);
        }
        TextView lblListHeader = (TextView)convertView.findViewById(R.id.lblListHeader);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final Country child = (Country) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.countries_list_item, null);
        }
        TextView txtListChildCapital = (TextView) convertView.findViewById(R.id.lblListItemForCapital);
        TextView txtListChildCurrency = (TextView) convertView.findViewById(R.id.lblListItemForCurrency);
        TextView txtListChildPopulation = (TextView) convertView.findViewById(R.id.lblListItemForPopulation);
        TextView txtListChildLanguage = (TextView) convertView.findViewById(R.id.lblListItemForLanguage);
        txtListChildCapital.setText("Capital: " + child.getCapital());
        txtListChildCurrency.setText("Currency: " + Arrays.toString(child.getCurrencies()).replaceAll("\\[|\\]", ""));
        txtListChildPopulation.setText("Population: " + child.getPopulation());
        txtListChildLanguage.setText("Language: " + Arrays.toString(child.getLanguages()).replaceAll("\\[|\\]", ""));

        return  convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
