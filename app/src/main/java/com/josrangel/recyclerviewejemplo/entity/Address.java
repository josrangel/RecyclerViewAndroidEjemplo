package com.josrangel.recyclerviewejemplo.entity;

import org.json.JSONObject;

public class Address {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    Address(JSONObject jsonObject){
        try{
            street= jsonObject.getString("street");
            suite= jsonObject.getString("suite");
            city= jsonObject.getString("city");
            zipcode= jsonObject.getString("zipcode");
            geo= new Geo(jsonObject.getJSONObject("geo"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}
