package Assignment60;

import java.io.*;
import java.net.*;

public class ServerFileInfoServer {

    static String getInfo(String fileName) {

        File file = new File(fileName);

        if (!file.exists()) {

            return fileName
                + " does not exist";
        }

        return
            "File Name     : "
            + file.getName()
            + "\n"

            + "Size          : "
            + file.length()
            + " bytes"
            + "\n"

            + "Readable      : "
            + file.canRead()
            + "\n"

            + "Writable      : "
            + file.canWrite()
            + "\n"

            + "Absolute Path : "
            + file.getAbsolutePath();
    }

    public static void main(String[] args)
        throws Exception {

        ServerSocket ss =
            new ServerSocket(5005);

        System.out.println(
            "File Info Server Started...");

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
                            && p[0].equalsIgnoreCase("INFO")) {

                            String result =
                                getInfo(p[1]);

                            out.println(
                                result.replace("\n", " | "));

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
