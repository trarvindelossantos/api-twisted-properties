package com.twistresources.apitwistedproperties.services;

import com.twistresources.apitwistedproperties.models.Property;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class PropertyService {

    RestTemplate propertyTemplate = new RestTemplate();
    private String uri = "https://rpgateway-uat.rpdata.com/bsg-au/v1/property/%s.json";

    public String show(String token, Property property) {
        String endpoint = String.format(uri,property.getPropertyId());

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Authorization", token);

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(endpoint)
                .queryParam("returnFields","saleList,forSalePropertyCampaignList,forRentPropertyCampaignList,attributes,developmentApplicationList,propertyPhotoList");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<String> response = propertyTemplate.exchange(
                builder.build().toUri(),
                HttpMethod.GET,
                entity,
                String.class
        );
        return response.getBody();
    }
}
