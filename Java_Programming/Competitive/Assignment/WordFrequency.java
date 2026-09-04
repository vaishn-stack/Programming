package Assignment60;

import java.util.*;

public class WordFrequency {

    public static void main(String[] args) {

        String sentence =
            "java python java c java python cpp";

        String[] words =
            sentence.split("\\s+");

        LinkedHashMap<String, Integer> map =
            new LinkedHashMap<>();

        for (String word : words) {

            map.put(
                word,
                map.getOrDefault(word, 0) + 1
            );
        }

        String mostFrequent = "";
        int maxFrequency = 0;

        for (Map.Entry<String, Integer> entry :
             map.entrySet()) {

            if (entry.getValue() > maxFrequency) {

                maxFrequency =
                    entry.getValue();

                mostFrequent =
                    entry.getKey();
            }
        }

        System.out.println(
            "Most frequent word : "
            + mostFrequent);

        System.out.println(
            "Frequency : "
            + maxFrequency);
    }
}
