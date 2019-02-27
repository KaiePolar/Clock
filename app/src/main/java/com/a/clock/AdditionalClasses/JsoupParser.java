package com.a.clock.AdditionalClasses;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.a.clock.Interfaces.Presenter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class JsoupParser extends AsyncTask<String, Integer, String> {

    public ArrayList<String> timesList;
    public ArrayList<String> namesList;
    private Context context;
    private Elements citiesTimes;
    private Elements citiesNames;
    private Presenter presenter;

    public JsoupParser(Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            Log.d("TAG", "started");
            this.namesList = new ArrayList<>();
            this.timesList = new ArrayList<>();

            Document doc = Jsoup.connect("https://www.timeanddate.com/worldclock/").timeout(0).get();
            citiesTimes = doc.select("td.rbi");
            citiesNames = doc.select("td > a");
            Log.d("TAG", citiesNames.text());
            Log.d("TAG", citiesTimes.text());
            for (Element element : citiesNames) {
                this.namesList.add(element.text());
            }

            for (Element element : citiesTimes) {
                this.timesList.add(element.text());
            }
            Log.d("TAG", "finished");


        } catch (IOException e) {
            e.printStackTrace();
            Log.d("TAG", "catched");
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d("TAG", "onpostexecute");
        presenter.returnListForAdapter(namesList, timesList);
    }


    public synchronized ArrayList<String> getTimeResults() {
        return timesList;
    }

    public synchronized ArrayList<String> getNameResults() {
        return namesList;
    }

}
