package com.twistresources.apitwistedproperties.controllers;

import com.twistresources.apitwistedproperties.services.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController

@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class SuggestionController {

    @Autowired
    SuggestionService suggestionService;

    @GetMapping("/suggestions")
    public  Object suggestions(@RequestParam(name = "q") String query, @RequestParam(name = "suggestionTypes") String suggestionType, @RequestHeader(name = "Authorization") String token){
        return  suggestionService.suggestions(token, query, suggestionType);
    }
}
