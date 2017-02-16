package org.aakimov.hello.web;

import org.aakimov.hello.EmbeddedMessageProvider;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class HelloServletIT {

    private WebDriver webDriver;

    private Server server;

    private String serverUri;

    @Before
    public void setUp() throws Exception { //NOSONAR
        this.webDriver = new ChromeDriver();
        this.server = new Server();
        ServerConnector connector = new ServerConnector(server);
        // bind to available port
        connector.setPort(0);
        this.server.addConnector(connector);

        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.GZIP);
        servletContextHandler.setContextPath("/hello");
        servletContextHandler.addServlet(
            new ServletHolder(new HelloServlet(new EmbeddedMessageProvider())),
            "/*"
        );
        this.server.setHandler(servletContextHandler);
        this.server.start();

        // compose correct server URI
        String host = connector.getHost();
        if (host == null) {
            host = "localhost";
        }
        int port = connector.getLocalPort();
        this.serverUri = String.format("http://%s:%d/", host, port);
    }

    @After
    public void tearDown() throws Exception { //NOSONAR
        this.webDriver.quit();
        this.server.stop();
    }

    @Test
    public void testDoGet() {
        this.webDriver.get(this.serverUri + "hello");
        assertTrue(this.webDriver.getPageSource().contains("Hello World!"));
        this.webDriver.get(this.serverUri + "hello?name=John");
        assertTrue(this.webDriver.getPageSource().contains("Hello John!"));
    }
}
