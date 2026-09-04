package Assignment60;

import java.util.*;

public class SocialNetwork {

    public static void main(String[] args) {

        // Create graph
        Map<String, List<String>> graph =
                new HashMap<>();

        graph.put("Amit",
                Arrays.asList("Rahul", "Pooja"));

        graph.put("Rahul",
                Arrays.asList("Neha"));

        graph.put("Pooja",
                Arrays.asList("Kiran"));

        graph.put("Neha",
                Arrays.asList("Riya"));

        graph.put("Kiran",
                Arrays.asList("Riya"));

        graph.put("Riya",
                new ArrayList<>());

        String source = "Amit";
        String destination = "Riya";

        // Queue for BFS
        Queue<String> queue = new LinkedList<>();

        // Visited set
        Set<String> visited = new HashSet<>();

        // Store distance
        Map<String, Integer> distance =
                new HashMap<>();

        // Store parent for path
        Map<String, String> parent =
                new HashMap<>();

        // Start BFS
        queue.add(source);
        visited.add(source);
        distance.put(source, 0);

        while (!queue.isEmpty()) {

            String current = queue.poll();

            // Destination found
            if (current.equals(destination)) {
                break;
            }

            for (String neighbour :
                    graph.get(current)) {

                if (!visited.contains(neighbour)) {

                    visited.add(neighbour);

                    queue.add(neighbour);

                    distance.put(
                        neighbour,
                        distance.get(current) + 1
                    );

                    parent.put(
                        neighbour,
                        current
                    );
                }
            }
        }

        // Check if destination is reachable
        if (!distance.containsKey(destination)) {

            System.out.println(
                "Riya cannot be reached from Amit."
            );

        } else {

            // Construct shortest path
            List<String> path =
                    new ArrayList<>();

            String current = destination;

            while (current != null) {

                path.add(current);

                current = parent.get(current);
            }

            // Reverse path
            Collections.reverse(path);

            System.out.println("Shortest Path:");

            for (int i = 0; i < path.size(); i++) {

                System.out.print(path.get(i));

                if (i < path.size() - 1) {
                    System.out.print(" -> ");
                }
            }

            System.out.println();

            System.out.println(
                "Number of connections: "
                + distance.get(destination)
            );
        }
    }
}
