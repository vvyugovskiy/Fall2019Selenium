package org.automation.tests.officeHour;

import java.util.*;

public class OH_2020_03_19_Akbar_2 {

    public static void main(String[] args) {

        // Take home task: create a Map of ProductName, Price --
        // using selenium to get all the data
        // and store it into Your Map

        // Also try to create Map of Product name and name length

        // List<Map<String, Double>> to store Each name value pair (just for the sake of practice)


        // is Map Iterable (does Map interface extend Iterable, Collection interface) : NO!!!
        // anything not iterable we can not use foreach loop

        Map<String,String> nameStatePair = new HashMap<>(); // LinkedHashMap for keeping insertion order
        nameStatePair.put("Faitih","FL");
        nameStatePair.put("Zhibeckchach","IL");
        nameStatePair.put("Vlad","SC");
        nameStatePair.put("Hasan","NY");
        nameStatePair.put("Omer","TX");
        nameStatePair.put("Atakan","GA");

        System.out.println("nameStatePair = " + nameStatePair);


    }
}
