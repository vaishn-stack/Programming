package Assignment60;

import java.io.*;
import java.net.*;

public class StringServer 
{

    static String process(String command) 
    {

        String[] p = command.trim().split("\\s+", 2);

        if (p.length < 2)
            return "Invalid command";

        String op = p[0].toUpperCase();
        String str = p[1];

        switch (op) 
        {

            case "LENGTH":
                return "Length is : " + str.length();

            case "UPPER":
                return str.toUpperCase();

            case "LOWER":
                return str.toLowerCase();

            case "REVERSE":
                return new StringBuilder(str)
                        .reverse()
                        .toString();

            case "PALINDROME":

                String rev =
                    new StringBuilder(str)
                        .reverse()
                        .toString();

                if (str.equalsIgnoreCase(rev))
                    return "Palindrome";
                else
                    return "Not a Palindrome";

            case "VOWELS":

                int count = 0;

                for (char c : str.toLowerCase().toCharArray()) 
                {

                    if ("aeiou".indexOf(c) != -1)
                        count++;
                }

                return "Number of vowels : " + count;

            default:
                return "Invalid command";
        }
    }

    public static void main(String[] args) throws Exception 
    {

        ServerSocket ss = new ServerSocket(5002);

        System.out.println("String Server Started...");

        while (true) 
        {

            Socket socket = ss.accept();

            new Thread(() -> {

                try 
                {

                    BufferedReader in =
                        new BufferedReader(
                            new InputStreamReader(
                                socket.getInputStream()));

                    PrintWriter out =
                        new PrintWriter(
                            socket.getOutputStream(), true);

                    String command;

                    while ((command = in.readLine()) != null) 
                    {

                        if (command.equalsIgnoreCase("QUIT"))
                            break;

                        out.println(process(command));
                    }

                    socket.close();

                } catch (Exception e) 
                {
                    System.out.println(e);
                }

            }).start();
        }
    }
}