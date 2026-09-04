package Assignment60;

import java.util.*;

public class EmployeeFrequency {

    public static void main(String[] args) {

        int[] ids = {
            101, 102, 103, 101,
            104, 102, 101, 105
        };

        LinkedHashMap<Integer, Integer> map =
            new LinkedHashMap<>();

        for (int id : ids) {

            if (map.containsKey(id)) {
                map.put(id, map.get(id) + 1);
            } else {
                map.put(id, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry :
             map.entrySet()) {

            System.out.println(
                entry.getKey() + " -> "
                + entry.getValue());
        }
    }
}
