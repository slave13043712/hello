package org.aakimov.hello;

import java.io.Console;

/**
 * Console message renderer.
 *
 * Renders given message to console.
 */
public class ConsoleMessageRenderer implements MessageRenderer {

    /**
     * Console instance.
     */
    private final Console console;

    /**
     * @param console console instance to which message will be rendered.
     */
    public ConsoleMessageRenderer(
        Console console
    ) {
        this.console = console;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void render(String message) {
        this.console.format(message);
    }
}
