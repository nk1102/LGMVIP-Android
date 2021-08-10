package com.pandemic.cocases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

// adapter class
public class DataAdapter extends ArrayAdapter<Model> {
    private final Context context;
    private final List<Model> modelList;

    public DataAdapter(Context context, List<Model> modelList) {
        super(context, R.layout.covid_data, modelList);

        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.covid_data, null, true);


        TextView name = view.findViewById(R.id.textViewStateName);
        TextView total = view.findViewById(R.id.textViewTotalCasesTotal);
        TextView death = view.findViewById(R.id.textViewDeathCasesTotal);
        TextView cured = view.findViewById(R.id.textViewCuredCases);
        TextView active = view.findViewById(R.id.textViewActiveCases);
        TextView todayActive = view.findViewById(R.id.textViewNewActiveCases);
        TextView todayDeath = view.findViewById(R.id.textViewDeathCasesToday);
        TextView todayCured = view.findViewById(R.id.textViewCuredCasesToday);
        TextView todayIncrease = view.findViewById(R.id.textViewTotalCasesIncreaseToday);


        name.setText(modelList.get(position).getName());
        total.setText(modelList.get(position).getTotal());
        death.setText(modelList.get(position).getDeath());
        cured.setText(modelList.get(position).getRecovered());
        active.setText(modelList.get(position).getActive());
        todayActive.setText(modelList.get(position).getTodayActive());
        todayDeath.setText(modelList.get(position).getTodayDeaths());
        todayCured.setText(modelList.get(position).getTodayRecovered());


        return view;
    }
}
