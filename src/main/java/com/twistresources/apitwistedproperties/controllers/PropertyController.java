package com.twistresources.apitwistedproperties.controllers;

import com.twistresources.apitwistedproperties.models.Property;
import com.twistresources.apitwistedproperties.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @GetMapping("/property/{id}")
    public Object show(@PathVariable(name = "id") Property property, @RequestHeader(name = "Authorization") String token){
        return propertyService.show(token, property);
    }
}
