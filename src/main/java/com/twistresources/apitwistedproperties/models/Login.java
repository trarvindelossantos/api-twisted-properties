package com.twistresources.apitwistedproperties.models;

import org.springframework.beans.factory.annotation.Value;

public class Login {


    private String grant_type = "client_credentials";


    private String client_id ="51983d36";


    private String client_secret = "8fff537e7571e19222649868ecf22018";

    public String getGrant_type() {
        return grant_type;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }


}
