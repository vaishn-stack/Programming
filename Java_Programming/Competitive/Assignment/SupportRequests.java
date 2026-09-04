package Assignment60;

import java.util.*;

public class SupportRequests {

    static Queue<String> requests =
        new LinkedList<>();

    static void addRequest(String request) {

        requests.add(request);

        System.out.println(
            request + " added");
    }

    static void processRequest() {

        if (requests.isEmpty()) {

            System.out.println(
                "No pending requests");

        } else {

            String request =
                requests.remove();

            System.out.println(
                "Processing : " + request);
        }
    }

    static void showPendingRequests() {

        System.out.println(
            "Pending Requests:");

        for (String request : requests) {

            System.out.println(request);
        }
    }

    public static void main(String[] args) {

        addRequest("R101");
        addRequest("R102");
        addRequest("R103");
        addRequest("R104");

        showPendingRequests();

        processRequest();

        showPendingRequests();
    }
}
