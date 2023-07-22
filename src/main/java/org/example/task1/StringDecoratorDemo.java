package org.example.task1;

/**
 * 1. Реалізуйте простий декоратор для класу String, який додає певний префікс до рядка.
 * Наприклад, декоратор може додавати префікс "DEBUG: " до будь-якого рядка. Ви можете використати інтерфейс
 * або абстрактний клас для декоратора і забезпечити можливість ланцюжкового виклику декораторів.
 */
public class StringDecoratorDemo {
    public static void main(String[] args) {
        String str = "test StringDecorator";
        String prefix = "DEBUG: ";

        StringDecorator decorator = new PrefixStringDecorator(prefix);
        System.out.println(decorator.decorate(str));
    }
}
