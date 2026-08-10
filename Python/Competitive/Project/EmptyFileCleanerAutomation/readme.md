# EmptyFileCleanerAutomation

## 📌 Project Overview

**EmptyFileCleanerAutomation** is a Python-based automation tool that periodically scans a specified directory and identifies empty files.

The script automatically deletes all files having **0 bytes** and maintains a detailed log file containing information about the scanned files and deleted empty files.

The script uses Python's `os`, `time`, `sys`, and `schedule` modules to perform directory traversal, file validation, logging, and periodic automation.

---

## 🎯 Project Title

**EmptyFileCleanerAutomation**

---

## 👩‍💻 Author

**Vaishnavi Deepak Morankar**

---

## 📅 Project Date

**19/07/2026**

---

# 🛠️ Technologies Used

- Python 3
- OS Module
- SYS Module
- Time Module
- Schedule Module

---

# 💻 Platform

- Windows
- Linux
- macOS

The script can be executed using:

- Command Prompt
- PowerShell
- Terminal
- VS Code
- PyCharm

---

# ✨ Features

### 📁 Directory Scanning

The script recursively scans the given directory using:

```python
os.walk()

This allows the script to scan:

Main directory
Subdirectories
Files inside subdirectories
🔍 Empty File Detection

The script checks the size of every file.

os.path.getsize(fname)

If the file size is:

0 bytes

the file is considered an empty file.

🗑️ Automatic Empty File Deletion

Empty files are automatically deleted using:

os.remove(fname)
⏰ Periodic Automation

The script uses the schedule module to execute the directory scanning operation periodically.

Current scheduling interval:

Every 1 minute
📝 Log File Generation

A timestamp-based log file is automatically created.

Example:

Marvellous_Mon_Jul_19_10_30_00_2026.log

The log contains:

Files scanned
File sizes
Total number of files
Total empty files
Deleted empty files
Log creation time
✅ Directory Validation

Before scanning, the script verifies:

Whether the directory exists
Whether the given path is actually a directory
🏗️ Project Architecture
                    Marvellous Automation Script
                              |
                              ▼
                     Command Line Input
                              |
                              ▼
                       Directory Path
                              |
                              ▼
                    Directory Validation
                         /           \
                       No             Yes
                       |               |
                       ▼               ▼
                    Error          Scan Directory
                                       |
                                       ▼
                                os.walk()
                                       |
                                       ▼
                               Check Every File
                                       |
                          ┌────────────┴────────────┐
                          ▼                         ▼
                     File > 0 bytes           File = 0 bytes
                          |                         |
                          ▼                         ▼
                    Keep File                Delete File
                          |                         |
                          └────────────┬────────────┘
                                       |
                                       ▼
                                Generate Log
                                       |
                                       ▼
                                Display Summary
📂 Project Structure
Marvellous-Directory-Scanner/
│
├── DirectoryScanner.py
├── README.md
│
└── Logs/
    └── Marvellous_<timestamp>.log
⚙️ Requirements

Make sure Python is installed.

Check Python version:

python --version

or:

python3 --version

Recommended:

Python 3.x
📦 Install Required Library

The script uses the external schedule module.

Install it using:

pip install schedule

If your system uses pip3:

pip3 install schedule

Verify installation:

pip show schedule
▶️ How to Run
Step 1 – Open Command Prompt

Open CMD or Terminal.

Go to the project directory:

cd path/to/project

Example:

cd Desktop\Marvellous-Directory-Scanner
Step 2 – Run the Script

The basic syntax is:

python DirectoryScanner.py DirectoryName

Example:

python DirectoryScanner.py C:\Users\Vaishnavi\Documents

The directory path should preferably be an absolute path.

⏰ Automation

After executing:

python DirectoryScanner.py C:\Test

the script schedules the scanning operation.

The current code executes:

schedule.every(1).minute.do(
    DirectoryScanner,
    sys.argv[1]
)

Therefore, the directory is scanned automatically every:

1 minute

The script continues running until it is stopped manually.

🛑 Stop the Script

To stop the automation script from Command Prompt:

Ctrl + C
🆘 Help Command

Use:

python DirectoryScanner.py --h

Output:

This Automation Script is used to travel the directory
For better usage please check --u flag
📖 Usage Command

Use:

python DirectoryScanner.py --u

The script displays the usage instructions.

Example:

Please execute script as
Python FileName.py DirectoryName

DirectoryName should be absolute path
❌ Invalid Arguments

If an incorrect number of command-line arguments is provided:

python DirectoryScanner.py

the script displays:

Invalid number of arguments
Please use --h or --u for more information
📝 Log File

Every scan generates a log file containing information about the operation.

Example:

--------------------------------------------------
Marvellous Automation Script
--------------------------------------------------

Files from the Directory are :

--------------------------------------------------
C:\Test\file1.txt : 120 bytes
C:\Test\file2.txt : 0 bytes
C:\Test\file3.txt : 450 bytes
--------------------------------------------------
Total files scanned : 3
Total empty files are found and deleted : 1
--------------------------------------------------
Log File gets create at : Mon Jul 19 10:30:00 2026
--------------------------------------------------
📊 Example

Suppose the directory contains:

Test/
│
├── file1.txt      → 100 bytes
├── file2.txt      → 0 bytes
├── file3.txt      → 250 bytes
│
└── Documents/
    ├── report.txt  → 500 bytes
    └── empty.txt   → 0 bytes

Before scanning:

Total files = 5
Empty files = 2

After scanning:

file2.txt
empty.txt

are automatically deleted.

The log will contain:

Total files scanned : 5
Total empty files are found and deleted : 2
🔄 Function Details
DirectoryScanner()
Function Name
DirectoryScanner()
Input
DirectoryPath
Description

The function:

Validates the directory
Creates a log file
Traverses the directory
Finds all files
Checks file sizes
Deletes empty files
Records the operation in the log
main()
Function Name
main()
Input
Command Line Arguments
Description

The main() function controls the entire automation script.

It:

Displays the project banner
Processes command-line arguments
Handles help and usage commands
Starts the scheduler
Executes the scanner periodically
🧩 Python Modules Used
1. sys

Used to access command-line arguments.

Example:

sys.argv
2. os

Used for:

Directory validation
Directory traversal
File size checking
File deletion
Path handling

Important functions:

os.path.exists()
os.path.isdir()
os.walk()
os.path.getsize()
os.path.join()
os.remove()
3. time

Used for:

Generating timestamps
Creating timestamp-based log filenames
Adding delay between scheduled operations

Example:

time.ctime()
4. schedule

Used for periodic execution.

Example:

schedule.every(1).minute.do(
    DirectoryScanner,
    sys.argv[1]
)
🧠 Concepts Demonstrated

This project demonstrates:

Python Functions
Command Line Arguments
File Handling
Directory Handling
OS Automation
Exception Prevention through Validation
File Size Checking
File Deletion
Directory Traversal
Scheduling
Logging
String Formatting
Infinite Loops
Automation
🔐 Safety Considerations

⚠️ Important: This script permanently deletes empty files.

Before running it on an important directory:

Test it on a temporary folder
Verify the directory path
Keep backups of important files
Do not run it on system directories unless you understand the consequences
🚀 Future Enhancements

The project can be improved by adding:

 Delete files based on size
 Delete files based on extension
 Delete old files
 Delete duplicate files
 Email notifications
 CSV report generation
 JSON report generation
 GUI interface
 Configuration file
 Multiple directory support
 User confirmation before deletion
 Exception handling
 Detailed logging
 Dry-run mode
 Windows Task Scheduler integration
 Linux Cron integration
📈 Possible Future Workflow
Directory
    |
    ▼
Scan Files
    |
    ▼
Apply Rules
    |
    ├── Empty File
    ├── Old File
    ├── Large File
    └── Duplicate File
    |
    ▼
Take Action
    |
    ▼
Generate Report
    |
    ▼
Send Notification
🏆 Learning Outcomes

After completing this project, the following concepts can be understood:

How to work with directories using Python
How to traverse directories recursively
How to check file sizes
How to delete files programmatically
How to use command-line arguments
How to schedule tasks in Python
How to create log files
How to automate repetitive tasks
How to validate user input
How to build an automation utility using Python
📌 Limitations

The current version has some limitations:

Empty files are permanently deleted
No confirmation before deletion
Uses a fixed 1-minute schedule
Generates logs in the current working directory
No database
No GUI
Limited error handling
Supports one directory path at a time
📜 License

This project is created for educational and academic purposes.

You are free to study, modify and improve the project.

⭐ Acknowledgement

This project was developed to understand Python automation, directory traversal, file handling, scheduling, and system-level operations.


### GitHub repository structure

```text
EmptyFileCleanerAutomation/
│
├── DirectoryScanner.py
├── README.md
└── Logs/
    └── Marvellous_<timestamp>.log

Recommended GitHub project title

EmptyFileCleanerAutomation

Repository name:

EmptyFileCleanerAutomation
