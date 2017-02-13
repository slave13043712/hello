package org.aakimov.hello;

/**
 * Message provider interface.
 *
 * Provides string that can be used as a message for the user.
 */
@FunctionalInterface
public interface MessageProvider {

    /**
     * Retrieve message.
     *
     * @param parameters parameters that can be used to compose the message.
     * @return message.
     */
    public String getMessage(String... parameters);
}
