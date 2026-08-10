////////////////////////////////////////////////////////////////////////////////////////////////////
//
//  Program : File Packer with GUI
//  Features:
//  1. Handle White Space in File Name
//  2. File Extension Filter (.txt, .c, .cpp)
//  3. 100 Byte Header
//  4. Encryption
//  5. GUI
//
////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.*;
import javax.swing.*;
import java.awt.event.*;

public class GUIPacker extends JFrame implements ActionListener
{
    ////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //  GUI Components
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////

    JLabel lblFolder;
    JLabel lblPackFile;
    JLabel lblKey;

    JTextField txtFolder;
    JTextField txtPackFile;
    JPasswordField txtKey;

    JButton btnBrowse;
    JButton btnPack;

    JTextArea txtOutput;

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //  Constructor
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////

    GUIPacker()
    {
        setTitle("Marvellous File Packer");

        setSize(500, 400);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Folder Label
        lblFolder = new JLabel("Folder :");
        lblFolder.setBounds(30, 40, 100, 30);
        add(lblFolder);

        // Folder TextField
        txtFolder = new JTextField();
        txtFolder.setBounds(120, 40, 230, 30);
        add(txtFolder);

        // Browse Button
        btnBrowse = new JButton("Browse");
        btnBrowse.setBounds(360, 40, 90, 30);
        btnBrowse.addActionListener(this);
        add(btnBrowse);

        // Packed File Label
        lblPackFile = new JLabel("Pack File :");
        lblPackFile.setBounds(30, 90, 100, 30);
        add(lblPackFile);

        // Packed File TextField
        txtPackFile = new JTextField();
        txtPackFile.setBounds(120, 90, 330, 30);
        add(txtPackFile);

        // Key Label
        lblKey = new JLabel("Key :");
        lblKey.setBounds(30, 140, 100, 30);
        add(lblKey);

        // Key TextField
        txtKey = new JPasswordField();
        txtKey.setBounds(120, 140, 330, 30);
        add(txtKey);

        // Pack Button
        btnPack = new JButton("Pack");
        btnPack.setBounds(180, 190, 120, 40);
        btnPack.addActionListener(this);
        add(btnPack);

        // Output Area
        txtOutput = new JTextArea();
        txtOutput.setEditable(false);

        JScrollPane scroll = new JScrollPane(txtOutput);
        scroll.setBounds(30, 250, 420, 90);

        add(scroll);

        setVisible(true);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //  Encryption Function
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////

    static byte EncryptByte(byte data, byte key)
    {
        return (byte)(data ^ key);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //  Action Performed
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnBrowse)
        {
            JFileChooser chooser = new JFileChooser();

            chooser.setFileSelectionMode(
                JFileChooser.DIRECTORIES_ONLY
            );

            int result = chooser.showOpenDialog(this);

            if(result == JFileChooser.APPROVE_OPTION)
            {
                txtFolder.setText(
                    chooser.getSelectedFile().getAbsolutePath()
                );
            }
        }

        if(e.getSource() == btnPack)
        {
            PackFiles();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //  Packing Function
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////

    void PackFiles()
    {
        String FolderName = txtFolder.getText();
        String PackFileName = txtPackFile.getText();
        String KeyString = new String(txtKey.getPassword());

        if(FolderName.length() == 0)
        {
            JOptionPane.showMessageDialog(
                this,
                "Please enter folder name"
            );

            return;
        }

        if(PackFileName.length() == 0)
        {
            JOptionPane.showMessageDialog(
                this,
                "Please enter packed file name"
            );

            return;
        }

        if(KeyString.length() == 0)
        {
            JOptionPane.showMessageDialog(
                this,
                "Please enter encryption key"
            );

            return;
        }

        File fobjFolder = new File(FolderName);

        if(!fobjFolder.exists() || !fobjFolder.isDirectory())
        {
            JOptionPane.showMessageDialog(
                this,
                "Folder does not exist"
            );

            return;
        }

        FileOutputStream foobj = null;

        try
        {
            File fobjPack = new File(PackFileName);

            foobj = new FileOutputStream(fobjPack);

            File fArr[] = fobjFolder.listFiles();

            if(fArr == null)
            {
                JOptionPane.showMessageDialog(
                    this,
                    "Unable to read folder"
                );

                return;
            }

            int FileCount = 0;

            byte Buffer[] = new byte[1024];

            byte Key = (byte)KeyString.charAt(0);

            txtOutput.setText("");

            for(int i = 0; i < fArr.length; i++)
            {
                ////////////////////////////////////////////////////////////////////////////////
                //
                //  Check only regular files
                //
                ////////////////////////////////////////////////////////////////////////////////

                if(!fArr[i].isFile())
                {
                    continue;
                }

                String FileName = fArr[i].getName();

                ////////////////////////////////////////////////////////////////////////////////
                //
                //  File Extension Filter
                //
                ////////////////////////////////////////////////////////////////////////////////

                if(!(
                    FileName.endsWith(".txt") ||
                    FileName.endsWith(".c") ||
                    FileName.endsWith(".cpp")
                ))
                {
                    continue;
                }

                ////////////////////////////////////////////////////////////////////////////////
                //
                //  Handle White Space
                //
                ////////////////////////////////////////////////////////////////////////////////

                if(FileName.contains(" "))
                {
                    FileName = FileName.replace(" ", "_");
                }

                FileInputStream fiobj =
                    new FileInputStream(fArr[i]);

                ////////////////////////////////////////////////////////////////////////////////
                //
                //  Header
                //
                //  Format:
                //
                //  FileName FileSize
                //
                //  Total Header = 100 bytes
                //
                ////////////////////////////////////////////////////////////////////////////////

                String Header =
                    FileName + " " + fArr[i].length();

                if(Header.length() > 100)
                {
                    fiobj.close();

                    txtOutput.append(
                        "File name too long : " + FileName + "\n"
                    );

                    continue;
                }

                while(Header.length() < 100)
                {
                    Header = Header + " ";
                }

                byte HeaderBuffer[] =
                    Header.getBytes("UTF-8");

                ////////////////////////////////////////////////////////////////////////////////
                //
                //  Write Header
                //
                ////////////////////////////////////////////////////////////////////////////////

                foobj.write(HeaderBuffer);

                ////////////////////////////////////////////////////////////////////////////////
                //
                //  Read File + Encrypt + Write
                //
                ////////////////////////////////////////////////////////////////////////////////

                int iRet = 0;

                while((iRet = fiobj.read(Buffer)) != -1)
                {
                    for(int j = 0; j < iRet; j++)
                    {
                        Buffer[j] =
                            EncryptByte(Buffer[j], Key);
                    }

                    foobj.write(Buffer, 0, iRet);
                }

                fiobj.close();

                FileCount++;

                txtOutput.append(
                    "Packed : " + FileName + "\n"
                );
            }

            foobj.close();

            txtOutput.append(
                "\nTotal Files Packed : " +
                FileCount +
                "\n"
            );

            JOptionPane.showMessageDialog(
                this,
                "Packing completed successfully"
            );
        }
        catch(Exception ex)
        {
            try
            {
                if(foobj != null)
                {
                    foobj.close();
                }
            }
            catch(Exception e)
            {
            }

            JOptionPane.showMessageDialog(
                this,
                "Error : " + ex.getMessage()
            );
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //  Main Function
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String a[])
    {
        GUIPacker gobj = new GUIPacker();
    }
}