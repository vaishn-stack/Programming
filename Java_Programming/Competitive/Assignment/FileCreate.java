package Assignment60;

import java.io.*;
import java.util.*;

public class FileCreate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String name = sc.nextLine();

        File file = new File(name);

        try {

            boolean result = file.createNewFile();

            System.out.println("File Name : "
                    + file.getName());

            System.out.println("Absolute Path : "
                    + file.getAbsolutePath());

            if (result)
                System.out.println(
                    file.getName()
                    + " created successfully");
            else
                System.out.println(
                    file.getName()
                    + " already exists");

        } catch (IOException e) {

            System.out.println(
                "File creation failed");
        }
    }
}
