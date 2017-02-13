package org.aakimov.hello.console;

import org.aakimov.hello.ConsoleMessageRenderer;
import org.aakimov.hello.EmbeddedMessageProvider;
import org.aakimov.hello.MessageProvider;
import org.aakimov.hello.MessageRenderer;

import java.io.Console;

/**
 * Console application that prints message to console.
 */
public class ConsoleApplication {

    /**
     * Main entry point of the application.
     *
     * @param args command line arguments.
     */
    public static void main(String... args) {
        Console console = System.console();
        if (console == null) {
            System.exit(0);
        }
        MessageProvider messageProvider = new EmbeddedMessageProvider();
        MessageRenderer messageRenderer = new ConsoleMessageRenderer(console);
        messageRenderer.render(messageProvider.getMessage(args));
    }
}
