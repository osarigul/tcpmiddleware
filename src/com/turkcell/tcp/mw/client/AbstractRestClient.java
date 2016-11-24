package com.turkcell.tcp.mw.client;

import com.turkcell.tcp.mw.constants.TcpmiddlewareConstants;
import de.hybris.platform.util.Config;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractRestClient {

    protected RestTemplate restTemplate;

    private String mwApiUrl;

    public String getMwApiUrl() {
        mwApiUrl = Config.getString(TcpmiddlewareConstants.MIDDLEWARE_URL,null);
        return mwApiUrl;
    }

    @Required
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
