package Assignment60;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class A303 
{
    public static void main(String[] args) 
    {

        try 
        {

            Socket socket = new Socket("localhost", 5000);

            BufferedReader in =
                new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter out =
                new PrintWriter(socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);

            while (true) 
            {

                System.out.print("Enter command : ");
                String command = sc.nextLine();

                out.println(command);

                if (command.equalsIgnoreCase("QUIT"))
                    break;

                System.out.println("Server: " + in.readLine());
            }

            socket.close();

        } catch (Exception e) 
        {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
