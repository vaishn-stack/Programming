package Assignment60;

import java.util.*;

public class DependencyResolver {

    public static void main(String[] args) {

        // Number of modules
        int n = 6;

        // Module names
        String[] modules = {
            "A", "B", "C", "D", "E", "F"
        };

        // Dependency pairs
        // A -> C
        // B -> C
        // C -> D
        // B -> E
        // D -> F
        // E -> F

        int[][] dependencies = {
            {0, 2},  // A -> C
            {1, 2},  // B -> C
            {2, 3},  // C -> D
            {1, 4},  // B -> E
            {3, 5},  // D -> F
            {4, 5}   // E -> F
        };

        // Adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Indegree array
        int[] indegree = new int[n];

        // Build graph
        for (int[] dependency : dependencies) {

            int from = dependency[0];
            int to = dependency[1];

            graph.get(from).add(to);

            indegree[to]++;
        }

        // Queue for modules with no dependency
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> order = new ArrayList<>();

        // Topological sorting
        while (!queue.isEmpty()) {

            int current = queue.poll();

            order.add(current);

            for (int next : graph.get(current)) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        // Check for cycle
        if (order.size() != n) {

            System.out.println(
                "Invalid dependency: Cycle detected."
            );

        } else {

            System.out.println(
                "Valid Dependency Order:"
            );

            for (int module : order) {
                System.out.println(modules[module]);
            }
        }
    }
}
