package Assignment60;

import java.io.*;
import java.net.*;
import java.util.*;

public class StringClient 
{

    public static void main(String[] args) 
    {

        try 
        {

            Socket socket = new Socket("localhost", 5002);

            BufferedReader in =
                new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter out =
                new PrintWriter(
                    socket.getOutputStream(), true);

            Scanner sobj = new Scanner(System.in);

            while (true) 
            {

                System.out.print("Enter command : ");
                String command = sobj.nextLine();

                out.println(command);

                if (command.equalsIgnoreCase("QUIT"))
                    break;

                System.out.println("Server: " + in.readLine());
            }

            socket.close();

        } catch (Exception e) 
        {
            System.out.println(e);
        }
    }
}

