package com.josrangel.recyclerviewejemplo.entity;

import org.json.JSONObject;

public class Company {
    private String name;
    private String catchPhrase;
    private String bs;

    Company(JSONObject jsonObject){
        try{
            name= jsonObject.getString("name");
            catchPhrase= jsonObject.getString("catchPhrase");
            bs= jsonObject.getString("bs");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }
}
