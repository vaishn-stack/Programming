package Assignment60;

import java.io.*;
import java.util.*;

public class SearchFile {

    static File search(File dir, String fileName) {

        File[] files = dir.listFiles();

        if (files == null)
            return null;

        for (File file : files) {

            if (file.isFile()
                && file.getName()
                    .equalsIgnoreCase(fileName)) {

                return file;
            }

            if (file.isDirectory()) {

                File result =
                    search(file, fileName);

                if (result != null)
                    return result;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter directory: ");
        String path = sc.nextLine();

        System.out.print("Enter file to search: ");
        String fileName = sc.nextLine();

        File dir = new File(path);

        if (!dir.exists() || !dir.isDirectory()) {

            System.out.println(
                "Invalid directory.");

            return;
        }

        File result =
            search(dir, fileName);

        if (result == null) {

            System.out.println(
                fileName + " not found");

        } else {

            System.out.println(
                "\nFile found");

            System.out.println(
                "Name : "
                + result.getName());

            System.out.println(
                "Size : "
                + result.length()
                + " bytes");

            System.out.println(
                "Path : "
                + result.getAbsolutePath());
        }
    }
}
