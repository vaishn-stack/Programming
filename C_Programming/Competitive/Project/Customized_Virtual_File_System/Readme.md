Marvellous CVFS

Customised Virtual File System

System Programming Project -- C Language

Marvellous CVFS is a customised virtual file system implemented in C.The project demonstrates the basic internal data structures andoperations used by a file system through an interactive command-lineinterface.

The implementation uses memory-based data structures such asBootBlock, SuperBlock, UAREA, UFDT, FileTable and Inode. Files arerepresented using an inode linked list and a dynamically allocated databuffer.

Table of Contents

Project Information

Project Objective

Features

Technologies and Requirements

Project Architecture

Data Structures

Important Macros

Error Codes

Function Documentation

Command Documentation

File Creation Flow

Write Operation Flow

Read Operation Flow

Delete Operation Flow

Compilation and Execution

Sample Execution

Testing

Memory Management

Current Implementation Status

Limitations and FutureEnhancements

Conclusion

Author

1. Project Information

Property                    Details

Project Name                Marvellous CVFSFull Name                   Customised Virtual File SystemProgramming Language        CProject Type                System ProgrammingInterface                   Command Line InterfaceCompiler                    GCCMaximum Inodes              5Maximum File Size           50 BytesMaximum Open File Entries   5

2. Project Objective

The main objective of Marvellous CVFS is to understand the internalworking of a file system by implementing a simplified virtual filesystem in C.

The project demonstrates:

File system data structures

Inode management

File descriptor management

File permissions

File buffers

Read and write offsets

Dynamic memory allocation

Linked-list based inode management

File creation

File deletion

File information

File reading and writing

Error handling

Command-line processing

3. Features

The current source code supports the following commands and operations:

help

man

clear

ls

ls -a

creat

stat

write

read

unlink

exit

The source code also displays open and close in the help page, buttheir command-handling implementation is not completed in the currentmain() function.

4. Technologies and Requirements

4.1 Programming Language

The project is written in:

C

4.2 Header Files

The source code includes:

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <stdbool.h>

4.3 Software Requirements

Windows or Linux

GCC compiler

VS Code, Code::Blocks, or another C IDE

Command Prompt, PowerShell, or Terminal

4.4 Hardware Requirements

Processor

Minimum 2 GB RAM

Keyboard

Monitor

Storage space for the source code and executable

5. Project Architecture

The major relationship between the data structures is:

                         MARVELLOUS CVFS
                               |
              +----------------+----------------+
              |                |                |
              v                v                v
         BootBlock        SuperBlock          UAREA
                                                |
                                                v
                                              UFDT
                                                |
                         +----------------------+----------------+
                         |                      |                |
                         v                      v                v
                      UFDT[3]                UFDT[4]           ...
                         |                      |
                         v                      v
                    FileTable              FileTable
                         |                      |
                         v                      v
                       Inode                  Inode
                         |                      |
                         v                      v
                      Buffer                  Buffer

5.1 Inode Linked List

The project creates MAXINODE inode objects and connects them using asingly linked list:

HEAD
 |
 v
+--------+     +--------+     +--------+     +--------+     +--------+
| Inode1 | --> | Inode2 | --> | Inode3 | --> | Inode4 | --> | Inode5 |
+--------+     +--------+     +--------+     +--------+     +--------+

Each inode contains a pointer called next.

6. Data Structures

6.1 BootBlock

struct BootBlock
{
    char Information[100];
};

The BootBlock stores information related to the booting/initialisationprocess of CVFS.

The project initializes it with:

Booting process of Marvellous CVFS is completed

6.2 SuperBlock

struct SuperBlock
{
    int TotalInodes;
    int FreeInodes;
};

The SuperBlock maintains:

Total number of inodes

Number of currently free inodes

Initially:

TotalInodes = 5
FreeInodes  = 5

When a file is created, FreeInodes is decreased.

When a file is deleted, FreeInodes is increased.

6.3 Inode

struct Inode
{
    char FileName[20];
    int InodeNumber;
    int FileSize;
    int ActualFileSize;
    int FileType;
    int ReferenceCount;
    int Permission;
    char *Buffer;
    struct Inode *next;
};

The inode stores the main information about a file.

Members

Member             Purpose

FileName         Stores file nameInodeNumber      Unique inode numberFileSize         Maximum allocated file sizeActualFileSize   Number of bytes currently storedFileType         Regular/Special file typeReferenceCount   Number of referencesPermission       File permissionBuffer           Pointer to file datanext             Pointer to next inode

6.4 FileTable

struct FileTable
{
    int ReadOffset;
    int WriteOffset;
    int Mode;
    PINODE ptrinode;
};

The FileTable stores information associated with an opened file entry.

Member          Purpose

ReadOffset    Current read positionWriteOffset   Current write positionMode          File access modeptrinode      Pointer to related inode

6.5 UAREA

struct UAREA
{
    char ProcessName[20];
    PFILETABLE UFDT[MAXOPENFILES];
};

UAREA stores process-specific information.

It contains:

Process name

User File Descriptor Table (UFDT)

The process name is initialized as:

Myexe

6.6 UFDT

UFDT stands for:

User File Descriptor Table

It contains pointers to FileTable structures.

In this project:

PFILETABLE UFDT[MAXOPENFILES];

The first three descriptor positions are reserved by the currentfile-creation implementation, and file creation searches from descriptor3.

7. Important Macros

7.1 File System Limits

#define MAXINODE 5
#define MAXFILESIZE 50
#define MAXOPENFILES 5

Meaning:

Maximum inodes       = 5
Maximum file size    = 50 bytes
Maximum UFDT entries = 5

7.2 Permissions

#define READ 1
#define WRITE 2
#define EXECUTE 4

Permission combinations include:

1 = Read
2 = Write
3 = Read + Write
4 = Execute

The current CreateFile() function accepts permission values from 1to 3.

7.3 File Types

#define REGULARFILE 1
#define SPECIALFILE 2

The current creat implementation creates regular files.

7.4 Offset Constants

#define START 0
#define CURRENT 1
#define END 2

These constants are defined for file-offset operations. An lseekcommand is not implemented in the current main().

8. Error Codes

Macro                        Value Meaning

ERR_INVALID_PARAMETER         -1 Invalid parameterERR_NO_INODES                 -2 No free inode availableERR_FILE_ALREADY_EXIST        -3 File already existsERR_FILE_NOT_EXIST            -4 File does not existERR_PERMISSION_DENIED         -5 Required permission is unavailableERR_INSUFFICIENT_SPACE        -6 Insufficient spaceERR_INSUFFICIENT_DATA         -7 Insufficient dataERR_MAX_FILES_OPEN            -8 Maximum file entries are in use

These return values allow the caller to identify the reason for failure.

9. Function Documentation

9.1 InitialiseUAREA()

Purpose

Initializes UAREA and all UFDT entries.

Main operations

Sets process name to Myexe

Sets all UFDT entries to NULL

9.2 InitialiseSuperBlock()

Purpose

Initializes the SuperBlock.

TotalInodes = MAXINODE
FreeInodes  = MAXINODE

9.3 CreateDILB()

Purpose

Creates the inode linked list.

The function:

Allocates memory for an inode.

Assigns inode number.

Initializes inode members.

Connects the inode to the linked list.

Repeats until MAXINODE nodes are created.

9.4 StartAuxillaryDataInitialisation()

Purpose

Starts initialization of the CVFS auxiliary data.

It calls:

InitialiseUAREA()
InitialiseSuperBlock()
CreateDILB()

9.5 DisplayHelp()

Displays the available command descriptions.

9.6 ManPageDisplay()

Displays a manual page for selected commands such as:

exit
ls
clear
creat
unlink
stat

9.7 IsFileExist()

Purpose

Checks whether a file with the specified name exists in the inode linkedlist.

Return

true  = file exists
false = file does not exist

9.8 CreateFile()

Purpose

Creates a new file and returns its file descriptor.

Major steps

Check free inode availability.

Validate permission.

Check whether file already exists.

Find an unused inode.

Find an available UFDT entry.

Allocate FileTable memory.

Initialize FileTable.

Connect FileTable to inode.

Initialize inode.

Allocate file buffer.

Decrease FreeInodes.

Return file descriptor.

9.9 LsFile()

Displays the names of all currently existing files.

9.10 LsFile_All()

Displays:

File name

Inode number

Actual file size

Example:

Ganesh.txt 1 10

9.11 Stat_File()

Displays statistical information of a specified file.

Information includes:

File name

Inode number

File size

Actual file size

Reference count

Permission

File type

9.12 Unlink_File()

Deletes a file.

Major operations:

Check file existence.

Search UFDT.

Free the file buffer.

Reset inode information.

Free FileTable memory.

Set UFDT entry to NULL.

Increase FreeInodes.

9.13 Write_File()

Writes data into the file buffer.

Steps

Validate file descriptor.

Check write permission.

Check available space.

Copy data to buffer.

Update WriteOffset.

Update ActualFileSize.

Return number of bytes written.

9.14 Read_File()

Reads data from the file buffer.

Steps

Validate file descriptor.

Validate requested size.

Check FileTable.

Check read permission.

Check available data condition.

Copy requested data into the supplied buffer.

Update ReadOffset.

Return number of bytes read.

The main() function allocates one extra byte for the read buffer andadds '\0' after successful reading so that the data can be displayedas a C string.

9.15 main()

main() is the entry point of the project.

It:

Initializes the CVFS.

Displays the CVFS prompt.

Reads commands using fgets().

Tokenizes commands using sscanf().

Calls the appropriate function.

Displays error messages.

Continues until exit is entered.

10. Command Documentation

10.1 help

Syntax

help

Purpose

Displays available commands.

10.2 man

Syntax

man command

Example

man creat

10.3 clear

Syntax

clear

Purpose

Clears the terminal.

On Windows the source uses:

system("cls");

On other platforms it uses:

system("clear");

10.4 creat

Syntax

creat FileName Permission

Example

creat Ganesh.txt 3

Permission

1 = Read
2 = Write
3 = Read + Write

10.5 ls

Syntax

ls

Purpose

Displays names of existing files.

10.6 ls -a

Syntax

ls -a

Purpose

Displays file name, inode number and actual file size.

10.7 stat

Syntax

stat FileName

Example

stat Ganesh.txt

10.8 write

Syntax

write FD

Example

write 3

The program then accepts data from the user.

10.9 read

Syntax

read FD SIZE

Example

read 3 10

This reads 10 bytes using file descriptor 3.

10.10 unlink

Syntax

unlink FileName

Example

unlink Ganesh.txt

10.11 exit

Syntax

exit

Purpose

Terminates the command shell.

11. File Creation Flow

                 creat Ganesh.txt 3
                          |
                          v
                    CreateFile()
                          |
                          v
                 Check FreeInodes
                          |
                          v
                 Validate Permission
                          |
                          v
                  Check File Exists
                          |
                          v
                   Find Empty Inode
                          |
                          v
                   Find Empty UFDT
                          |
                          v
                  Allocate FileTable
                          |
                          v
                  Initialize FileTable
                          |
                          v
                  Connect to Inode
                          |
                          v
                   Allocate Buffer
                          |
                          v
                  Initialize Inode
                          |
                          v
                   FreeInodes--
                          |
                          v
                 Return File Descriptor

12. Write Operation Flow

                     write 3
                       |
                       v
                Accept User Data
                       |
                       v
                  Write_File()
                       |
                       v
                  Validate FD
                       |
                       v
             Check Write Permission
                       |
                       v
              Check Available Space
                       |
                       v
               Copy Data to Buffer
                       |
                       v
                Update WriteOffset
                       |
                       v
             Update ActualFileSize
                       |
                       v
             Return Bytes Written

13. Read Operation Flow

                     read 3 10
                         |
                         v
                Allocate EmptyBuffer
                         |
                         v
                     Read_File()
                         |
                         v
                   Validate FD
                         |
                         v
                 Check FileTable
                         |
                         v
                Check Read Permission
                         |
                         v
                Check Requested Data
                         |
                         v
                Copy Data from Buffer
                         |
                         v
                 Update ReadOffset
                         |
                         v
                 Return Bytes Read
                         |
                         v
                Add '\0' Terminator
                         |
                         v
                  Display Data
                         |
                         v
                  Free Buffer

14. Delete Operation Flow

                  unlink Ganesh.txt
                          |
                          v
                     Unlink_File()
                          |
                          v
                  Check File Exists
                          |
                          v
                    Search UFDT
                          |
                          v
                  Free File Buffer
                          |
                          v
                    Reset Inode
                          |
                          v
                  Free FileTable
                          |
                          v
                    UFDT = NULL
                          |
                          v
                   FreeInodes++

15. Compilation and Execution

Step 1: Save the source file

Save the source code as:

program652.c

Recommended project structure:

Marvellous-CVFS/
│
├── program652.c
└── README.md

Step 2: Open Terminal

Open PowerShell, Command Prompt, or Terminal in the project folder.

Step 3: Compile

Windows/Linux

gcc program652.c -o Myexe

If compilation is successful, an executable is generated.

On Windows:

Myexe.exe

Step 4: Run

Windows PowerShell

.\Myexe.exe

Linux

./Myexe

16. Sample Execution

Initialization

Booting process of Marvellous CVFS is completed
Marvellous CVFS : UAREA gets initalised succesfully
Marvellous CVFS : Super Block gets initalised succesfully
Marvellous CVFS : DILB gets created succesfully

-----------------------------------------------------------------------------------------------
---------------------------- Marvellous CVFS started succesfully ------------------------------
-----------------------------------------------------------------------------------------------

Create a file

Marvellous CVFS : > creat Ganesh.txt 3
File succesfully created with FD : 3

List files

Marvellous CVFS : > ls

Ganesh.txt

Display file information

Marvellous CVFS : > stat Ganesh.txt

File name : Ganesh.txt
Inode Number : 1
File Size : 50
Actual File Size : 0
Reference Count : 1
File Permission : Read + Write
File Type : Regular File

Write data

Marvellous CVFS : > write 3

Enter the data that you want to write into the file :
Hello CVFS

10 bytes gets succesfully written into the file

Read data

Marvellous CVFS : > read 3 10

Read operation is succesful
Data from file is :
Hello CVFS

List with details

Marvellous CVFS : > ls -a

Ganesh.txt 1 10

Delete

Marvellous CVFS : > unlink Ganesh.txt

Exit

Marvellous CVFS : > exit

Thank you for using Marvellous CVFS
Deallocating all resources of Marvellous CVFS

17. Testing

Test Case 1 -- Create File

Input

creat Test.txt 3

Expected Result

A new regular file is created and a file descriptor is returned.

Test Case 2 -- Duplicate File

Input

creat Test.txt 3
creat Test.txt 3

Expected Result

Error : Unable to create new file
Because the file name is already present

Test Case 3 -- Invalid Permission

Input

creat Test.txt 8

Expected Result

Invalid parameter error.

Test Case 4 -- List Files

Input

ls

Expected Result

All existing file names are displayed.

Test Case 5 -- Write

Input

write 3
Hello CVFS

Expected Result

The number of successfully written bytes is displayed.

Test Case 6 -- Read

Input

read 3 10

Expected Result

Hello CVFS

Test Case 7 -- File Information

Input

stat Test.txt

Expected Result

File information is displayed.

Test Case 8 -- Delete

Input

unlink Test.txt

Expected Result

The file is removed and its allocated buffer/FileTable are released.

18. Memory Management

The project uses dynamic memory allocation.

Inode Allocation

newn = (PINODE)malloc(sizeof(INODE));

FileTable Allocation

uareaobj.UFDT[i] = (PFILETABLE)malloc(sizeof(FILETABLE));

File Buffer Allocation

uareaobj.UFDT[i]->ptrinode->Buffer =
    (char *)malloc(MAXFILESIZE);

Read Buffer Allocation

The current read implementation allocates:

EmptyBuffer = (char *)malloc(atoi(Command[2]) + 1);

The extra byte is used for:

EmptyBuffer[iRet] = '\0';

After displaying the data:

free(EmptyBuffer);
EmptyBuffer = NULL;

When a file is deleted, its data buffer and FileTable are also freed.

19. Current Implementation Status

Module/Command              Status

BootBlock initialization    ImplementedSuperBlock initialization   ImplementedUAREA initialization        ImplementedUFDT initialization         ImplementedInode linked list           ImplementedFile creation               ImplementedFile listing                ImplementedDetailed file listing       ImplementedFile statistics             ImplementedFile deletion               ImplementedFile writing                ImplementedFile reading                ImplementedHelp                        ImplementedManual page                 Partially implementedClear                       ImplementedExit                        ImplementedOpen                        Not implemented in current main()Close                       Not implemented in current main()Lseek                       Not implemented in current main()

The current source contains definitions for START, CURRENT, andEND, but the lseek operation itself is not implemented in thesupplied code.

20. Limitations and Future Enhancements

The current project is an in-memory virtual file system. The followingimprovements can be made in future:

Implement open.

Implement close.

Implement lseek.

Improve complete resource cleanup when exit is executed.

Add more extensive input validation.

Support multiple processes.

Add directory support.

Add special-file support.

Add execute permission handling.

Add persistent storage if required.

Improve command parsing.

Add more test cases.

21. Conclusion

Marvellous CVFS provides a practical implementation of a simplified filesystem using C.

The project demonstrates how:

UAREA
  ↓
UFDT
  ↓
FileTable
  ↓
Inode
  ↓
Data Buffer

are connected to manage virtual files.

It also demonstrates important C and System Programming conceptsincluding structures, pointers, linked lists, dynamic memory allocation,string handling, command parsing, file permissions, offsets, and errorhandling.

The project therefore provides a practical understanding of the basicinternal organization and operation of a file system.

22. Author

Name: Vaishnavi Deepak Morankar

Project: CVFS

Technology: C

Domain: System Programming
