# 🧹 File Integrity Duplicate Cleaner

## 📌 Project Overview

**File Integrity Duplicate Cleaner** is a Python-based automation tool designed to identify and remove duplicate files from a specified directory.

The application recursively scans files inside the given directory, calculates the **MD5 checksum** of each file, groups files having the same checksum, and automatically deletes duplicate copies while keeping the first occurrence.

The project also generates a detailed log file containing information about scanned files, duplicate groups, and deleted files.

The scanning process is automatically scheduled to run every **1 minute**.

---

# 🎯 Project Title

**File Integrity Duplicate Cleaner**

---

# 👩‍💻 Author

**Vaishnavi Deepak Morankar**

---

# 🛠️ Technologies Used

- Python 3
- OS Module
- SYS Module
- Time Module
- Hashlib Module
- Datetime Module
- Schedule Module

---

# 💻 Platform

- Windows
- Linux
- macOS

The project can be executed using:

- Command Prompt
- PowerShell
- Terminal
- VS Code
- PyCharm

---

# ✨ Features

## 🔍 Duplicate File Detection

The application recursively scans the selected directory and its subdirectories.

It uses:

```python
os.walk()

to find all files.

🔐 File Integrity Verification

The project calculates the MD5 checksum of each file.

hashlib.md5()

Files having the same checksum are considered duplicate files.

🧮 Checksum Calculation

The file is read in chunks of 1024 bytes:

Buffer = fobj.read(1024)

The checksum is continuously updated:

hobj.update(Buffer)

Finally, the hexadecimal checksum is returned:

hobj.hexdigest()
🗑️ Automatic Duplicate Removal

When duplicate files are detected, the application keeps the first file and deletes the remaining duplicate copies.

Example:

file1.txt
file2.txt
file3.txt

If all three files have the same checksum:

Keep    → file1.txt
Delete  → file2.txt
Delete  → file3.txt
📝 Log Generation

After every scan, a log file is created inside the Logs directory.

Example:

Logs/
└── Log_20260810_113000.txt

The log contains:

Date
Time
Directory scanned
Total files scanned
Duplicate groups
Deleted files
Duplicate file paths
⏰ Automatic Scheduling

The project uses the schedule module.

The scan automatically runs every:

1 Minute

The scheduler keeps running until the program is manually stopped.

🏗️ Project Architecture
                 FILE INTEGRITY
                 DUPLICATE CLEANER
                         |
                         ▼
                 Directory Input
                         |
                         ▼
                 Directory Validation
                         |
                         ▼
                    os.walk()
                         |
                         ▼
                   Read Files
                         |
                         ▼
                 Calculate MD5
                    Checksum
                         |
                         ▼
               Store Checksum
                  in Dictionary
                         |
              ┌──────────┴──────────┐
              ▼                     ▼
        Unique Checksum      Duplicate Checksum
              |                     |
              ▼                     ▼
         Keep File             Group Files
                                    |
                                    ▼
                            Delete Duplicates
                                    |
                                    ▼
                              Create Log
                                    |
                                    ▼
                               Summary
                                    |
                                    ▼
                              Schedule Job
                                    |
                                    ▼
                            Scan After 1 Min
📂 Project Structure
File-Integrity-Duplicate-Cleaner/
│
├── DuplicateCleaner.py
├── README.md
│
└── Logs/
    ├── Log_20260810_110000.txt
    ├── Log_20260810_111000.txt
    └── Log_20260810_112000.txt
⚙️ Requirements

Make sure Python 3 is installed.

Check Python:

python --version

or:

python3 --version

Recommended:

Python 3.x
📦 Install Required Library

The project uses the external schedule module.

Install it using:

pip install schedule

For systems using pip3:

pip3 install schedule

Verify installation:

pip show schedule
▶️ How to Run
Step 1 – Open Command Prompt

Open CMD / PowerShell / Terminal.

Navigate to the project directory:

[cd path/to/File-Integrity-Duplicate-Cleaner](https://github.com/vaishn-stack/Programming/edit/main/Python/Competitive/Project/File-Integrity-Duplicate-Cleaner)

Example:

cd Desktop\File-Integrity-Duplicate-Cleaner
Step 2 – Run the Program

Syntax:

python DuplicateCleaner.py DirectoryName

Example:

python DuplicateCleaner.py C:\Test

For Linux/macOS:

python3 DuplicateCleaner.py /home/user/Test
🔄 Working Process

Suppose the directory contains:

Test/
│
├── file1.txt
├── file2.txt
├── file3.txt
├── image1.jpg
├── image2.jpg
│
└── Documents/
    ├── report.txt
    └── copy_report.txt

The program calculates the checksum of every file.

Example:

file1.txt       → abc123
file2.txt       → xyz456
file3.txt       → abc123

Since:

file1.txt → abc123
file3.txt → abc123

both files have the same checksum.

Therefore:

Keep    → file1.txt
Delete  → file3.txt
🧮 Duplicate Detection Logic

The program maintains a dictionary:

Duplicate = {}

The checksum is used as the dictionary key.

Example:

Checksum A
    |
    ├── file1.txt
    └── file3.txt

Checksum B
    |
    ├── image1.jpg
    └── image2.jpg

A checksum containing more than one file represents a duplicate group.

The code identifies duplicate groups using:

Result = list(
    filter(
        lambda x: len(x) > 1,
        MyDict.values()
    )
)
🔐 MD5 Checksum

The project uses the MD5 hashing algorithm:

hobj = hashlib.md5()

A checksum is generated from the file contents.

If two files have identical content, they normally produce the same MD5 checksum.

Example:

File A
   ↓
MD5
   ↓
5d41402abc4b2a76b9719d911017c592
File B
   ↓
MD5
   ↓
5d41402abc4b2a76b9719d911017c592

Therefore, they are treated as duplicates.

Note: MD5 is suitable here as a simple duplicate-detection mechanism, but it is not recommended for security-sensitive cryptographic integrity applications. For stronger collision resistance, SHA-256 can be used.

📝 Log File

The application automatically creates a Logs directory.

Example:

Logs/
└── Log_20260810_113000.txt

Example log:

=====================================================
          Duplicate File Cleaner Log
=====================================================

Date : 10/08/2026
Time : 11:30:00

Directory : C:\Test

Total Files Scanned : 10
Duplicate Groups    : 2
Deleted Files       : 3

Duplicate Files
-------------------------------------------
C:\Test\file1.txt
C:\Test\copy_file1.txt
-------------------------------------------
C:\Test\image1.jpg
C:\Test\copy_image1.jpg
C:\Test\backup_image1.jpg
-------------------------------------------
📊 Program Summary

After every scan, the application displays:

Summary
---------------------------
Total Files Scanned : 10
Duplicate Groups    : 2
Deleted Files       : 3
---------------------------
⏰ Scheduler

The application automatically schedules the job:

schedule.every(1).minutes.do(
    Job,
    DirectoryName
)

The scheduler runs continuously:

while True:
    schedule.run_pending()
    time.sleep(1)

Therefore, the directory is automatically scanned every 1 minute.

🧩 Function Details
1. CalculateCheckSum()
Function
CalculateCheckSum(FileName)
Input
FileName
Description

Calculates and returns the MD5 checksum of the specified file.

Main Operations
Open File
   ↓
Read 1024 Bytes
   ↓
Update MD5
   ↓
Read Next Chunk
   ↓
Repeat
   ↓
Return Checksum
2. CreateLog()
Function
CreateLog(
    DirectoryName,
    TotalFiles,
    DuplicateGroups,
    DeletedFiles,
    DuplicateList
)
Description

Creates a timestamp-based log file containing the details of the duplicate cleaning operation.

3. FindDuplicate()
Function
FindDuplicate(DirectoryName)
Description

Scans the directory recursively and creates groups of files having the same checksum.

Returns
Duplicate Dictionary
Total Files
4. DeleteDuplicate()
Function
DeleteDuplicate(DirectoryName)
Description

Finds duplicate files and deletes all duplicate copies except the first occurrence.

It also generates the log file.

5. Job()
Function
Job(Path)
Description

Acts as the scheduled job.

It starts the duplicate scanning and cleaning operation.

6. main()
Function
main()
Description

Controls the complete application.

It:

Validates command-line arguments
Gets the directory path
Performs the first scan
Starts the scheduler
Repeats scanning every 1 minute
📚 Python Concepts Used

This project demonstrates:

Functions
Dictionaries
Lists
Lambda Functions
Filter Function
Command Line Arguments
File Handling
Binary File Reading
Directory Traversal
Hashing
MD5 Checksum
OS Automation
Exception Handling
Scheduling
Logging
Infinite Loops
String Formatting
Date and Time Handling
🔄 Complete Workflow
START
  |
  ▼
Read Directory Path
  |
  ▼
Validate Directory
  |
  ▼
Scan All Files
  |
  ▼
Read File in 1024 Byte Chunks
  |
  ▼
Calculate MD5 Checksum
  |
  ▼
Store Checksum in Dictionary
  |
  ▼
Find Duplicate Groups
  |
  ▼
Display Duplicate Files
  |
  ▼
Keep First File
  |
  ▼
Delete Remaining Files
  |
  ▼
Generate Log
  |
  ▼
Display Summary
  |
  ▼
Schedule Next Scan
  |
  ▼
Wait 1 Minute
  |
  └──────────────► Repeat
🛑 Stop the Program

The scheduler continuously runs the program.

To stop it from CMD:

Ctrl + C
❌ Invalid Path

If the specified path does not exist:

Invalid Path

If the specified path exists but is not a directory:

Path is not Directory
⚠️ Safety Warning

This program permanently deletes duplicate files.

Before using it on important data:

Create a backup
Test on sample files
Verify the directory path
Check the generated duplicate list
Avoid using it on critical system directories

The application currently keeps the first file encountered and deletes the remaining files in each duplicate group.

🚀 Future Enhancements

The project can be improved by adding:

 GUI Interface
 File preview before deletion
 User confirmation before deleting
 Restore deleted files
 Trash/Recycle Bin support
 SHA-256 checksum
 File size based pre-filtering
 Progress bar
 CSV reports
 JSON reports
 Email notifications
 Multiple directory selection
 Configurable scan interval
 Exclude specific folders
 Exclude specific file extensions
 Duplicate file dashboard
 Database-based scan history
🎓 Learning Outcomes

After completing this project, the following concepts can be understood:

How to traverse directories recursively
How to read binary files
How hashing works
How MD5 checksums can identify identical content
How dictionaries can group files
How to delete files using Python
How to generate automated logs
How to use command-line arguments
How to schedule repetitive tasks
How to build a Python automation utility
📌 Limitations

The current version has the following limitations:

Uses MD5 for duplicate detection
Duplicate files are permanently deleted
No GUI
No database
No restore functionality
Fixed scanning interval of 1 minute
Keeps the first encountered duplicate automatically
Limited recovery options
📜 License

This project is created for educational and academic purposes.

⭐ Acknowledgement

This project was developed to understand:

Python Automation + File Handling + Directory Traversal + Hashing + Duplicate Detection + Scheduling + System Automation

```text
File-Integrity-Duplicate-Cleaner/
│
├── DuplicateCleaner.py
├── README.md
├── requirements.txt
│
└── Logs/
    └── Log_YYYYMMDD_HHMMSS.txt
requirements.txt

schedule

Install:

pip install -r requirements.txt

GitHub Project Title

File Integrity Duplicate Cleaner – Python Automation Tool

Repository name:

File-Integrity-Duplicate-Cleaner
