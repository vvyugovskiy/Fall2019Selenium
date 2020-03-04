package org.automation.tests.officeHour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SeleniumOH1_2020_03_03 {
    public static void main(String[] args) {

        // Create arrayList of Strings - iterate over it

        List<String> keysToSearch = new ArrayList<>();
        keysToSearch.add("fruits");
        keysToSearch.add("veggies");
        keysToSearch.add("berries");
        Iterator iterator = keysToSearch.iterator();

        //iterator() - return Iterator type which we can use with all iterator methods
        //[fruits, veggies, berries]
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Iterator <String> iterator1 = keysToSearch.iterator();
        while (iterator1.hasNext()){
            String item = iterator1.next();
            System.out.println(item);
            System.out.println("*" + item);
        }

        // create a Map with <String, String>
        HashMap<String,String> personalInfo = new HashMap<>();
        personalInfo.put("name", "Bryan");

    }
}
