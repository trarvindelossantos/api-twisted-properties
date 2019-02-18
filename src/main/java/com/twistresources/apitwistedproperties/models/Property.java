package com.twistresources.apitwistedproperties.models;

public class Property {

    private Integer id;

    public Property(String id) {
        this.id = Integer.parseInt(id);
    }

    public Integer getPropertyId() {
        return this.id;
    }

    public void setPropertyId(Integer id) {
        this.id = id;
    }
}
