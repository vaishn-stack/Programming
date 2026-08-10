/*
====================================================================
                    MARVELLOUS CHAT APPLICATION
====================================================================

Project Name : Marvellous Chat Application

File Name    : ChatClient.java

Description  : This file implements the GUI based chat client.
               The client connects with the Chat Server using
               Java Socket Programming.

Technology   : Java
GUI          : Java Swing
Networking   : Socket Programming
Protocol     : TCP
Port Number  : 2100

Features     :
1. GUI based Login Page
2. Username and Password Authentication
3. Server IP Address Input
4. Connection with Chat Server
5. Send Messages
6. Receive Messages
7. Disconnect from Server
8. Real-time communication using Threads

Author       : Vaishnavi Morankar
Project      : Java GUI Chat Application

====================================================================
*/

import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatClient extends JFrame implements ActionListener
{
    // Login components
    JLabel ltitle, luser, lpass, lip;
    JTextField tuser, tip;
    JPasswordField tpass;
    JButton blogin;

    // Chat components
    JTextArea chatArea;
    JTextField messageField;
    JButton sendButton, disconnectButton;

    Socket sobj;
    PrintStream pobj;
    BufferedReader bobj;

    String username;

    ChatClient()
    {
        setTitle("Marvellous Chat - Client Login");
        setSize(450, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ltitle = new JLabel("MARVELLOUS CHAT");
        ltitle.setFont(new Font("Arial", Font.BOLD, 24));
        ltitle.setBounds(100, 25, 280, 35);
        add(ltitle);

        luser = new JLabel("Username :");
        luser.setBounds(50, 90, 100, 30);
        add(luser);

        tuser = new JTextField();
        tuser.setBounds(160, 90, 200, 30);
        add(tuser);

        lpass = new JLabel("Password :");
        lpass.setBounds(50, 135, 100, 30);
        add(lpass);

        tpass = new JPasswordField();
        tpass.setBounds(160, 135, 200, 30);
        add(tpass);

        lip = new JLabel("Server IP :");
        lip.setBounds(50, 180, 100, 30);
        add(lip);

        tip = new JTextField("localhost");
        tip.setBounds(160, 180, 200, 30);
        add(tip);

        blogin = new JButton("LOGIN");
        blogin.setBounds(150, 240, 120, 35);
        blogin.addActionListener(this);
        add(blogin);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == blogin)
        {
            username = tuser.getText();

            String password =
                new String(tpass.getPassword());

            if(username.length() == 0 ||
               password.length() == 0)
            {
                JOptionPane.showMessageDialog(
                    this,
                    "Please enter Username and Password"
                );

                return;
            }

            if(username.equals("admin") &&
               password.equals("admin123"))
            {
                JOptionPane.showMessageDialog(
                    this,
                    "Login Successful!"
                );

                dispose();

                new ChatWindow(
                    username,
                    tip.getText()
                );
            }
            else
            {
                JOptionPane.showMessageDialog(
                    this,
                    "Invalid Username or Password",
                    "Login Failed",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    class ChatWindow extends JFrame implements ActionListener
    {
        JTextArea chatArea;
        JTextField messageField;

        JButton sendButton;
        JButton disconnectButton;

        String username;
        String serverIP;

        Socket socket;
        PrintStream out;
        BufferedReader in;

        ChatWindow(String username, String serverIP)
        {
            this.username = username;
            this.serverIP = serverIP;

            setTitle(
                "Marvellous Chat - " + username
            );

            setSize(650, 550);
            setLayout(new BorderLayout());
            setLocationRelativeTo(null);

            setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
            );

            JLabel title = new JLabel(
                "MARVELLOUS CHAT CLIENT",
                JLabel.CENTER
            );

            title.setFont(
                new Font(
                    "Arial",
                    Font.BOLD,
                    22
                )
            );

            add(title, BorderLayout.NORTH);

            chatArea = new JTextArea();
            chatArea.setEditable(false);

            chatArea.setFont(
                new Font(
                    "Arial",
                    Font.PLAIN,
                    16
                )
            );

            JScrollPane scrollPane =
                new JScrollPane(chatArea);

            add(
                scrollPane,
                BorderLayout.CENTER
            );

            JPanel bottomPanel =
                new JPanel(new BorderLayout());

            messageField = new JTextField();

            sendButton = new JButton("SEND");
            disconnectButton = new JButton("DISCONNECT");

            sendButton.addActionListener(this);
            disconnectButton.addActionListener(this);

            bottomPanel.add(
                messageField,
                BorderLayout.CENTER
            );

            JPanel buttonPanel = new JPanel();

            buttonPanel.add(sendButton);
            buttonPanel.add(disconnectButton);

            bottomPanel.add(
                buttonPanel,
                BorderLayout.EAST
            );

            add(
                bottomPanel,
                BorderLayout.SOUTH
            );

            setVisible(true);

            connectToServer();
        }

        void connectToServer()
        {
            try
            {
                chatArea.append(
                    "Connecting to server...\n"
                );

                socket =
                    new Socket(
                        serverIP,
                        2100
                    );

                chatArea.append(
                    "Connected to server successfully!\n"
                );

                chatArea.append(
                    "Welcome " +
                    username +
                    "!\n\n"
                );

                out =
                    new PrintStream(
                        socket.getOutputStream()
                    );

                in =
                    new BufferedReader(
                        new InputStreamReader(
                            socket.getInputStream()
                        )
                    );

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
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(
                    this,
                    "Unable to connect to server!\n"
                    + e.getMessage(),
                    "Connection Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }

        void receiveMessages()
        {
            try
            {
                String message;

                while(
                    (message = in.readLine())
                    != null
                )
                {
                    chatArea.append(
                        "Server : "
                        + message
                        + "\n"
                    );
                }
            }
            catch(Exception e)
            {
                chatArea.append(
                    "Server disconnected.\n"
                );
            }
        }

        void sendMessage()
        {
            String message =
                messageField.getText();

            if(message.length() == 0)
            {
                return;
            }

            if(out != null)
            {
                out.println(message);

                chatArea.append(
                    "You : "
                    + message
                    + "\n"
                );

                messageField.setText("");
            }
        }

        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == sendButton)
            {
                sendMessage();
            }

            if(e.getSource() == disconnectButton)
            {
                disconnect();
            }
        }

        void disconnect()
        {
            try
            {
                if(socket != null)
                {
                    socket.close();
                }

                chatArea.append(
                    "Disconnected from server.\n"
                );

                sendButton.setEnabled(false);
            }
            catch(Exception e)
            {
                System.out.println(
                    e.getMessage()
                );
            }
        }
    }

    public static void main(String args[])
    {
        new ChatClient();
    }
}