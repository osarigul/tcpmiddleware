package com.turkcell.tcp.mw.client;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class MwResponseErrorHandler implements ResponseErrorHandler {

    protected static final Logger LOG = Logger.getLogger(MwResponseErrorHandler.class);

    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        HttpStatus.Series series = clientHttpResponse.getStatusCode().series();
        return (HttpStatus.Series.CLIENT_ERROR.equals(series) || HttpStatus.Series.SERVER_ERROR.equals(series));
    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
        LOG.error(String.format("MW response error: {%s} {%s} ", clientHttpResponse.getStatusCode(), clientHttpResponse.getStatusText()));
    }
}
