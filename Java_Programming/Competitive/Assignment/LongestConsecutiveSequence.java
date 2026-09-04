package Assignment60;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        int[] ids = {100, 4, 200, 1, 3, 2, 5};

        HashSet<Integer> set = new HashSet<>();

        // Store all IDs in HashSet
        for (int id : ids) {
            set.add(id);
        }

        int longestLength = 0;
        int startNumber = 0;

        // Find longest consecutive sequence
        for (int id : set) {

            // Check if id is the starting number
            if (!set.contains(id - 1)) {

                int current = id;
                int length = 1;

                // Find consecutive numbers
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                // Update longest sequence
                if (length > longestLength) {
                    longestLength = length;
                    startNumber = id;
                }
            }
        }

        System.out.println("Longest Consecutive Sequence:");

        for (int i = 0; i < longestLength; i++) {
            System.out.print((startNumber + i) + " ");
        }

        System.out.println();
        System.out.println("Length : " + longestLength);
    }
}
