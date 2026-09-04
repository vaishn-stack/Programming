package Assignment60;

import java.util.*;

public class GroupEmployees {

    public static void main(String[] args) {

        String[][] employees = {
            {"Amit", "IT"},
            {"Rahul", "HR"},
            {"Pooja", "IT"},
            {"Neha", "Finance"},
            {"Kiran", "HR"},
            {"Riya", "IT"}
        };

        // LinkedHashMap maintains insertion order
        Map<String, List<String>> departmentMap =
                new LinkedHashMap<>();

        // Group employees department-wise
        for (String[] employee : employees) {

            String name = employee[0];
            String department = employee[1];

            departmentMap
                .computeIfAbsent(
                    department,
                    k -> new ArrayList<>()
                )
                .add(name);
        }

        // Display result
        for (Map.Entry<String, List<String>> entry :
                departmentMap.entrySet()) {

            System.out.println(entry.getKey() + ":");

            for (String employee : entry.getValue()) {
                System.out.println(employee);
            }

            System.out.println();
        }
    }
}
