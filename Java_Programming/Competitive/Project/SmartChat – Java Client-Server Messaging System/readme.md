# 💬 SmartChat – Java-Based Real-Time Client-Server Chat Application

## 📌 Project Overview

**SmartChat** is a GUI-based real-time chat application developed using **Java**.

The application uses **TCP Socket Programming** to establish communication between a **Chat Server** and a **Chat Client**.

The project provides a simple login interface and a graphical chat interface where the client and server can send and receive messages in real time.

---

## 🎯 Project Title

**SmartChat – Java-Based Real-Time Client-Server Chat Application**

---

## 👩‍💻 Author

**Vaishnavi Morankar**

---

## 🛠️ Technologies Used

- Java
- Java Swing
- Java AWT
- TCP Socket Programming
- Multithreading
- Object-Oriented Programming
- File I/O

---

## 💻 Platform

- Windows
- Java JDK
- Command Prompt / VS Code / Eclipse / IntelliJ IDEA

---

## 🔌 Networking

| Parameter | Value |
|---|---|
| Communication | Client-Server |
| Protocol | TCP |
| Port Number | 2100 |
| Server Address | localhost / Server IP |
| Programming Language | Java |

---

# ✨ Features

### 🔐 Login System

- Username and password based login
- Login validation
- Login success and error messages

### 🖥️ Server GUI

- Graphical Server Login
- Server status display
- Client connection notification
- Send messages to client
- Receive messages from client
- Disconnect functionality

### 💻 Client GUI

- Graphical Client Login
- Server IP input
- Connection with server
- Send messages to server
- Receive messages from server
- Disconnect functionality

### ⚡ Real-Time Communication

The application uses Java threads to handle incoming messages without freezing the GUI.

---

# 🏗️ Project Architecture

```text
                    SMARTCHAT
                       |
             -----------------------
             |                     |
             ▼                     ▼
       ChatServer.java       ChatClient.java
             |                     |
             ▼                     ▼
        Server GUI              Client GUI
             |                     |
             |      TCP Socket      |
             |<------------------->|
             |       Port 2100      |
             |                     |
             ▼                     ▼
       Send / Receive        Send / Receive
          Messages              Messages

📂 Project Structure
SmartChat-Java-Chat-Application/
│
├── ChatServer.java
├── ChatClient.java
├── README.md
│
└── screenshots/
    ├── 01_Server_Login.png
    ├── 02_Server_Started.png
    ├── 03_Client_Login.png
    ├── 04_Chat_Connected.png

🔄 Working Flow
                START
                  |
                  ▼
          Start Chat Server
                  |
                  ▼
          Server Login Page
                  |
                  ▼
        Username & Password
                  |
                  ▼
        Server Authentication
                  |
                  ▼
          Server GUI Started
                  |
                  ▼
        Server waits on Port 2100
                  |
                  ▼
          Start Chat Client
                  |
                  ▼
          Client Login Page
                  |
                  ▼
       Enter Server IP Address
                  |
                  ▼
        Client Authentication
                  |
                  ▼
        Connect to Server
                  |
                  ▼
          Chat Communication
                  |
          -----------------
          |               |
          ▼               ▼
     Send Message    Receive Message
          |               |
          -----------------
                  |
                  ▼
              Disconnect
                  |
                  ▼
                 END
🔑 Login Credentials

The current demonstration version uses the following credentials:

Username : admin
Password : admin123
Client Server IP

For testing on the same computer:

localhost

For connecting from another computer on the same network:

Server Computer IPv4 Address

Example:

192.168.1.10

⚠️ The current project uses hard-coded demonstration credentials. For production use, authentication should be connected to a database and passwords should be securely hashed.

⚙️ Requirements

Before running the project, make sure Java is installed.

Check Java:

java -version

Check Java compiler:

javac -version

Recommended:

JDK 8 or higher
▶️ How to Run the Project
Step 1 – Open Project Folder

Open Command Prompt inside the project folder.

Example:

cd Desktop\project\java\Chat_Messenger_with_Logging
Step 2 – Compile the Programs

Compile both files:

javac ChatServer.java ChatClient.java

If there are no errors, compilation is successful.

🖥️ Step 3 – Start the Server

Run:

java ChatServer

The Server Login page will appear.

Enter:

Username : admin
Password : admin123

Click:

LOGIN

The server will start listening on:

Port 2100
💻 Step 4 – Start the Client

Open another Command Prompt window.

Go to the same project folder.

Run:

java ChatClient

Enter:

Username : admin
Password : admin123
Server IP : localhost

Click:

LOGIN

The client will connect to the server.

💬 Step 5 – Start Chatting
Client → Server

Enter a message in the client:

Hello Server

Click:

SEND

The server receives:

Client : Hello Server
Server → Client

Enter:

Hello Client

Click:

SEND

The client receives:

Server : Hello Client
🛑 Stop the Application

To stop the Java application from CMD:

Ctrl + C

To disconnect from the GUI:

DISCONNECT
📸 Screenshots
1. Server Login

Server authentication interface.

2. Server Started

Server successfully started and waiting for a client on port 2100.

3. Client Login

Client login interface with Server IP field.

4. Chat Connected

Client successfully connected with the server.

5. Chat Communication

Real-time communication between client and server.

🧵 Multithreading

The application uses Java threads to handle network communication.

The receiving operation runs in a separate thread so that the GUI remains responsive.

Example:

Thread receiveThread =
    new Thread(
        new Runnable()
        {
            public void run()
            {
                receiveMessages();
            }
        }
    );

receiveThread.start();

This prevents the GUI from becoming unresponsive while waiting for incoming messages.

🔗 Socket Programming

The server creates a ServerSocket:

ServerSocket ssobj =
    new ServerSocket(2100);

The server waits for a client:

Socket sobj =
    ssobj.accept();

The client connects using:

Socket socket =
    new Socket(serverIP, 2100);
📡 Communication

The project uses:

TCP

TCP provides reliable and ordered communication between the client and server.

📚 Java Concepts Used

This project demonstrates several important Java concepts:

Classes and Objects
Constructors
Inheritance
Encapsulation
Exception Handling
Java Swing
Java AWT
Event Handling
ActionListener
Socket Programming
ServerSocket
InputStream
OutputStream
BufferedReader
PrintStream
Multithreading
GUI Programming

🧩 Main Classes
ChatServer.java

Responsible for:

Server login
Creating ServerSocket
Accepting client connection
Sending messages
Receiving messages
Managing server GUI
Disconnecting client
ChatClient.java

Responsible for:

Client login
Connecting to server
Sending messages
Receiving messages
Managing client GUI
Disconnecting from server
🔐 Security Note

This project is created for educational and demonstration purposes.

The current version uses:

Username : admin
Password : admin123

For a production-level application, the following improvements are recommended:

Database-based authentication
Password hashing
User registration
Session management
Secure communication
Input validation
Encrypted communication using SSL/TLS

🚀 Future Enhancements

The project can be further improved by adding:

 Multiple client support
 User registration
 Database authentication
 Password encryption
 Online users list
 Private messaging
 Group chat
 File sharing
 Image sharing
 Emoji support
 Message timestamps
 Chat history
 Search messages
 Dark mode
 SSL/TLS security
 Admin panel

🏆 Learning Outcomes

After completing this project, the following concepts can be understood:

How client-server architecture works
How TCP socket communication works
How Java ServerSocket works
How Java Socket works
How to create GUI applications using Swing
How to handle GUI events
How to use Java threads
How to send and receive data through sockets
How to connect two Java applications
How to build and organize a Java GitHub project

📌 Limitations

The current version has some limitations:

Supports one client at a time
Uses demonstration login credentials
No database
No message encryption
No permanent chat history
Designed mainly for educational purposes

🎓 Project Type
Academic / Educational Project
Domain
Java
Networking
GUI Application
Client-Server Communication
Socket Programming

📜 License

This project is created for educational and academic purposes.

You are free to study, modify and improve the project.

⭐ Acknowledgement

This project was developed as a learning project to understand:

Java GUI Programming + TCP Socket Programming + Client-Server Architecture + Multithreading

### GitHub repository structure
```text
SmartChat-Java-Chat-Application
│
├── ChatServer.java
├── ChatClient.java
├── README.md
│
└── screenshots
    ├── 01_Server_Login.png
    ├── 02_Server_Started.png
    ├── 03_Client_Login.png
    ├── 04_Chat_Connected.png


Repository title: SmartChat – Java-Based Real-Time Client-Server Chat Application
Repository name: programming\Java_Programming\Competitive\project\SmartChat-Java-Chat-Application
