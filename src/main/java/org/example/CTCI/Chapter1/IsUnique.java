package org.example.CTCI.Chapter1;

import java.util.HashMap;
import java.util.Map;

/*
*  Implement an algorithm to determine if a string has all unique characters.
*  What if you cannot use additional data structures?
* */
public class IsUnique {

    public static void checkUnique_v1(String input) {
        System.out.println(input);
        Map<Character, Integer> charOccurrences = new HashMap<>();
        char[] charArray = input.toCharArray();
        for (char c: charArray) {
            if (charOccurrences.containsKey(c))
                charOccurrences.put(c, charOccurrences.get(c) + 1);
            else
                charOccurrences.put(c, 1);
        }
        long countOfKeysWithValueOne = charOccurrences.values().stream()
                .filter(val -> val == 1)
                .count();

        if (countOfKeysWithValueOne == input.length())
            System.out.println("The input string has all unique characters");
        else
            System.out.println("Not all chars are unique");
    }

    public static void checkUnique_v2(String input) {
        if (input.length() > 128) {
            System.out.println("Not all chars are unique");
            return;
        }
        // we assume an alphabet of 128 chars, normal ASCII
        boolean[] char_set = new boolean[128];
        for (int i=0; i<input.length(); i++) {
            int val = input.charAt(i);
            if (char_set[val]) {
                System.out.println("Not all chars are unique");
                return;
            }
            char_set[val] = true;
        }
        System.out.println("All chars are unique");
    }

    public static void main(String[] args) {
        checkUnique_v1("abcd");
        checkUnique_v2("abcd");
    }
}
