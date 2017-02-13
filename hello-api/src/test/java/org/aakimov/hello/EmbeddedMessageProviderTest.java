package org.aakimov.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class EmbeddedMessageProviderTest {

    private final EmbeddedMessageProvider messageProvider;

    private final String[] parameters;

    private final String expectedResult;

    public EmbeddedMessageProviderTest(
        String[] parameters,
        String expectedResult
    ) {
        this.messageProvider = new EmbeddedMessageProvider();
        this.parameters = parameters;
        this.expectedResult = expectedResult;
    }

    @Parameters
    public static List<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][] {
            {new String[] {"John Doe", "Jane Doe"}, "Hello John Doe!"},
            {new String[] {"John Doe"}, "Hello John Doe!"},
            {new String[] {}, "Hello World!"},
        });
    }

    @Test
    public void testGetMessage() {
        assertEquals(this.expectedResult, this.messageProvider.getMessage(this.parameters));
    }
}
