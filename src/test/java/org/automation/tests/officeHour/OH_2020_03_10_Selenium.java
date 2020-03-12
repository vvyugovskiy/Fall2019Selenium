package org.automation.tests.officeHour;

import java.io.IOException;
import java.util.*;

public class OH_2020_03_10_Selenium {

    public static void main(String[] args) throws IOException, InterruptedException {

        /*
            Under List Interface:
            - ArrayList (indexes, faster to read, slower when we
            do manipulations(remove or add elements))
            - Vector (same as ArrayList, but thread safe)
                - Stack (Last in First out (like a stack of paper))
            - LinkedList (node (each element reference to previous
            and next element in the list))
            (performance-sensitive, memory allocation)
            [2, 5, 3] -> [2, 3]
            [2] [5] [3]
         */
        /*
            Set Interface: (contain only unique values)
            HashSet: no indexes - faster because it is using hashing
            (it does not keep an order), allows 1 null
            TreeSet: sorted set - no nulls
            LinkedHashSet: keeps the order
         */
        HashSet<String> hashSet = new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        for (String each : Arrays.asList("Value5", "Value1", "Value3")) {
            hashSet.add(each);
            treeSet.add(each);
            linkedHashSet.add(each);
        }
        System.out.println("hashSet = " + hashSet);
        System.out.println("treeSet = " + treeSet);
        System.out.println("linkedHashSet = " + linkedHashSet);

        Iterator<String> iteratorSet = hashSet.iterator();
        while (iteratorSet.hasNext()) {
            System.out.println(iteratorSet.next());
        }

        ArrayList<Integer> dropdown = new ArrayList<>();
        dropdown.add(1);
        dropdown.add(2);
        dropdown.add(3);
        dropdown.add(4);
        dropdown.add(5);
        dropdown.add(1);
        // [1,2,3,4,5,1]

        System.out.println("list: " + dropdown);
        HashSet<Integer> optionsSet = new HashSet<>(dropdown);
        System.out.println("optionSet: " + optionsSet);

        if (optionsSet.size() == dropdown.size()) {
            System.out.println("expected is the same as actual");
        } else {
            System.out.println("options contains duplicates");
        }

        //---------------------------
        /**
         * Queue:
         * - PriorityQueue - First in first out / FIFO
         *      can accept duplicates, does not have index
         * - ArrayDequeue - special in adding and removing
         */

        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("John");
        priorityQueue.add("Kate");
        priorityQueue.add("Tom");
        System.out.println("Queue: " + priorityQueue);
        System.out.println("poll" + priorityQueue.peek());
        // peeking (.peek()) - it will check and return the first is a Queue
        System.out.println("peek" + priorityQueue.poll());
        System.out.println(priorityQueue);
        // polling will return the first value in a queue and remove it

        ArrayDeque<String> dequeu = new ArrayDeque<>();

        Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");


    }
}
