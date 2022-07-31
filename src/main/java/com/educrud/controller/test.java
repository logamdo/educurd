package com.educrud.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        // Let us create a list with 4 items
        ArrayList<String> list =
                new ArrayList<String>();
        list.add("code");
        list.add("code");
        list.add("quiz");
        list.add("code");

        // count the frequency of the word "code"
        List<String> collect = list.stream().filter(s -> Collections.frequency(list, s) > 1).distinct().collect(Collectors.toList());
        System.out.println("The frequency of the word code is: " + collect.toString());

    }
}
