package com.example.asif.bcs_country_list;

import java.io.Serializable;

/**
 * Created by asif on 5/4/16.
 */
public class ModelCountry implements Serializable{
    String name;
    String capital;
    String region;
    long population;
    String[] latLong;
    String currencies;
    String callingCodes;
    String[] border;
    String[] languages;

    public ModelCountry() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String[] getLatLong() {
        return latLong;
    }

    public void setLatLong(String[] latLong) {
        this.latLong = latLong;
    }

    public String getCurrencies() {
        return currencies;
    }

    public void setCurrencies(String currencies) {
        this.currencies = currencies;
    }

    public String getCallingCodes() {
        return callingCodes;
    }

    public void setCallingCodes(String callingCodes) {
        this.callingCodes = callingCodes;
    }

    public String[] getBorder() {
        return border;
    }

    public void setBorder(String[] border) {
        this.border = border;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }
}
