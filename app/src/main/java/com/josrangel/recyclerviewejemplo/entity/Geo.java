package com.josrangel.recyclerviewejemplo.entity;

import org.json.JSONObject;

public class Geo {
    private String lat;
    private String lng;

    Geo(JSONObject jsonObject){
        try{
            lat= jsonObject.getString("lat");
            lng= jsonObject.getString("lng");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
