package Assignment60;

import java.io.*;
import java.net.*;

public class FileExistsServer {

    public static void main(String[] args)
        throws Exception {

        ServerSocket ss =
            new ServerSocket(5004);

        System.out.println(
            "File Exists Server Started...");

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
                            socket.getOutputStream(),
                            true);

                    String command;

                    while ((command = in.readLine()) != null) {

                        if (command.equalsIgnoreCase("QUIT"))
                            break;

                        String[] p =
                            command.split("\\s+", 2);

                        if (p.length == 2
                            && p[0].equalsIgnoreCase("EXISTS")) {

                            File file =
                                new File(p[1]);

                            if (file.exists()) {

                                out.println(
                                    file.getName()
                                    + " exists on server");

                            } else {

                                out.println(
                                    file.getName()
                                    + " does not exist");
                            }

                        } else {

                            out.println(
                                "Invalid command");
                        }
                    }

                    socket.close();

                } catch (Exception e) {

                    System.out.println(e);
                }

            }).start();
        }
    }
}