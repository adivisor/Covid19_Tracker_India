package com.example.covid_19trackerindia;

public class CovidData {

    private String State;
    private String Confirmed;
    private String Active;
    private String Recovered;
    private String Death;
    private String lastUpdated;
    private String TodayDeath;
    private String TodayRecovered;
    private String TodayActive;


    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getConfirmed() {
        return Confirmed;
    }

    public void setConfirmed(String confirmed) {
        Confirmed = confirmed;
    }

    public String getActive() {
        return Active;
    }

    public void setActive(String active) {
        Active = active;
    }

    public String getRecovered() {
        return Recovered;
    }

    public void setRecovered(String recovered) {
        Recovered = recovered;
    }

    public String getDeath() {
        return Death;
    }

    public void setDeath(String death) {
        Death = death;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getTodayDeath() {
        return TodayDeath;
    }

    public void setTodayDeath(String todayDeath) {
        TodayDeath = todayDeath;
    }

    public String getTodayRecovered() {
        return TodayRecovered;
    }

    public void setTodayRecovered(String todayRecovered) {
        TodayRecovered = todayRecovered;
    }

    public String getTodayActive() {
        return TodayActive;
    }

    public void setTodayActive(String todayActive) {
        TodayActive = todayActive;
    }

    public CovidData(String state, String confirmed, String active, String recovered,
                     String death, String lastUpdated, String todayDeath, String todayRecovered,
                     String todayActive) {
        State = state;
        Confirmed = confirmed;
        Active = active;
        Recovered = recovered;
        Death = death;
        this.lastUpdated = lastUpdated;
        TodayDeath = todayDeath;
        TodayRecovered = todayRecovered;
        TodayActive = todayActive;
    }
}
