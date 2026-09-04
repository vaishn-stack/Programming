package Assignment60;

import java.util.*;

public class Warehouse {

    static HashMap<Integer, Integer> products =
        new HashMap<>();

    static void addProduct(int id, int quantity) {

        products.put(
            id,
            products.getOrDefault(id, 0) + quantity
        );
    }

    static void sellProduct(int id, int quantity) {

        if (!products.containsKey(id)) {

            System.out.println(
                "Product " + id + " does not exist");

            return;
        }

        int available = products.get(id);

        if (quantity > available) {

            System.out.println(
                "Insufficient quantity");

            return;
        }

        products.put(id, available - quantity);
    }

    static void restock(int id, int quantity) {

        if (!products.containsKey(id)) {

            System.out.println(
                "Product " + id + " does not exist");

            return;
        }

        products.put(
            id,
            products.get(id) + quantity
        );
    }

    static void searchProduct(int id) {

        if (products.containsKey(id)) {

            System.out.println(
                "Product " + id
                + " available quantity : "
                + products.get(id));

        } else {

            System.out.println(
                "Product " + id
                + " does not exist");
        }
    }

    public static void main(String[] args) {

        addProduct(101, 50);
        addProduct(102, 30);

        sellProduct(101, 5);

        restock(102, 20);

        searchProduct(101);
    }
}
