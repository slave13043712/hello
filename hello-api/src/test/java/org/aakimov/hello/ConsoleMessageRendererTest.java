package org.aakimov.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.Console;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleMessageRendererTest {

    /**
     * java.io.Console class is final so src/test/mockito-extensions directory and related files
     * were created in order to be able to mock it.
     */
    @Mock
    private Console console;

    @InjectMocks
    private ConsoleMessageRenderer messageRenderer;

    @Test
    public void testRender() {
        String message = "Hello World!";
        this.messageRenderer.render(message);
        verify(this.console, times(1)).format(message);
    }
}
