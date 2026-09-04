package Assignment60;

import java.util.*;

public class BrowserHistory {

    public static void main(String[] args) {

        Deque<String> history =
            new ArrayDeque<>();

        String[] visits = {
            "google.com",
            "github.com",
            "openai.com",
            "oracle.com",
            "stackoverflow.com",
            "youtube.com"
        };

        for (String site : visits) {

            history.addLast(site);

            if (history.size() > 5) {

                history.removeFirst();
            }
        }

        System.out.println(
            "Browser History:");

        for (String site : history) {

            System.out.println(site);
        }
    }
}
