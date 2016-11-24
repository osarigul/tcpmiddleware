package com.turkcell.tcp.mw.client.impl;

import com.turkcell.tcp.mw.client.AbstractRestClient;
import com.turkcell.tcp.mw.client.VposRestClient;
import com.turkcell.tcp.mw.dto.Quote;
import org.apache.log4j.Logger;

public class DefaultVposRestClient extends AbstractRestClient implements VposRestClient {

    private static final Logger LOG = Logger.getLogger(DefaultVposRestClient.class);
    private static final String QUOTE_URL = "/random";

    @Override
    public Quote getQuote() {
        String resourceUrl = getMwApiUrl() + QUOTE_URL;
        Quote quote = restTemplate.getForObject(resourceUrl, Quote.class);
        LOG.debug(quote.toString());
        return quote;
    }
}
