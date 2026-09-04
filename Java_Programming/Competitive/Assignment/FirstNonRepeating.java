package Assignment60;

import java.util.*;

public class FirstNonRepeating {

    public static void main(String[] args) {

        String str = "programming";

        LinkedHashMap<Character, Integer> map =
            new LinkedHashMap<>();

        // Count characters
        for (char c : str.toCharArray()) {

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        // Find first character with frequency 1
        for (Map.Entry<Character, Integer> entry :
             map.entrySet()) {

            if (entry.getValue() == 1) {

                System.out.println(
                    "First non-repeating character : "
                    + entry.getKey());

                break;
            }
        }
    }
}
