package com.example.covid_19trackerindia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<CovidData> CovidDataArrayList;
    private TextView dailyConfirm, dailyDeaths, dailyReco, totalDeath, totalConfirm,
            totalRecovered, dateHeaders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dailyConfirm = findViewById(R.id.dailyConfirmed);
        dailyDeaths = findViewById(R.id.dailyDeath);
        dailyReco = findViewById(R.id.dailyRecovered);
        totalDeath = findViewById(R.id.totalDeath);
        totalConfirm = findViewById(R.id.totalConfirmed);
        totalRecovered = findViewById(R.id.totalRecovered);
        dateHeaders = findViewById(R.id.dateHeader);

        RecyclerView recyclerView = findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CovidDataArrayList = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        jsonParse();

    }

    private void jsonParse() {

    String url = "https://api.covid19india.org/data.json";

    JsonObjectRequest request = new
            JsonObjectRequest(Request.Method.GET, url, null ,new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    try {

                        JSONArray todayAndTotalDataArray = response.getJSONArray("statewise");
                        JSONObject todayAndTotalDataJsonObject = todayAndTotalDataArray.getJSONObject(0);

                        // For Header Linear Layout

                        String dailyConfirmed = todayAndTotalDataJsonObject.getString("deltaconfirmed");
                        String dailyRec = todayAndTotalDataJsonObject.getString("deltarecovered");
                        String dailyDeath = todayAndTotalDataJsonObject.getString("deltadeaths");
                        String dataHeader = todayAndTotalDataJsonObject.getString("lastupdatedtime").substring(0, 5);

                        dataHeader = getFormattedDate(dataHeader);

                        dailyConfirm.setText(dailyConfirmed);
                        dailyReco.setText(dailyRec);
                        dailyDeaths.setText(dailyDeath);
                        dateHeaders.setText(dataHeader);


                        // For Statewise Info

                        String totalConfirmedFetched = todayAndTotalDataJsonObject.getString("confirmed");
                        String totalRecoveredFetched = todayAndTotalDataJsonObject.getString("recovered");
                        String totalDeathsFetched = todayAndTotalDataJsonObject.getString("deaths");

                        totalConfirm.setText(totalConfirmedFetched);
                        totalRecovered.setText(totalRecoveredFetched);
                        totalDeath.setText(totalDeathsFetched);

                        for (int i = 1; i < todayAndTotalDataArray.length(); i++) {

                            JSONObject stateWiseArrauJSONObject = todayAndTotalDataArray.getJSONObject(i);
                            String state = stateWiseArrauJSONObject.getString("state");
                            String confirmed = stateWiseArrauJSONObject.getString("confirmed");
                            String active = stateWiseArrauJSONObject.getString("active");
                            String recovered = stateWiseArrauJSONObject.getString("recovered");
                            String death = stateWiseArrauJSONObject.getString("deaths");
                            String lastUpdated = stateWiseArrauJSONObject.getString("lastupdatedtime");


                            String todayActive = stateWiseArrauJSONObject.getString("deltaconfirmed");
                            String todayRecovered = stateWiseArrauJSONObject.getString("deltarecovered");
                            String todayDeath = stateWiseArrauJSONObject.getString("deltadeaths");

                            CovidData covidData = new CovidData(state, confirmed, active, recovered,
                                    death, lastUpdated, todayActive, todayRecovered, todayDeath);
                            CovidDataArrayList.add(covidData);

                        }

                        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, CovidDataArrayList);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }

            );

    }

    private String getFormattedDate(String dateHeader){

        switch (dateHeader.substring(3,5)) {

            case "01":
                return dateHeader.substring(0,2) + " Jan";
            case "02":
                return dateHeader.substring(0,2) + " Feb";
            case "03":
                return dateHeader.substring(0,2) + " Mar";
            case "04":
                return dateHeader.substring(0,2) + " Apr";
            case "05":
                return dateHeader.substring(0,2) + " May";
            case "06":
                return dateHeader.substring(0,2) + " Jun";
            case "07":
                return dateHeader.substring(0,2) + " Jul";
            case "08":
                return dateHeader.substring(0,2) + " Aug";
            case "09":
                return dateHeader.substring(0,2) + " Sep";
            case "10":
                return dateHeader.substring(0,2) + " Oct";
            case "11":
                return dateHeader.substring(0,2) + " Nov";
            case "12":
                return dateHeader.substring(0,2) + " Dec";
            default:
                return null;

        }

    }

}

