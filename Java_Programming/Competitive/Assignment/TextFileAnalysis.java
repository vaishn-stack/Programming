package Assignment60;

import java.io.*;
import java.util.*;

public class TextFileAnalysis {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("File : ");
        String fileName = sc.nextLine();

        int characters = 0;
        int words = 0;
        int lines = 0;
        int uppercase = 0;
        int lowercase = 0;
        int digits = 0;
        int spaces = 0;

        try {

            FileInputStream fis =
                new FileInputStream(fileName);

            BufferedReader br =
                new BufferedReader(
                    new InputStreamReader(fis));

            String line;

            while ((line = br.readLine()) != null) {

                lines++;

                characters += line.length();

                if (!line.trim().isEmpty()) {

                    words +=
                        line.trim()
                            .split("\\s+")
                            .length;
                }

                for (char c : line.toCharArray()) {

                    if (Character.isUpperCase(c))
                        uppercase++;

                    if (Character.isLowerCase(c))
                        lowercase++;

                    if (Character.isDigit(c))
                        digits++;

                    if (c == ' ')
                        spaces++;
                }
            }

            br.close();
            fis.close();

            System.out.println(
                "Characters : " + characters);

            System.out.println(
                "Words      : " + words);

            System.out.println(
                "Lines      : " + lines);

            System.out.println(
                "Uppercase  : " + uppercase);

            System.out.println(
                "Lowercase  : " + lowercase);

            System.out.println(
                "Digits     : " + digits);

            System.out.println(
                "Spaces     : " + spaces);

        } catch (FileNotFoundException e) {

            System.out.println(
                "File does not exist.");

        } catch (IOException e) {

            System.out.println(
                "Error : " + e.getMessage());
        }
    }
}
