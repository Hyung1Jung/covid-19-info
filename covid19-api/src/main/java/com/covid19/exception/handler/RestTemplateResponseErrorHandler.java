package com.covid19.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

@Slf4j
public class RestTemplateResponseErrorHandler extends DefaultResponseErrorHandler {
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        log.error("Has error response: {}", response);
        super.handleError(response);
    }

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        log.error("Has error response: {}", response);
        return super.hasError(response);
    }
}

