package com.twistresources.apitwistedproperties.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class SuggestionService {


    private String uri = "https://property-uat-api.corelogic.asia/bsg-au/v1/suggest.json";

    RestTemplate suggestionsTemplate = new RestTemplate();

    public String suggestions(String token, String search, String suggestion_type){

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Authorization", token);

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(uri)
                .queryParam("q", search)
                .queryParam("suggestionTypes", suggestion_type);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<String> response = suggestionsTemplate.exchange(
                builder.build().toUri(),
                HttpMethod.GET,
                entity,
                String.class
        );

        return response.getBody();
    }

}
