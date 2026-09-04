package Assignment60;

import java.util.*;

public class DuplicateTransactions {

    public static void main(String[] args) {

        String[] transactions = {
            "TX101",
            "TX102",
            "TX103",
            "TX101",
            "TX104",
            "TX102"
        };

        HashMap<String, Integer> map =
            new HashMap<>();

        for (String tx : transactions) {

            map.put(
                tx,
                map.getOrDefault(tx, 0) + 1
            );
        }

        System.out.println(
            "Duplicate transactions:");

        for (Map.Entry<String, Integer> entry :
             map.entrySet()) {

            if (entry.getValue() > 1) {

                System.out.println(
                    entry.getKey());
            }
        }
    }
}
