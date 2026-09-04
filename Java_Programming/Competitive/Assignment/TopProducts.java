package Assignment60;

import java.util.*;

public class TopProducts {

    public static void main(String[] args) {

        int[] products = {
            101, 102, 101, 103,
            101, 102, 104, 105,
            102, 102, 103
        };

        HashMap<Integer, Integer> map =
            new HashMap<>();

        // Count frequency
        for (int id : products) {

            map.put(
                id,
                map.getOrDefault(id, 0) + 1
            );
        }

        // Convert map entries to list
        ArrayList<Map.Entry<Integer, Integer>> list =
            new ArrayList<>(map.entrySet());

        // Sort by frequency descending
        Collections.sort(
            list,
            new Comparator<Map.Entry<Integer, Integer>>() {

                public int compare(
                    Map.Entry<Integer, Integer> e1,
                    Map.Entry<Integer, Integer> e2) {

                    return Integer.compare(
                        e2.getValue(),
                        e1.getValue());
                }
            }
        );

        System.out.println(
            "Top 2 most frequently purchased products:");

        for (int i = 0; i < 2 && i < list.size(); i++) {

            System.out.println(
                list.get(i).getKey()
                + " -> "
                + list.get(i).getValue());
        }
    }
}
