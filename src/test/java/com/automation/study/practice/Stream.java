package com.automation.study.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

    public static void main(String[] args) {

        List<Integer> number = Arrays.asList(2, 3, 4, 5);
        List<Integer> square = number.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println(square);

        List<String> names = Arrays.asList("Reflection", "Collection", "Stream");

        Collections.shuffle(names);

        System.out.println(names);


        List<String> result = names.stream().filter(e -> e.startsWith("S")).collect(Collectors.toList());
        System.out.println(result);

        List<String> show = names.stream().sorted().collect(Collectors.toList());
        System.out.println(show);

        number.stream().map(x->x*x+5).forEach(y-> System.out.println(y));
        System.out.println(number);
    }
}
