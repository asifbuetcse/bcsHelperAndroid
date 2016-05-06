package com.example.asif.bcs_country_list;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by asif on 5/3/16.
 */




public class AdapterWelcomeCustomGridView extends ArrayAdapter<ModelAdapterWelcome> {
    Context context;
    int layoutResourceId;
    ArrayList<ModelAdapterWelcome> data = new ArrayList<ModelAdapterWelcome>();

    public AdapterWelcomeCustomGridView(Context context, int layoutResourceId,
                                        ArrayList<ModelAdapterWelcome> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RecordHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new RecordHolder();
            holder.txtTitle = (TextView) row.findViewById(R.id.item_text);
            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }

        ModelAdapterWelcome item = data.get(position);
        holder.txtTitle.setText(item.getName());
        return row;

    }

    static class RecordHolder {
        TextView txtTitle;
    }
}
