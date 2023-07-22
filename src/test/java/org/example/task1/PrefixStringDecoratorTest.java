package org.example.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrefixStringDecoratorTest {
    @Test
    public void testPrefixStringDecorator() {
        String str = "test";
        StringDecorator decorator = new PrefixStringDecorator("DEBUG: ");

        String decoratedString = decorator.decorate(str);

        assertEquals("DEBUG: test", decoratedString);
    }
}