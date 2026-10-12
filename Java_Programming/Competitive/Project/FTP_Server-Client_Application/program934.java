import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class program934
{
    private static final int PORT = 9000;
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";
    private static final String LOG_FOLDER = "ServerLogs";
    private static final File SERVER_FOLDER = new File("ServerFiles");
    private static final Object FILE_TRANSFER_LOCK = new Object();
    private static final AtomicInteger CLIENT_COUNT = new AtomicInteger(0);

    public static void main(String[] args)
    {
        new File(LOG_FOLDER).mkdirs();
        SERVER_FOLDER.mkdirs();

        System.out.println("------------------------------------------------------------");
        System.out.println("          Marvellous FTP Server Started");
        System.out.println("Listening on port " + PORT);
        System.out.println("Server files folder: " + SERVER_FOLDER.getAbsolutePath());
        System.out.println("------------------------------------------------------------");

        writeLog("Server started on port " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT))
        {
            while (true)
            {
                System.out.println("Waiting for client connection...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                writeLog("Client connected: " + clientSocket.getInetAddress());

                Thread clientThread = new Thread(() -> handleClient(clientSocket));
                clientThread.start();
            }
        }
        catch (IOException e)
        {
            System.out.println("Server error: " + e.getMessage());
            writeLog("Server error: " + e.getMessage());
        }
    }

    private static void handleClient(Socket socket)
    {
        int clientId = CLIENT_COUNT.incrementAndGet();

        try (Socket client = socket;
             DataInputStream dis = new DataInputStream(new BufferedInputStream(client.getInputStream()));
             DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(client.getOutputStream())))
        {
            // Login protocol must match program935.java.
            dos.writeUTF("Connected to Marvellous Server...");
            dos.flush();
            dos.writeUTF("Enter Username : ");
            dos.flush();
            String username = dis.readUTF();

            dos.writeUTF("Enter Password : ");
            dos.flush();
            String password = dis.readUTF();

            if (!USERNAME.equals(username) || !PASSWORD.equals(password))
            {
                dos.writeUTF("LOGIN_FAILED");
                dos.flush();
                writeLog("Client " + clientId + " login failed");
                return;
            }

            dos.writeUTF("LOGIN_SUCCESS");
            dos.flush();
            System.out.println("Client " + clientId + " logged in as " + username);
            writeLog("Client " + clientId + " logged in");

            while (true)
            {
                String commandLine;
                try
                {
                    commandLine = dis.readUTF().trim();
                }
                catch (IOException e)
                {
                    break; // client disconnected
                }

                if (commandLine.isEmpty())
                {
                    dos.writeUTF("Invalid Operation...");
                    dos.flush();
                    continue;
                }

                String[] parts = commandLine.split("\\s+");
                String operation = parts[0].toUpperCase();

                switch (operation)
                {
                    case "QUIT":
                        if (parts.length != 1)
                        {
                            dos.writeUTF("Usage : QUIT");
                        }
                        else
                        {
                            dos.writeUTF("Disconnected from Server");
                            dos.flush();
                            writeLog("Client " + clientId + " disconnected");
                            return;
                        }
                        break;

                    case "LIST":
                        if (parts.length != 1)
                        {
                            dos.writeUTF("Usage : LIST");
                            break;
                        }
                        dos.writeUTF(listFiles());
                        break;

                    case "EXISTS":
                        if (parts.length != 2)
                        {
                            dos.writeUTF("Usage : EXISTS <FILENAME>");
                            break;
                        }
                        dos.writeUTF(resolveFile(parts[1]).isFile()
                                ? "File Exists." : "File does not exist");
                        break;

                    case "INFO":
                        if (parts.length != 2)
                        {
                            dos.writeUTF("Usage : INFO <FILENAME>");
                            break;
                        }
                        dos.writeUTF(getFileInfo(parts[1]));
                        break;

                    case "SIZE":
                        if (parts.length != 2)
                        {
                            dos.writeUTF("Usage : SIZE <FILENAME>");
                            break;
                        }
                        File sizeFile = resolveFile(parts[1]);
                        dos.writeUTF(sizeFile.isFile()
                                ? "File Size is : " + sizeFile.length() + " bytes"
                                : "File does not exist");
                        break;

                    case "GET":
                        if (parts.length != 2)
                        {
                            dos.writeUTF("Usage : GET <FILENAME>");
                            break;
                        }
                        sendFile(parts[1], dis, dos, clientId);
                        break;

                    case "PUT":
                        if (parts.length != 2)
                        {
                            dos.writeUTF("Usage : PUT <FILENAME>");
                            break;
                        }
                        receiveFile(parts[1], dis, dos, clientId);
                        break;

                    case "RENAME":
                        if (parts.length != 3)
                        {
                            dos.writeUTF("Usage : RENAME <OldFILENAME> <NewFILENAME>");
                            break;
                        }
                        renameFile(parts[1], parts[2], dos, clientId);
                        break;

                    case "DELETE":
                        if (parts.length != 2)
                        {
                            dos.writeUTF("Usage : DELETE <FILENAME>");
                            break;
                        }
                        deleteFile(parts[1], dos, clientId);
                        break;

                    default:
                        dos.writeUTF("Invalid Operation...");
                        break;
                }

                dos.flush();
            }
        }
        catch (Exception e)
        {
            System.out.println("Client " + clientId + " error: " + e.getMessage());
            writeLog("Client " + clientId + " error: " + e.getMessage());
        }
        finally
        {
            CLIENT_COUNT.decrementAndGet();
            System.out.println("Client " + clientId + " disconnected.");
        }
    }

    private static void sendFile(String fileName, DataInputStream dis,
                                 DataOutputStream dos, int clientId) throws IOException
    {
        File file = resolveFile(fileName);

        if (!file.isFile())
        {
            // Client expects FILE_NOT_FOUND, or otherwise assumes file size follows.
            dos.writeUTF("FILE_NOT_FOUND");
            dos.flush();
            writeLog("Client " + clientId + " GET failed; not found: " + fileName);
            return;
        }

        synchronized (FILE_TRANSFER_LOCK)
        {
            dos.writeUTF("FILE_FOUND");
            dos.flush();

            long fileSize = file.length();
            dos.writeLong(fileSize);

            try (BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file)))
            {
                byte[] buffer = new byte[8192];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1)
                {
                    dos.write(buffer, 0, bytesRead);
                }
            }

            dos.flush();
            dos.writeUTF("GET_Completed");
            dos.flush();
        }

        System.out.println("Sent file to client: " + fileName);
        writeLog("Client " + clientId + " GET success: " + fileName + " (" + file.length() + " bytes)");
    }

    private static void receiveFile(String fileName, DataInputStream dis,
                                    DataOutputStream dos, int clientId) throws IOException
    {
        File file = resolveFile(fileName);

        synchronized (FILE_TRANSFER_LOCK)
        {
            // Client waits for exactly this response before sending file length.
            dos.writeUTF("Ready");
            dos.flush();

            long fileSize = dis.readLong();
            if (fileSize < 0)
            {
                dos.writeUTF("File uploaded Failed! Invalid file size.");
                dos.flush();
                return;
            }

            long received = 0;
            try (BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(file)))
            {
                byte[] buffer = new byte[8192];

                while (received < fileSize)
                {
                    int toRead = (int)Math.min(buffer.length, fileSize - received);
                    int bytesRead = dis.read(buffer, 0, toRead);

                    if (bytesRead == -1)
                    {
                        break;
                    }

                    fos.write(buffer, 0, bytesRead);
                    received += bytesRead;
                }
            }

            if (received == fileSize)
            {
                dos.writeUTF("File uploaded Successfully!");
                writeLog("Client " + clientId + " PUT success: " + fileName + " (" + fileSize + " bytes)");
            }
            else
            {
                dos.writeUTF("File uploaded Failed!");
                writeLog("Client " + clientId + " PUT failed: " + fileName);
            }
            dos.flush();
        }
    }

    private static String listFiles()
    {
        File[] files = SERVER_FOLDER.listFiles();
        if (files == null || files.length == 0)
        {
            return "No files available";
        }

        StringBuilder result = new StringBuilder();
        for (File file : files)
        {
            if (file.isFile())
            {
                result.append(file.getName()).append('\n');
            }
        }
        return result.length() == 0 ? "No files available" : result.toString().trim();
    }

    private static String getFileInfo(String fileName)
    {
        File file = resolveFile(fileName);
        if (!file.isFile())
        {
            return "File does not exist";
        }

        return "File name : " + file.getName()
                + "\nFile size : " + file.length() + " bytes"
                + "\nReadable : " + file.canRead()
                + "\nWritable : " + file.canWrite()
                + "\nAbsolute Path : " + file.getAbsolutePath();
    }

    private static void renameFile(String oldName, String newName,
                                   DataOutputStream dos, int clientId) throws IOException
    {
        File oldFile = resolveFile(oldName);
        File newFile = resolveFile(newName);

        if (!oldFile.isFile())
        {
            dos.writeUTF("Source file does not exist");
        }
        else if (newFile.exists())
        {
            dos.writeUTF("Destination file already exists");
        }
        else if (oldFile.renameTo(newFile))
        {
            dos.writeUTF("File renamed successfully!");
            writeLog("Client " + clientId + " RENAME: " + oldName + " -> " + newName);
        }
        else
        {
            dos.writeUTF("Unable to rename file...");
        }
    }

    private static void deleteFile(String fileName, DataOutputStream dos,
                                   int clientId) throws IOException
    {
        File file = resolveFile(fileName);

        if (!file.exists())
        {
            dos.writeUTF("File does not exist.");
        }
        else if (!file.isFile())
        {
            dos.writeUTF("Specified path is not a file.");
        }
        else if (file.delete())
        {
            dos.writeUTF("File deleted successfully!");
            writeLog("Client " + clientId + " DELETE: " + fileName);
        }
        else
        {
            dos.writeUTF("Unable to delete the file...");
        }
    }

    // Only allow a simple filename, preventing access outside ServerFiles.
    private static File resolveFile(String fileName)
    {
        File file = new File(fileName);
        if (file.isAbsolute() || fileName.contains("/") || fileName.contains("\\")
                || ".".equals(fileName) || "..".equals(fileName))
        {
            return new File(SERVER_FOLDER, "__invalid_filename__");
        }
        return new File(SERVER_FOLDER, fileName);
    }

    private static synchronized void writeLog(String message)
    {
        File logFile = new File(LOG_FOLDER, "MarvellousFTP_"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ".log");
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        try (java.io.BufferedWriter writer = new java.io.BufferedWriter(
                new java.io.FileWriter(logFile, true)))
        {
            writer.write("[" + time + "] " + message);
            writer.newLine();
        }
        catch (IOException e)
        {
            System.out.println("Unable to write server log: " + e.getMessage());
        }
    }
}
