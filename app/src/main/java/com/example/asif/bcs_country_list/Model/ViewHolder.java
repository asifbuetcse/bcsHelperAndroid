package com.example.asif.bcs_country_list.Model;

import android.view.View;
import android.widget.TextView;

/**
 * Created by asif on 5/19/16.
 */
public class ViewHolder {
    public TextView name;
    public TextView details;

    public ViewHolder() {

    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public TextView getDetails() {
        return details;
    }

    public void setDetails(TextView details) {
        this.details = details;
    }
}
