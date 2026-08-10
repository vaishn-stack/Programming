GUI File Packer-Unpacker

A simple Java Swing based File Packer-Unpacker project that allows users to pack multiple source files into a single .pack file and later extract them using a GUI.

📌 Project Name

GUI File Packer-Unpacker

🚀 Features
🖥️ Simple Java Swing GUI
📁 Enter Folder Name manually
📦 Create a single .pack file
📤 Unpack files from a .pack file
🔐 XOR-based encryption
🔓 XOR-based decryption
📝 100-byte header for every packed file
📄 Stores:
File Name
File Size
🔎 File extension filtering
␠ Handles spaces in filenames
⚠️ Error handling using message dialogs
📊 Displays packing/unpacking status
🛠️ Technologies Used
Technology	Purpose
Java	Core programming language
Java Swing	GUI
Java I/O	File handling
FileInputStream	Reading files
FileOutputStream	Writing files
JFrame	Main GUI window
JButton	Pack/Unpack buttons
JTextField	User input
JTextArea	Status/output
XOR	Basic encryption/decryption

📂 Project Structure
-GUI-File-Packer-Unpacker/
│
├── GUIPackerX.java
├── GUIUnpackerX.java
├── README.md
│
└── screenshots/
    ├── packer.png
    ├── unpacker.png
    ├── source-folder.png
    ├── packed-file.png
    └── extracted-files.png
    
🖥️ Packer GUI

The Packer GUI contains:

+------------------------------------------+
|        Marvellous File Packer            |
|                                          |
| Folder Name : [_______________________]  |
|                                          |
| Filename    : [_______________________]  |
|                                          |
|              [    Pack    ]              |
|                                          |
| ---------------------------------------- |
| Packed : program1.c                      |
| Packed : program2.cpp   
| Packed : program3.java
|                                          |
| Total Files Packed : 3                   |
+------------------------------------------+
📦 Packing Process

The packing process works as follows:

             START
               |
               v
        Launch Packer GUI
               |
               v
      Enter Folder Name
               |
               v
       Enter Filename
               |
               v
          Click Pack
               |
               v
        Validate Folder
               |
               v
         Read Files
               |
               v
       Filter Extensions
               |
               v
        Create Header
               |
               v
     FileName + FileSize
               |
               v
       Make Header 100B
               |
               v
       Read File Data
               |
               v
       XOR Encryption
               |
               v
      Write .pack File
               |
               v
              END
📋 100-Byte Header

For every file, the packer creates a header containing:

FileName FileSize

Example:

program1.c 87

The remaining space is filled with spaces until the header becomes exactly 100 bytes.

Example
program1.c 87
[                    remaining spaces                    ]

The packed file therefore contains:

+-----------------------------+
| Header - 100 Bytes          |
| program1.c 87               |
+-----------------------------+
| Encrypted File Data         |
| 87 Bytes                    |
+-----------------------------+
| Header - 100 Bytes          |
| program2.cpp 107            |
+-----------------------------+
| Encrypted File Data         |
| 107 Bytes                   |
+-----------------------------+

🔐 Encryption

The project uses a simple XOR operation.

static byte EncryptByte(byte data, byte key)
{
    return (byte)(data ^ key);
}

The key in the current implementation is derived from the first character of the packed filename:

byte Key = (byte)PackFileName.charAt(0);

For example:

Marvellous_pack.pack
^
First character = M

The encrypted bytes are written into the .pack file.

⚠️ Note: XOR with a predictable key is suitable for educational demonstration, but it is not strong encryption for real-world sensitive data.

🔓 Decryption

The unpacker reads the encrypted data and applies the same XOR operation:

Encrypted Data
      |
      v
   XOR Key
      |
      v
Original Data

XOR has the useful property:

A XOR B XOR B = A

Therefore, the same operation can be used for encryption and decryption.

📤 Unpacking Process
             START
               |
               v
        Launch Unpacker GUI
               |
               v
       Enter .pack Filename
               |
               v
         Click Unpack
               |
               v
       Read 100-byte Header
               |
               v
     Extract FileName/Size
               |
               v
      Read Encrypted Data
               |
               v
        XOR Decryption
               |
               v
        Create New File
               |
               v
       Write Original Data
               |
               v
      Read Next Header
               |
               v
              END
📄 Supported File Extensions

The current Packer code supports:

.txt
.c
.cpp
.java

If Java files should also be packed, add:

FileName.endsWith(".java")

to the extension condition.

For example:

if(!(
    FileName.endsWith(".txt") ||
    FileName.endsWith(".c") ||
    FileName.endsWith(".cpp") ||
    FileName.endsWith(".java")
))
{
    continue;
}
␠ Filename Space Handling

The project checks whether a filename contains a space:

if(FileName.contains(" "))
{
    FileName = FileName.replace(" ", "_");
}

Example:

My Program.c

becomes:

My_Program.c

This makes the filename easier to store and parse from the header.

⚙️ Requirements
Software
JDK 8 or above
Windows / Linux / macOS
Command Prompt / Terminal
Any Java-compatible IDE (optional)
Hardware
Minimum 2 GB RAM
Minimum 100 MB free disk space
Standard computer system
▶️ How to Run
1. Check Java

Open CMD/Terminal:

java -version

Then:

javac -version
2. Compile Packer
javac GUIPackerX.java

Run:

java GUIPackerX
3. Compile Unpacker
javac GUIUnpackerX.java

Run:

java GUIUnpackerX
📦 Example

Suppose the folder contains:

MyFolder/
│
├── program1.c
├── program2.cpp
├── program3.java
└── image.jpg

With the current filter:

program1.c   → Packed
program2.cpp → Packed
program3.java → Skipped
image.jpg    → Skipped

After packing:

Marvellous_pack.pack

is created.

After unpacking:

program1.c
program2.cpp
program3.java

are recreated.

📸 Screenshots

Packer GUI
![Packer GUI](screenshots/packer.png)
Unpacker GUI
![Unpacker GUI](screenshots/unpacker.png)
Source Folder
![Source Folder](screenshots/source-folder.png)
Packed File
![Packed File](screenshots/packed-file.png)
Extracted Files
![Extracted Files](screenshots/extracted-files.png)

🧪 Test Cases
Test Case	Expected Result
Valid folder	Folder accepted
Invalid folder	Error message
Empty folder	No files packed
Filename without .pack	.pack added
.c file	Packed
.cpp file	Packed
Unsupported extension	Skipped
Valid .pack file	Files extracted
Invalid .pack file	Error displayed
Encrypted data	Correctly decrypted by unpacker
✅ Advantages
Easy-to-use GUI
Simple implementation
Multiple files can be packed
Uses fixed-size headers
Demonstrates Java File Handling
Demonstrates Swing GUI
Demonstrates encryption/decryption
Easy to understand for academic projects
⚠️ Limitations
XOR is not suitable for secure production encryption.
The encryption key is predictable.
Current implementation supports only selected file extensions.
No compression is implemented.
File metadata remains readable in the packed file.
Filename spaces are converted to underscores.
🔮 Future Enhancements

The project can be improved by adding:

🔐 AES-GCM encryption
🔑 Password-based encryption
📦 File compression
📊 Progress bar
🖱️ Drag-and-drop support
📁 Browse folder option
📄 Support for all file types
🔍 File preview
📝 Better logging
🎨 Improved GUI
🔒 Secure key management

🎓 Viva Questions
1. What is File Packing?

File packing is the process of combining multiple files into a single file.

2. What is File Unpacking?

File unpacking extracts the original files from the packed file.

3. Why is a header used?

The header stores metadata such as:

File Name
File Size
4. Why is the header 100 bytes?

A fixed-size header makes it easier for the unpacker to identify where each file's metadata ends.

5. Which encryption technique is used?

XOR-based encryption.

6. Why can the same XOR operation decrypt the data?

Because:

A XOR B XOR B = A
7. Which Java classes are used for file handling?

Mainly:

File
FileInputStream
FileOutputStream
8. Which technology is used for GUI?

Java Swing.

9. What is ActionListener?

ActionListener is used to handle events such as button clicks.

10. What information is stored in the header?

The filename and file size.

👩‍💻 Author

Vaishnavi Morankar

Project

GUI File Packer-Unpacker

Technology
Java
Java Swing
Java I/O
XOR Encryption
XOR Decryption

📜 License

This project is created for educational and academic purposes.

⭐ GitHub Repository Description

A Java Swing GUI application for packing multiple files into a single .pack file and unpacking them using 100-byte headers and XOR-based encryption/decryption.
