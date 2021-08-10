package com.pandemic.cocases;

public class Model {
    // data we require to fetch the Data


    private String name, total, death, recovered, active, todayActive, todayDeaths, todayRecovered;

    public Model(String name, String total, String death, String recovered, String active, String todayActive, String todayDeaths, String todayRecovered) {
        this.name = name;
        this.total = total;
        this.death = death;
        this.recovered = recovered;
        this.active = active;
        this.todayActive = todayActive;
        this.todayDeaths = todayDeaths;
        this.todayRecovered = todayRecovered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getTodayActive() {
        return todayActive;
    }

    public void setTodayActive(String todayActive) {
        this.todayActive = todayActive;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public String getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(String todayRecovered) {
        this.todayRecovered = todayRecovered;
    }
}