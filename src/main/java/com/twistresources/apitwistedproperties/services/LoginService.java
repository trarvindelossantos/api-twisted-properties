package com.twistresources.apitwistedproperties.services;

import com.twistresources.apitwistedproperties.models.Login;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class LoginService {

    private final String uri = "https://access-uat-api.corelogic.asia/access/oauth/token";
    RestTemplate loginTemplate = new RestTemplate();



    public Object auth() {
        //get login credentials
        Login credentials = new Login();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);


        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri)
                .queryParam("grant_type", credentials.getGrant_type())
                .queryParam("client_id", credentials.getClient_id())
                .queryParam("client_secret", credentials.getClient_secret());

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<String> response = loginTemplate.exchange(
                builder.build().toUri(),
                HttpMethod.GET,
                entity,
                String.class
        );

        return response.getBody();
    }
}
