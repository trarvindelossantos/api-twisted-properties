package com.twistresources.apitwistedproperties.models;

public class Suggestion {

    private String q;
    private String type = "address";

    public Suggestion(String q) {
        this.q = q;
    }

    public String getSearch() {
        return this.q;
    }

    public void setSearch(String search) {
        this.q = search;
    }

    public String getType(){
        return this.type;
    }
}
