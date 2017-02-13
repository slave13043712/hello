package org.aakimov.hello;

/**
 * Embedded message provider.
 *
 * Provides predefined message.
 */
public class EmbeddedMessageProvider implements MessageProvider {

    /**
     * @inheritDoc
     */
    @Override
    public String getMessage(String... parameters) {
        return (parameters.length > 0) ? String.format("Hello %s!", parameters) : "Hello World!";
    }
}
