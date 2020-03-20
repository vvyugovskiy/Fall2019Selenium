package org.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {

    public static void main(String[] args) {

        // unit test
        // to check if our method works properly
        // if assertion fails, that means our method doesn't work correctly
        // that means we have to fix the method
        String expected = "cba";
        String toReverse = "abc";
        String actual = reverseString(toReverse);
        // Assertion
        verifyEquals(expected,actual);
    }
    // annotation
    @Test (description = "Verify if method can reverse a string")
    public void test(){
        String expected = "elppa";
        String actual = reverseString("apple");
        // it coming from testing, junit also has this class
        // can compare any data types here: strings, primitives, arrays, objects
        // to verify if expected result is equals to actual
        Assert.assertEquals(actual,expected);

    }

    public static boolean verifyEquals(String expected, String actual) {
        if (expected.equals(actual)) {
            System.out.println("TEST PASSED");
            return true;
        } else {
            System.out.println("Test failed!!!");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            return false;
        }
    }

    /**
     * This method stands for reversing strings.
     *
     * @param str to reverse
     * @return reversed string
     */
    public static String reverseString(String str) {
        String reversed = "";
        for (int i = str.length()-1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }
}
