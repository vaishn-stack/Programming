package Assignment60;

import java.io.*;
import java.util.*;

public class DirectoryList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter directory: ");
        String path = sc.nextLine();

        File dir = new File(path);

        if (!dir.exists()) {

            System.out.println(
                "Path does not exist.");

            return;
        }

        if (!dir.isDirectory()) {

            System.out.println(
                "Path is not a directory.");

            return;
        }

        File[] files = dir.listFiles();

        System.out.println("\nContents:");

        if (files != null) {

            for (File file : files) {

                System.out.println(
                    file.getName());
            }
        }
    }
}
