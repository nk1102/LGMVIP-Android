package com.pandemic.cocases;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public static List<Model> modelList = new ArrayList<>();
    ListView listView;
    Model model;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        fetchData();

    }

    private void fetchData() {
        // The Link Through Which We Can Fetch Data
        String url = "https://api.covid19india.org/state_district_wise.json";

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    // Creating JSON Object for fetching the data
                    JSONObject object = new JSONObject(response);

                    // From that object we are fetching data from the above API using volley
                    JSONObject object1 = object.getJSONObject("West Bengal");
                    JSONObject object2 = object1.getJSONObject("districtData");
                    JSONObject object3 = object2.getJSONObject("Alipurduar");
                    JSONObject object4 = object3.getJSONObject("delta");


                    String active = object3.getString("active");
                    String confirmed = object3.getString("confirmed");
                    String deceased = object3.getString("deceased");
                    String recovered = object3.getString("recovered");

                    String todayActive = object4.getString("confirmed");
                    String todayDeath = object4.getString("deceased");
                    String todayCured = object4.getString("recovered");

                    model = new Model("Alipurduar", confirmed, deceased, recovered, active,
                            todayActive, todayDeath, todayCured);

                    modelList.add(model);


                    object3 = object2.getJSONObject("Bankura");

                    active = object3.getString("active");
                    confirmed = object3.getString("confirmed");
                    deceased = object3.getString("deceased");
                    recovered = object3.getString("recovered");
                    object4 = object3.getJSONObject("delta");
                    todayActive = object4.getString("confirmed");
                    todayDeath = object4.getString("deceased");
                    todayCured = object4.getString("recovered");

                    model = new Model("Bankura", confirmed, deceased, recovered, active,
                            todayActive, todayDeath, todayCured);

                    modelList.add(model);


                    object3 = object2.getJSONObject("Cooch Behar");


                    active = object3.getString("active");
                    confirmed = object3.getString("confirmed");
                    deceased = object3.getString("deceased");
                    recovered = object3.getString("recovered");
                    object4 = object3.getJSONObject("delta");

                    todayActive = object4.getString("confirmed");
                    todayDeath = object4.getString("deceased");
                    todayCured = object4.getString("recovered");

                    model = new Model("Cooch Behar", confirmed, deceased, recovered, active,
                            todayActive, todayDeath, todayCured);

                    modelList.add(model);

                    object3 = object2.getJSONObject("Darjeeling");


                    active = object3.getString("active");
                    confirmed = object3.getString("confirmed");
                    deceased = object3.getString("deceased");
                    recovered = object3.getString("recovered");
                    object4 = object3.getJSONObject("delta");

                    todayDeath = object4.getString("deceased");
                    todayCured = object4.getString("recovered");
                    todayActive = object4.getString("confirmed");

                    model = new Model("Darjeeling", confirmed, deceased, recovered, active,
                            todayActive, todayDeath, todayCured);

                    modelList.add(model);


                    object3 = object2.getJSONObject("Howrah");


                    active = object3.getString("active");
                    confirmed = object3.getString("confirmed");
                    deceased = object3.getString("deceased");
                    recovered = object3.getString("recovered");
                    object4 = object3.getJSONObject("delta");
                    todayActive = object4.getString("confirmed");
                    todayDeath = object4.getString("deceased");
                    todayCured = object4.getString("recovered");

                    model = new Model("Howrah", confirmed, deceased, recovered, active,
                            todayActive, todayDeath, todayCured);

                    modelList.add(model);

                    adapter = new DataAdapter(MainActivity.this, modelList);
                    listView.setAdapter((ListAdapter) adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

}