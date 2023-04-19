package executor.service.service;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.ProxyCredentials;
import executor.service.model.ProxyNetworkConfig;
import executor.service.service.holder.proxy.DefaultProxyHandler;
import executor.service.service.holder.proxy.ProxyHandler;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DefaultProxyHandlerTest {
    private ProxyHandler proxyHandler;
    private List<ProxyConfigHolder> expectedResults;

    @Before
    public void setUp() {
        proxyHandler = new DefaultProxyHandler();
        expectedResults = new ArrayList<>();
        expectedResults.add(new ProxyConfigHolder(new ProxyNetworkConfig("host1", 8080), new ProxyCredentials("user11", "pass1")));
        expectedResults.add(new ProxyConfigHolder(new ProxyNetworkConfig("host2", 8088), new ProxyCredentials("user2", "pass2")));
        expectedResults.add(new ProxyConfigHolder(new ProxyNetworkConfig("host3", 8089), new ProxyCredentials("user3", "pass13")));

        expectedResults.add(new ProxyConfigHolder(new ProxyNetworkConfig("host1", 8080), new ProxyCredentials("user11", "pass1")));
        expectedResults.add(new ProxyConfigHolder(new ProxyNetworkConfig("host2", 8088), new ProxyCredentials("user2", "pass2")));
    }

    @Test
    public void testGetProxy() {
        for (ProxyConfigHolder expectedResult : expectedResults) {
//            assertEquals(expectedResult, proxySourcesClient.getProxy());
        }
    }
}