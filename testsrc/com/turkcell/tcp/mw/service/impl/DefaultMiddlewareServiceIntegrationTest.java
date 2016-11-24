package com.turkcell.tcp.mw.service.impl;

import com.turkcell.tcp.mw.service.MiddlewareService;
import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import org.junit.Test;

import javax.annotation.Resource;

import static org.fest.assertions.Assertions.assertThat;

@IntegrationTest
public class DefaultMiddlewareServiceIntegrationTest extends ServicelayerBaseTest {

    @Resource
    MiddlewareService middlewareService;

    @Test
    public void shouldReturnQuote() throws Exception {

        String quote = middlewareService.getQuote();
        assertThat(quote).isNotNull();
    }
}
