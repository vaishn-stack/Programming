package Assignment60;

import java.io.*;
import java.net.*;
import java.time.*;
import java.time.format.*;

public class InfoServer {

    static String process(String command) {

        switch (command.toUpperCase()) {

            case "DATE":

                return LocalDate.now()
                    .format(
                        DateTimeFormatter.ofPattern(
                            "dd-MM-yyyy"));

            case "TIME":

                return LocalTime.now()
                    .format(
                        DateTimeFormatter.ofPattern(
                            "HH:mm:ss"));

            case "SERVERNAME":

                try {
                    return InetAddress
                        .getLocalHost()
                        .getHostName();
                }
                catch (Exception e) {
                    return "Unknown Server";
                }

            case "HELP":

                return "Available Commands:\n"
                    + "DATE\n"
                    + "TIME\n"
                    + "SERVERNAME\n"
                    + "HELP\n"
                    + "QUIT";

            default:
                return "Invalid command";
        }
    }

    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(5003);

        System.out.println("Information Server Started...");

        while (true) {

            Socket socket = ss.accept();

            new Thread(() -> {

                try {

                    BufferedReader in =
                        new BufferedReader(
                            new InputStreamReader(
                                socket.getInputStream()));

                    PrintWriter out =
                        new PrintWriter(
                            socket.getOutputStream(), true);

                    String command;

                    while ((command = in.readLine()) != null) {

                        if (command.equalsIgnoreCase("QUIT"))
                            break;

                        out.println(
                            process(command)
                            .replace("\n", " | "));
                    }

                    socket.close();

                } catch (Exception e) {
                    System.out.println(e);
                }

            }).start();
        }
    }
}
