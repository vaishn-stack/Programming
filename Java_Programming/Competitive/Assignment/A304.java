package Assignment60;

import java.io.*;
import java.net.*;

public class A304 
{
    static boolean isPrime(int n) 
    {

        if (n < 2)
            return false;

        for (int i = 2; i * i <= n; i++)
        {

            if (n % i == 0)
                return false;
        }

        return true;
    }

    static String process(String command) 
    {

        try 
        {

            String[] p = command.trim().split("\\s+");

            if (p.length != 2)
                return "Invalid command";

            String op = p[0].toUpperCase();
            int n = Integer.parseInt(p[1]);

            switch (op) 
            {

                case "EVEN":
                    return n % 2 == 0 ?
                        n + " is Even" :
                        n + " is not Even";

                case "ODD":
                    return n % 2 != 0 ?
                        n + " is Odd" :
                        n + " is not Odd";

                case "PRIME":
                    return isPrime(n) ?
                        n + " is a Prime Number" :
                        n + " is not a Prime Number";

                case "PERFECT":

                    int sum = 0;

                    for (int i = 1; i <= n / 2; i++) 
                    {

                        if (n % i == 0)
                            sum += i;
                    }

                    return sum == n ?
                        n + " is a Perfect Number" :
                        n + " is not a Perfect Number";

                case "FACTORIAL":

                    long fact = 1;

                    for (int i = 1; i <= n; i++)
                        fact = fact * i;

                    return "Factorial is : " + fact;

                case "REVERSE":

                    int rev = 0;
                    int temp = n;

                    while (temp != 0) 
                    {

                        int digit = temp % 10;
                        rev = rev * 10 + digit;
                        temp = temp / 10;
                    }

                    return "Reverse is : " + rev;

                default:
                    return "Invalid command";
            }

        } catch (Exception e) 
        {

            return "Invalid command or number";
        }
    }

    public static void main(String[] args) throws Exception 
    {

        ServerSocket ss = new ServerSocket(5001);

        System.out.println("Number Server Started...");

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

