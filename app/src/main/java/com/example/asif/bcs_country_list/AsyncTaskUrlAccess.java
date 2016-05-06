package com.example.asif.bcs_country_list;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by asif on 5/3/16.
 */
public class AsyncTaskUrlAccess extends AsyncTask<String, Integer, String> {

    public InterfaceAsyncResponse delegate = null;
    @Override
    protected String doInBackground(String... params) {
        String urlString = params[0];
        String result = null;
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(urlConnection.getInputStream())));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
            result = stringBuilder.toString();

        }
        catch (Exception e) {

        }
        return result;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String result) {
        delegate.processFinish(result);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
}
