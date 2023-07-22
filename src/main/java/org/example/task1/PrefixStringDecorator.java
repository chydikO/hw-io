package org.example.task1;

public class PrefixStringDecorator implements StringDecorator {
    private final String prefix;

    public PrefixStringDecorator(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String decorate(String input) {
        return prefix + input;
    }
}
