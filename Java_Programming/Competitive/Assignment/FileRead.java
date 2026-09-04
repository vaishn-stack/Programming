package Assignment60;

import java.io.*;
import java.util.*;

public class FileRead {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();

        try {

            FileInputStream fis =
                new FileInputStream(fileName);

            int ch;

            System.out.println("\nFile contents:");

            while ((ch = fis.read()) != -1) {

                System.out.print((char) ch);
            }

            fis.close();

        } catch (FileNotFoundException e) {

            System.out.println(
                "File does not exist.");

        } catch (IOException e) {

            System.out.println(
                "Error : " + e.getMessage());
        }
    }
}