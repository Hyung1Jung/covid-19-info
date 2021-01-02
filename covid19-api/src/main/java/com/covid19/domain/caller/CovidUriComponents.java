package com.covid19.domain.caller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Configuration
public class CovidUriComponents {

    @Value("${serviceKey}")
    private String serviceKey;

    @Bean
    public UriComponents uri() {

        String url = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson";

        String decodeServiceKey = URLDecoder.decode(serviceKey, StandardCharsets.UTF_8); // 컨트롤러에서 예외 처리 던져주는거 말고 여기서 try/catch

        return UriComponentsBuilder.fromHttpUrl(url).queryParam("serviceKey", decodeServiceKey)
                .queryParam("pageNo")
                .queryParam("numOfRows")
                .queryParam("startCreateDt")
                .queryParam("endCreateDt")
                .build(false);
    }
}
