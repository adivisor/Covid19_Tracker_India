package com.example.covid_19trackerindia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>{

    private Context context;
    private ArrayList<CovidData> covidDataArrayList;

    public RecyclerViewAdapter(Context context, ArrayList<CovidData> covidDataArrayList) {
        this.context = context;
        this.covidDataArrayList = covidDataArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.news_items,parent,
                false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.RecyclerViewHolder holder, int position) {

        CovidData covidData = covidDataArrayList.get(position);
        String state = covidData.getState();
        String confirmed = covidData.getConfirmed();
        String active = covidData.getActive();
        String recovered = covidData.getRecovered();
        String death = covidData.getDeath();
        String lastUpdt = covidData.getLastUpdated();
        String todayActive = covidData.getTodayActive();
        String todayRecovered = covidData.getTodayRecovered();
        String todayDeath = covidData.getTodayDeath();

        holder.state.setText(state);
        holder.confirmed.setText(confirmed);
        holder.active.setText(active);
        holder.recovered.setText(recovered);
        holder.death.setText(death);
        holder.lastUpdate.setText(lastUpdt);
        holder.todayActive.setText(String.format("(%s)",todayActive));
        holder.todayRecovered.setText(String.format("(%s)",todayRecovered));
        holder.todayDeath.setText(String.format("(%s)",todayDeath));

    }

    @Override
    public int getItemCount() {
        return covidDataArrayList.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView state, confirmed, active, recovered, death, lastUpdate, todayDeath,
                todayActive, todayRecovered;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            state = itemView.findViewById(R.id.stateName);
            confirmed = itemView.findViewById(R.id.confirmed);
            active = itemView.findViewById(R.id.active);
            recovered = itemView.findViewById(R.id.recovered);
            death = itemView.findViewById(R.id.death);
            lastUpdate = itemView.findViewById(R.id.lastUpdated);
            todayActive = itemView.findViewById(R.id.todayActive);
            todayRecovered = itemView.findViewById(R.id.todayRecovered);
            todayDeath = itemView.findViewById(R.id.todayDeath);

        }
    }
}
