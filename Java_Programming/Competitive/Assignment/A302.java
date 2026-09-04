import java.io.*;
import java.net.*;

public class A302 
{

    static double calculate(String command) throws Exception 
    {
        String[] p = command.trim().split("\\s+");

        if (p.length != 3)
            throw new Exception("Invalid command");

        String op = p[0].toUpperCase();
        double a = Double.parseDouble(p[1]);
        double b = Double.parseDouble(p[2]);

        switch (op) 
        {
            case "ADD":
                return a + b;

            case "SUB":
                return a - b;

            case "MULT":
                return a * b;

            case "DIV":
                if (b == 0)
                {
                    throw new Exception("Division by zero");
                }
                return a / b;

            case "MOD":
                if (b == 0)
                {
                    throw new Exception("Division by zero");
                }
                return a % b;

            case "MAX":
                return Math.max(a, b);

            case "MIN":
                return Math.min(a, b);

            default:
                throw new Exception("Invalid command");
        }
    }

    static class ClientHandler extends Thread 
    {

        Socket socket;

        ClientHandler(Socket socket) 
        {
            this.socket = socket;
        }

        public void run() 
        {

            try 
            {
                BufferedReader in =
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));

                PrintWriter out =
                    new PrintWriter(socket.getOutputStream(), true);

                String command;

                while ((command = in.readLine()) != null)
                {

                    if (command.equalsIgnoreCase("QUIT"))
                    {
                        break;
                    }

                    try 
                    {
                        double result = calculate(command);
                        out.println("Result is : " + result);
                    }
                    catch (Exception e) 
                    {
                        out.println("Error : " + e.getMessage());
                    }
                }

                socket.close();

            } catch (Exception e) 
            {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(5000);

        System.out.println("Server started...");

        while (true) {

            Socket socket = ss.accept();

            ClientHandler ch = new ClientHandler(socket);
            ch.start();
        }
    }
}