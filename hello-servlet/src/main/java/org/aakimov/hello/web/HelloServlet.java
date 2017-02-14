package org.aakimov.hello.web;

import org.aakimov.hello.MessageProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet that returns message as a response.
 */
public class HelloServlet extends HttpServlet {

    /**
     * Message provider
     */
    private final MessageProvider messageProvider;

    /**
     * @param messageProvider message provider.
     */
    public HelloServlet(
        MessageProvider messageProvider
    ) {
        this.messageProvider = messageProvider;
    }

    /**
     * Handle GET request by returning the message.
     *
     * @param request request object.
     * @param response response object.
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        String name = request.getParameter("name");
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print((name == null) ? this.messageProvider.getMessage() : this.messageProvider.getMessage(name));
    }
}
