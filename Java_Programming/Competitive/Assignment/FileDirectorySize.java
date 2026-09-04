package Assignment60;
import java.io.*;
import java.util.*;

public class FileDirectorySize {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter directory: ");
        String path = sc.nextLine();

        File dir = new File(path);

        if (!dir.exists() || !dir.isDirectory()) {

            System.out.println(
                "Invalid directory.");

            return;
        }

        File[] files = dir.listFiles();

        if (files != null) {

            for (File file : files) {

                if (file.isFile()) {

                    System.out.println(
                        "[FILE] "
                        + file.getName()
                        + "    "
                        + file.length()
                        + " bytes");

                } else if (file.isDirectory()) {

                    System.out.println(
                        "[DIR]  "
                        + file.getName());
                }
            }
        }
    }
}
