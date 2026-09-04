package Assignment60;

import java.io.*;
import java.util.*;

public class FileWrite {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();

        System.out.print("Enter data: ");
        String data = sc.nextLine();

        try {

            FileOutputStream fos =
                new FileOutputStream(fileName);

            fos.write(data.getBytes());

            fos.close();

            System.out.println(
                "Data written successfully");

        } catch (IOException e) {

            System.out.println(
                "Error : " + e.getMessage());
        }
    }
}
