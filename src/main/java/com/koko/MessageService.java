package com.koko;

import java.util.*;

public class MessageService {

    public static String get() {
        return "Hello JUnit 5";
    }

    public static void main(String[] args) {

        String x = "abcdef";
        x = x.substring(1, 3);
        System.out.println(x);


    }

}