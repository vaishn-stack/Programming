package Assignment60;

import java.util.*;

class Patient {

    String name;
    int severity;

    Patient(String name, int severity) {

        this.name = name;
        this.severity = severity;
    }
}

public class Hospital {

    public static void main(String[] args) {

        PriorityQueue<Patient> patients =
            new PriorityQueue<>(
                new Comparator<Patient>() {

                    public int compare(
                        Patient p1,
                        Patient p2) {

                        return Integer.compare(
                            p2.severity,
                            p1.severity);
                    }
                }
            );

        patients.add(
            new Patient("Rahul", 2));

        patients.add(
            new Patient("Amit", 5));

        patients.add(
            new Patient("Pooja", 1));

        patients.add(
            new Patient("Neha", 4));

        System.out.println(
            "Treatment Order:");

        while (!patients.isEmpty()) {

            Patient p =
                patients.poll();

            System.out.println(
                p.name);
        }
    }
}