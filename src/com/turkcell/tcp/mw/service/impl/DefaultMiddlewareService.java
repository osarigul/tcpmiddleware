package com.turkcell.tcp.mw.service.impl;

import com.turkcell.tcp.mw.client.VposRestClient;
import com.turkcell.tcp.mw.dto.Quote;
import com.turkcell.tcp.mw.service.MiddlewareService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

public class DefaultMiddlewareService implements MiddlewareService {

    private static final Logger LOG = Logger.getLogger(DefaultMiddlewareService.class);

    private VposRestClient vposRestClient;

    @Override
    public String getQuote() {
        final Quote quote = vposRestClient.getQuote();
        String quoteStr = null;
        if (quote != null && quote.getValue() != null) {
            quoteStr = quote.getValue().getQuote();
            LOG.info("Quote: " + quoteStr);
        }
        return quoteStr;
    }

    @Required
    public void setVposRestClient(VposRestClient vposRestClient) {
        this.vposRestClient = vposRestClient;
    }
}
