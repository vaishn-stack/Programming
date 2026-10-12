# FTP Client-Server System

A simple FTP-style file transfer application developed in Java using socket programming. The project demonstrates client-server communication, authentication, file upload and download, and basic file management commands.

## Features

- Client-server communication using Java Sockets
- Login authentication
- List files stored on the server
- Check whether a file exists
- View file information and size
- Upload files from client to server
- Download files from server to client
- Rename files on the server
- Delete files from the server
- Server-side file storage and logging

## Technologies Used

- Java
- Java Sockets (`Socket`, `ServerSocket`)
- Data streams (`DataInputStream`, `DataOutputStream`)
- File handling (`FileInputStream`, `FileOutputStream`)
- Multithreading (if implemented in the server code)

## Project Structure

```text
FTP_Server/
├── program934.java       # FTP Server
├── ServerFiles/          # Files stored on the server (created at runtime)
├── ServerLogs/           # Server logs (created at runtime)
└── client/
    ├── program935.java   # FTP Client
    └── sample.txt        # Example file to upload
```

> The `ServerFiles` and `ServerLogs` directories may be created automatically when the server runs.

## Requirements

- Java JDK installed
- Windows PowerShell or Command Prompt
- Port `9000` available on the computer

Check your Java installation:

```powershell
java -version
javac -version
```

## How to Run

### 1. Start the Server

Open a PowerShell terminal and navigate to the folder containing `program934.java`:

```powershell
cd C:\Users\vaish\onedrive\desktop\lb\FTP_Server
```

Compile and run the server:

```powershell
javac program934.java
java program934
```

If your server uses Java source-file mode, you can also run:

```powershell
java program934.java
```

Keep the server terminal open while using the client.

### 2. Start the Client

Open a **second** PowerShell terminal:

```powershell
cd C:\Users\vaish\onedrive\desktop\lb\FTP_Server\client
```

Compile and run the client:

```powershell
javac program935.java
java program935
```

You can also use Java source-file mode:

```powershell
java program935.java
```

### 3. Log In

Use the credentials configured in your server code. In the current example:

```text
Username: admin
Password: admin123
```

**Security note:** These are demonstration credentials. Do not use hard-coded credentials or an unencrypted connection for sensitive or production file transfers.

## Available Commands

Enter these commands at the client's `Enter Command :` prompt.

| Command | Description |
|---|---|
| `LIST` | Lists files available on the server |
| `EXISTS <filename>` | Checks whether a file exists on the server |
| `INFO <filename>` | Displays information about a server file |
| `SIZE <filename>` | Displays the size of a server file |
| `PUT <filename>` | Uploads a file from the client working directory to the server |
| `GET <filename>` | Downloads a file from the server to the client |
| `RENAME <oldname> <newname>` | Renames a file on the server |
| `DELETE <filename>` | Deletes a file from the server |
| `QUIT` | Closes the client session |

## Example Session

First, create a test file in the client folder using a separate PowerShell terminal:

```powershell
Set-Content sample.txt "Hello from Marvellous FTP Client"
```

Then, in the running client, enter:

```text
PUT sample.txt
LIST
EXISTS sample.txt
SIZE sample.txt
GET sample.txt
QUIT
```

The `PUT` command expects the file to exist in the client's current working directory. Files checked by `LIST`, `EXISTS`, `INFO`, and `SIZE` are server-side files stored in `ServerFiles`.

## Troubleshooting

### Login failed
- Check the username and password configured in the server source code.
- Ensure the client and server use matching credentials.
- The current example credentials are `admin` and `admin123`.

### Connection refused
- Start the server before starting the client.
- Confirm the server is listening on port `9000`.
- Check whether a firewall or another application is blocking the port.

### File does not exist on client
- Ensure the file exists in the client's current working directory before running `PUT`.
- Check the spelling and extension of the filename.

### `LIST` shows no files
- Upload a file with `PUT <filename>` first, or place a file in the server's `ServerFiles` directory.

## Learning Outcomes

This project provides practice with:
- Java socket programming
- Client-server architecture
- Data input/output streams
- File transfer using byte streams
- Basic authentication and command parsing
- File and directory handling

## Future Improvements

- Secure authentication and encrypted communication
- Better error handling and transfer integrity checks
- Progress indicators for large files
- User roles and permissions
- Improved logging and automated tests

## Author

**Vaishnavi Morankar**

---

This is an educational FTP-style project and is not intended to replace a secure, production FTP/SFTP server.

