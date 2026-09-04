package Assignment60;

import java.io.*;
import java.util.*;

public class FileCopy {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter source file: ");
        String source = sc.nextLine();

        System.out.print("Enter destination file: ");
        String destination = sc.nextLine();

        try {

            FileInputStream fis =
                new FileInputStream(source);

            FileOutputStream fos =
                new FileOutputStream(destination);

            byte[] buffer = new byte[1024];

            int n;

            while ((n = fis.read(buffer)) != -1) {

                fos.write(buffer, 0, n);
            }

            fis.close();
            fos.close();

            System.out.println(
                "File copied successfully");

        } catch (IOException e) {

            System.out.println(
                "Error : " + e.getMessage());
        }
    }
}
