import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class program935 {
    public static void main(String[] args) {
        try (
            Scanner scanner = new Scanner(System.in);
             Socket socket = new Socket("127.0.0.1", 9000);
             DataInputStream dis = new DataInputStream(socket.getInputStream());
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {

            System.out.println("------------------------------------------------------------");
            System.out.println("          Marvellous FTP Client Started");
            System.out.println("------------------------------------------------------------");
            System.out.println(dis.readUTF());

            System.out.print(dis.readUTF());
            String username = scanner.nextLine();
            dos.writeUTF(username);
            dos.flush();

            System.out.print(dis.readUTF());
            String password = scanner.nextLine();
            dos.writeUTF(password);
            dos.flush();

            String loginResult = dis.readUTF();
            if (!"LOGIN_SUCCESS".equals(loginResult)) {
                System.out.println("Login failed. Invalid username or password.");
                return;
            }

            System.out.println("LOGIN SUCCESSFUL. Welcome " + username);

            while (true) {
                System.out.println("\nCommands: LIST, EXISTS <file>, INFO <file>, SIZE <file>,");
                System.out.println("          GET <file>, PUT <file>, RENAME <old> <new>, DELETE <file>, QUIT");
                System.out.print("Enter Command : ");

                String command = scanner.nextLine().trim();
                if (command.isEmpty()) {
                    System.out.println("Please enter a command.");
                    continue;
                }

                String[] parts = command.split("\\s+");
                String operation = parts[0].toUpperCase();

                if (operation.equals("GET")) {
                    if (parts.length != 2) {
                        System.out.println("Usage : GET <FILENAME>");
                        continue;
                    }

                    dos.writeUTF(command);
                    dos.flush();
                    String response = dis.readUTF();

                    if ("FILE_NOT_FOUND".equals(response)) {
                        System.out.println("File not found on server.");
                        continue;
                    }
                    if (!"FILE_FOUND".equals(response)) {
                        System.out.println(response);
                        continue;
                    }

                    long fileSize = dis.readLong();
                    String outputName = "Download_" + new File(parts[1]).getName();
                    long received = 0;

                    try (FileOutputStream fos = new FileOutputStream(outputName)) {
                        byte[] buffer = new byte[8192];
                        while (received < fileSize) {
                            int count = dis.read(buffer, 0,
                                    (int) Math.min(buffer.length, fileSize - received));
                            if (count == -1) {
                                break;
                            }
                            fos.write(buffer, 0, count);
                            received += count;
                        }
                    }

                    if (received == fileSize) {
                        String completed = dis.readUTF();
                        if ("GET_Completed".equals(completed)) {
                            System.out.println("Download completed: " + outputName);
                        } else {
                            System.out.println("Unexpected server response: " + completed);
                        }
                    } else {
                        System.out.println("Download failed.");
                    }
                } else if (operation.equals("PUT")) {
                    if (parts.length != 2) {
                        System.out.println("Usage : PUT <FILENAME>");
                        continue;
                    }

                    File file = new File(parts[1]);
                    if (!file.isFile()) {
                        System.out.println("File does not exist on client.");
                        continue;
                    }

                    dos.writeUTF(command);
                    dos.flush();
                    String response = dis.readUTF();

                    if (!"Ready".equals(response)) {
                        System.out.println(response);
                        continue;
                    }

                    dos.writeLong(file.length());
                    try (FileInputStream fis = new FileInputStream(file)) {
                        byte[] buffer = new byte[8192];
                        int count;
                        while ((count = fis.read(buffer)) != -1) {
                            dos.write(buffer, 0, count);
                        }
                    }
                    dos.flush();
                    System.out.println(dis.readUTF());
                } else if (operation.equals("LIST") || operation.equals("QUIT")) {
                    if (parts.length != 1) {
                        System.out.println("Usage : " + operation);
                        continue;
                    }
                    dos.writeUTF(command);
                    dos.flush();
                    String response = dis.readUTF();
                    System.out.println(response);
                    if (operation.equals("QUIT")) {
                        break;
                    }
                } else if (operation.equals("INFO") || operation.equals("SIZE")
                        || operation.equals("EXISTS") || operation.equals("DELETE")) {
                    if (parts.length != 2) {
                        System.out.println("Usage : " + operation + " <FILENAME>");
                        continue;
                    }
                    dos.writeUTF(command);
                    dos.flush();
                    System.out.println(dis.readUTF());
                } else if (operation.equals("RENAME")) {
                    if (parts.length != 3) {
                        System.out.println("Usage : RENAME <OldFILENAME> <NewFILENAME>");
                        continue;
                    }
                    dos.writeUTF(command);
                    dos.flush();
                    System.out.println(dis.readUTF());
                } else {
                    System.out.println("There is no such command.");
                }
            }
        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
