package org.aakimov.hello.web;

import org.aakimov.hello.EmbeddedMessageProvider;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Server application that prints message in response of GET request.
 */
public class WebApplication {

    /**
     * Private constructor to hide the default one.
     */
    private WebApplication() {
        throw new UnsupportedOperationException("Instance of this class can not be created.");
    }

    /**
     * Main entry point of the application.
     *
     * @param args command line arguments.
     */
    public static void main(String... args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.GZIP);
        servletContextHandler.setContextPath("/hello");
        servletContextHandler.addServlet(
            new ServletHolder(new HelloServlet(new EmbeddedMessageProvider())),
            "/*"
        );
        server.setHandler(servletContextHandler);

        server.start();
        server.join();
    }
}
