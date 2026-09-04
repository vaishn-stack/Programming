package Assignment60;

public class TwoTransactions {

    public static void main(String[] args) {

        int[] transactions = {1200, 500, 700, 300, 1500};
        int target = 2000;

        boolean found = false;

        for (int i = 0; i < transactions.length; i++) {

            for (int j = i + 1; j < transactions.length; j++) {

                if (transactions[i] + transactions[j] == target) {

                    System.out.println(
                        transactions[i] + " + " +
                        transactions[j] + " = " + target
                    );

                    found = true;
                    break;
                }
            }

            if (found) {
                break;
            }
        }

        if (!found) {
            System.out.println("No two transactions found.");
        }
    }
}