package com.university.testpo;

import org.junit.Rule;

import java.io.UnsupportedEncodingException;

public class Main {
    private static final FirstTest FIRST_TEST = new FirstTest();
    @Rule
    public static void main(String[] args) throws InterruptedException{

        FIRST_TEST.setup();
        FIRST_TEST.loginTest();

    }
}
