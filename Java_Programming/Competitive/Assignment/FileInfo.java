package Assignment60;
import java.io.*;
import java.util.*;

public class FileInfo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String name = sc.nextLine();

        File file = new File(name);

        if (!file.exists()) {

            System.out.println(
                "File does not exist.");

            return;
        }

        System.out.println(
            "File Name     : "
            + file.getName());

        System.out.println(
            "Absolute Path : "
            + file.getAbsolutePath());

        System.out.println(
            "File Size     : "
            + file.length()
            + " bytes");

        System.out.println(
            "Readable      : "
            + file.canRead());

        System.out.println(
            "Writable      : "
            + file.canWrite());

        System.out.println(
            "Hidden        : "
            + file.isHidden());

        System.out.println(
            "Last Modified : "
            + new Date(file.lastModified()));
    }
}
