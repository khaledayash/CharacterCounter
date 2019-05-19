package com.mycompany.showcharwithhighestoccurrence.javafxBusinessLogic;

import java.util.*;
import java.util.stream.Collectors;

public class BusinessLogic {

    public String giveFinalResult(String text) {

        String result = "";
        if (text != null) {
            String input = evaluateInputText(text);
            List<Character> listCharMaxFreq = new LinkedList<>();
            Map<Character, Integer> counts = new HashMap<>();
            int maxFreq = computeOccurence(input, listCharMaxFreq, counts);
            result = print(listCharMaxFreq, maxFreq);
        }
        return result;
    }


    public String evaluateInputText(String text) {
        String input = "";
        if (text != null) {
            input = text.toLowerCase().replaceAll("\\s+", "");
        }
        return input;
    }

    // compute occurence of each characters
    public int computeOccurence(String input, List<Character> listCharMaxFreq, Map<Character, Integer> counts) {

        int maxFreq = 0;
        if (input != null && listCharMaxFreq != null && counts != null) {
            for (char c : input.toCharArray()) { // prefer foreach loop
                Integer i = counts.get(c);
                if (i == null) { // character not yet met
                    i = 1; // so 1
                } else {
                    ++i; // otherwise, increment
                }
                counts.put(c, i); // save new count

                // keep trace of most occurred chars
                if (i >= maxFreq) {
                    if (i > maxFreq) {
                        listCharMaxFreq.clear();
                    }
                    maxFreq = i;
                    listCharMaxFreq.add(c);
                }
            }
        }
        return maxFreq;
    }

    public String print(List<Character> listCharMaxFreq, int occurence) {

        String result = "";
        if (listCharMaxFreq != null && occurence > 1) {
            if (listCharMaxFreq.size() == 1) {
                result = "The most frequent letter is " + listCharMaxFreq.get(0) + " with " + occurence + " occurences.";
            } else {
                // construct output string
                StringBuilder sb = new StringBuilder();
                sb.append("The most frequent letters are")
                        .append(listCharMaxFreq.stream().sorted(Comparator.comparing(n -> n.toString())).collect(Collectors.toList()))
                        .append(" with ")
                        .append(occurence)
                        .append(" occurences.");

                result = sb.toString().replace("[", " ").replace("]", "");
            }
        }

        return result;
    }


}