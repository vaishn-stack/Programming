/*
 * ================================================================
 *                  MARVELLOUS CHAT APPLICATION
 * ================================================================
 *
 * Project Name : Marvellous Chat Application
 * File Name    : ChatServer.java
 * Author       : Vaishnavi Morankar
 * Technology   : Java
 * GUI          : Java Swing
 * Networking   : TCP Socket Programming
 * Port Number  : 2100
 *
 * Description :
 * This program implements a GUI based Chat Server using
 * Java Socket Programming.
 *
 * Features :
 * 1. GUI based Login Page
 * 2. Username and Password Authentication
 * 3. Server Socket Creation
 * 4. Client Connection
 * 5. Send Messages to Client
 * 6. Receive Messages from Client
 * 7. Disconnect Client
 * 8. Real-time Communication using Thread
 *
 * ================================================================
 */

import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatServer extends JFrame implements ActionListener
{
    // Login components
    JLabel ltitle;
    JLabel luser;
    JLabel lpass;

    JTextField tuser;

    JPasswordField tpass;

    JButton blogin;

    String username;

    // ============================================================
    // LOGIN PAGE
    // ============================================================

    ChatServer()
    {
        setTitle("Marvellous Chat - Server Login");

        setSize(450, 350);

        setLayout(null);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE
        );

        // Title
        ltitle = new JLabel(
            "MARVELLOUS CHAT SERVER"
        );

        ltitle.setFont(
            new Font(
                "Arial",
                Font.BOLD,
                22
            )
        );

        ltitle.setBounds(
            80,
            30,
            300,
            35
        );

        add(ltitle);

        // Username
        luser = new JLabel(
            "Username :"
        );

        luser.setBounds(
            50,
            95,
            100,
            30
        );

        add(luser);

        tuser = new JTextField();

        tuser.setBounds(
            160,
            95,
            200,
            30
        );

        add(tuser);

        // Password
        lpass = new JLabel(
            "Password :"
        );

        lpass.setBounds(
            50,
            145,
            100,
            30
        );

        add(lpass);

        tpass = new JPasswordField();

        tpass.setBounds(
            160,
            145,
            200,
            30
        );

        add(tpass);

        // Login Button
        blogin = new JButton(
            "LOGIN"
        );

        blogin.setBounds(
            150,
            210,
            120,
            40
        );

        blogin.addActionListener(this);

        add(blogin);

        setVisible(true);
    }

    // ============================================================
    // LOGIN BUTTON EVENT
    // ============================================================

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == blogin)
        {
            username =
                tuser.getText();

            String password =
                new String(
                    tpass.getPassword()
                );

            if(username.length() == 0 ||
               password.length() == 0)
            {
                JOptionPane.showMessageDialog(
                    this,
                    "Please enter Username and Password"
                );

                return;
            }

            // Demo login credentials
            if(username.equals("admin") &&
               password.equals("admin123"))
            {
                JOptionPane.showMessageDialog(
                    this,
                    "Login Successful!"
                );

                dispose();

                new ServerWindow(username);
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

    // ============================================================
    // SERVER WINDOW
    // ============================================================

    class ServerWindow extends JFrame
                       implements ActionListener
    {
        JTextArea chatArea;

        JTextField messageField;

        JButton sendButton;
        JButton disconnectButton;

        JLabel statusLabel;

        ServerSocket ssobj;
        Socket sobj;

        PrintStream pobj;

        BufferedReader bobj;

        String username;

        // ========================================================
        // SERVER WINDOW CONSTRUCTOR
        // ========================================================

        ServerWindow(String username)
        {
            this.username = username;

            setTitle(
                "Marvellous Chat - Server"
            );

            setSize(700, 550);

            setLayout(
                new BorderLayout()
            );

            setLocationRelativeTo(null);

            setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
            );

            // ====================================================
            // HEADER
            // ====================================================

            JLabel title =
                new JLabel(
                    "MARVELLOUS CHAT SERVER",
                    JLabel.CENTER
                );

            title.setFont(
                new Font(
                    "Arial",
                    Font.BOLD,
                    24
                )
            );

            add(
                title,
                BorderLayout.NORTH
            );

            // ====================================================
            // CHAT AREA
            // ====================================================

            chatArea =
                new JTextArea();

            chatArea.setEditable(false);

            chatArea.setFont(
                new Font(
                    "Arial",
                    Font.PLAIN,
                    16
                )
            );

            JScrollPane scrollPane =
                new JScrollPane(
                    chatArea
                );

            add(
                scrollPane,
                BorderLayout.CENTER
            );

            // ====================================================
            // STATUS
            // ====================================================

            statusLabel =
                new JLabel(
                    "  Server Starting..."
                );

            add(
                statusLabel,
                BorderLayout.WEST
            );

            // ====================================================
            // MESSAGE PANEL
            // ====================================================

            JPanel bottomPanel =
                new JPanel(
                    new BorderLayout()
                );

            messageField =
                new JTextField();

            sendButton =
                new JButton(
                    "SEND"
                );

            disconnectButton =
                new JButton(
                    "DISCONNECT"
                );

            sendButton.addActionListener(this);

            disconnectButton.addActionListener(this);

            bottomPanel.add(
                messageField,
                BorderLayout.CENTER
            );

            JPanel buttonPanel =
                new JPanel();

            buttonPanel.add(
                sendButton
            );

            buttonPanel.add(
                disconnectButton
            );

            bottomPanel.add(
                buttonPanel,
                BorderLayout.EAST
            );

            add(
                bottomPanel,
                BorderLayout.SOUTH
            );

            setVisible(true);

            // Start server
            startServer();
        }

        // ========================================================
        // START SERVER
        // ========================================================

        void startServer()
        {
            Thread serverThread =
                new Thread(
                    new Runnable()
                    {
                        public void run()
                        {
                            try
                            {
                                // Create ServerSocket
                                ssobj =
                                    new ServerSocket(
                                        2100
                                    );

                                chatArea.append(
                                    "====================================\n"
                                );

                                chatArea.append(
                                    "Server Application Started\n"
                                );

                                chatArea.append(
                                    "Server is waiting at port 2100\n"
                                );

                                chatArea.append(
                                    "Waiting for client...\n"
                                );

                                statusLabel.setText(
                                    "  Waiting for Client..."
                                );

                                // Accept client request
                                sobj =
                                    ssobj.accept();

                                chatArea.append(
                                    "Client request accepted successfully!\n"
                                );

                                chatArea.append(
                                    "Client IP : "
                                    + sobj.getInetAddress()
                                    + "\n"
                                );

                                chatArea.append(
                                    "====================================\n\n"
                                );

                                statusLabel.setText(
                                    "  Client Connected"
                                );

                                // Output stream
                                pobj =
                                    new PrintStream(
                                        sobj.getOutputStream()
                                    );

                                // Input stream
                                bobj =
                                    new BufferedReader(
                                        new InputStreamReader(
                                            sobj.getInputStream()
                                        )
                                    );

                                // Receive messages
                                receiveMessages();
                            }
                            catch(Exception e)
                            {
                                chatArea.append(
                                    "Server Error : "
                                    + e.getMessage()
                                    + "\n"
                                );

                                statusLabel.setText(
                                    "  Server Error"
                                );
                            }
                        }
                    }
                );

            serverThread.start();
        }

        // ========================================================
        // RECEIVE MESSAGE
        // ========================================================

        void receiveMessages()
        {
            try
            {
                String message;

                while(
                    (message = bobj.readLine())
                    != null
                )
                {
                    chatArea.append(
                        "Client : "
                        + message
                        + "\n"
                    );
                }

                chatArea.append(
                    "Client disconnected.\n"
                );

                statusLabel.setText(
                    "  Client Disconnected"
                );
            }
            catch(Exception e)
            {
                chatArea.append(
                    "Client disconnected.\n"
                );

                statusLabel.setText(
                    "  Client Disconnected"
                );
            }
        }

        // ========================================================
        // SEND MESSAGE
        // ========================================================

        void sendMessage()
        {
            String message =
                messageField.getText();

            if(message.length() == 0)
            {
                return;
            }

            if(pobj != null)
            {
                pobj.println(
                    message
                );

                chatArea.append(
                    "Server : "
                    + message
                    + "\n"
                );

                messageField.setText("");
            }
            else
            {
                JOptionPane.showMessageDialog(
                    this,
                    "Client is not connected!"
                );
            }
        }

        // ========================================================
        // BUTTON EVENTS
        // ========================================================

        public void actionPerformed(
            ActionEvent e
        )
        {
            if(e.getSource() == sendButton)
            {
                sendMessage();
            }

            if(
                e.getSource()
                ==
                disconnectButton
            )
            {
                disconnect();
            }
        }

        // ========================================================
        // DISCONNECT
        // ========================================================

        void disconnect()
        {
            try
            {
                if(sobj != null)
                {
                    sobj.close();
                }

                if(ssobj != null)
                {
                    ssobj.close();
                }

                chatArea.append(
                    "Server stopped successfully.\n"
                );

                statusLabel.setText(
                    "  Server Stopped"
                );

                sendButton.setEnabled(
                    false
                );

                disconnectButton.setEnabled(
                    false
                );
            }
            catch(Exception e)
            {
                chatArea.append(
                    "Error : "
                    + e.getMessage()
                    + "\n"
                );
            }
        }
    }

    // ============================================================
    // MAIN
    // ============================================================

    public static void main(String args[])
    {
        new ChatServer();
    }
}