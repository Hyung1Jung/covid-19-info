package com.covid19.domain.caller;

import com.covid19.controller.dto.Body;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;

@Configuration
public class CovidJson {

    private final RestTemplate restTemplate;
    private final UriComponents uri;

    @Autowired
    public CovidJson(RestTemplate restTemplate, UriComponents uri) {
        this.restTemplate = restTemplate;
        this.uri = uri;
    }


    @Bean
    public Body jsonPrettyPrintString() {

        String xmlData = restTemplate.getForObject(uri.toUriString(), String.class);

        JSONObject xmlJSONObj = XML.toJSONObject(xmlData).getJSONObject("response").
                getJSONObject("body");

        String jsonPrettyPrintString = xmlJSONObj.toString(4);

        Gson gson = new Gson();

        Body body = gson.fromJson(jsonPrettyPrintString, Body.class);
        return body;
    }
}
