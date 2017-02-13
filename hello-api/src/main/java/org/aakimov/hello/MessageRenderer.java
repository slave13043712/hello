package org.aakimov.hello;

/**
 * Message renderer interface.
 *
 * Renders the give message.
 */
@FunctionalInterface
public interface MessageRenderer {

    /**
     * Render the given message.
     *
     * @param message message to render.
     */
    public void render(String message);
}
