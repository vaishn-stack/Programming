/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 
// Header Files Inclusion  
// 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>
#include<string.h>
#include<stdlib.h>
#include<stdbool.h>

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 
// User Defined macros 
// 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

#define MAXINODE 10
#define MAXFILESIZE 50
#define MAXOPENFILES 10

#define READ 1
#define WRITE 2
#define EXECUTE 4

#define START 0
#define CURRENT 1
#define END 2

#define EXECUTE_SUCCESS 0

#define REGULARFILE 1
#define SPECIALFILE 2

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 
// User Defined macros for Error Handling
// 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

#define ERR_INVALID_PARAMETER -1

#define ERR_NO_INODES -2

#define ERR_FILE_ALREADY_EXIST -3
#define ERR_FILE_NOT_EXIST -4

#define ERR_PERMISSION_DENIED -5

#define ERR_INSUFFICIENT_SPACE -6
#define ERR_INSUFFICIENT_DATA -7

#define ERR_MAX_FILES_OPEN -8

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 
// Structure Name : Boot Block
// Description :    It holds the information to boot the Operating system
// 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

struct BootBlock
{
    char Information[100];
};

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 
// Structure Name : Super Block
// Description :    It holds the information of complete File System
// 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

struct SuperBlock
{
    int TotalInodes;
    int FreeInodes;
};

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 
// Structure Name : Inode
// Description :    It holds information of File
// 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

#pragma pack(1)

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

typedef struct Inode INODE;
typedef struct Inode* PINODE;
typedef struct Inode** PPINODE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 
// Structure Name : File Table
// Description :    It holds information of opened Files
// 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

#pragma pack(1)

struct FileTable
{
    int ReadOffset;
    int WriteOffset;
    int Mode;
    PINODE ptrinode;
};

typedef struct FileTable FILETABLE;
typedef struct FileTable* PFILETABLE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 
// Structure Name : UAREA
// Description :    It holds information of Process
// 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

#pragma pack(1)

struct UAREA
{
    char ProcessName[20];
    PFILETABLE UFDT[MAXOPENFILES];
};

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 
// Global variables used in the project 
// 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

struct BootBlock bootobj;
struct SuperBlock superobj;
// struct FileTable fobj;
struct UAREA uareaobj;

PINODE head = NULL;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 
// Function Name : InitialiseUAREA()
// Description :   It is used to initialise UAREA
// Author :        Vaishnavi Deepak Morankar
// Date :          31/07/2026
// 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

void InitialiseUAREA()
{
    int i = 0;

    strcpy(uareaobj.ProcessName, "Myexe");

    for(i = 0; i < MAXOPENFILES; i++)
    {
        uareaobj.UFDT[i] = NULL;
    }

    printf("Marvellous CVFS : UAREA gets initialised successfully! \n");
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 
// Function Name : InitialiseSuperBlock()
// Description :   It is used to initialise super block
// Author :        Vaishnavi Deepak Morankar
// Date :          31/07/2026
// 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

void InitialiseSuperBlock()
{
    superobj.TotalInodes = MAXINODE;
    superobj.FreeInodes = MAXINODE;

    printf("Marvellous CVFS : Super Block gets initialised successfully! \n");
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 
// Function Name : CreateDILB()
// Description :   It is used to Create Linked List of Inodes
// Author :        Vaishnavi Deepak Morankar
// Date :          31/07/2026
// 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

void CreateDILB()
{
    PINODE temp = NULL;
    PINODE newn = NULL;

    int i = 0;

    temp = head;

    for(i = 1; i <= MAXINODE; i++)
    {
        newn = (PINODE) malloc (sizeof(INODE));

        newn -> InodeNumber = i;
        strcpy(newn -> FileName, "\0");
        newn -> FileSize = 0;
        newn -> ActualFileSize = 0;
        newn -> FileType = 0;
        newn -> ReferenceCount = 0;
        newn -> Permission = 0;
        newn -> Buffer = NULL;

        if(temp == NULL)
        {
            head = newn;
            temp = head;
        }
        else
        {
            temp -> next = newn;
            temp = temp -> next;
        }
    }

    printf("Marvellous CVFS : DILB gets created successfully! \n");
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 
// Function Name : StartAuxillaryDataInitialisation()
// Description :   It is used to Call all such functions which are used to initialise auxillary data
// Author :        Vaishnavi Deepak Morankar
// Date :          31/07/2026
//
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

void StartAuxillaryDataInitialisation()
{
    strcpy(bootobj.Information, "Booting Process of Marvellous CVFS is completed.");

    printf("%s\n", bootobj.Information);
    
    InitialiseUAREA();
    InitialiseSuperBlock();

    CreateDILB();
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 
// Function Name : DisplayHelp()
// Description :   It is used to help to the user of project
// Author :        Vaishnavi Deepak Morankar
// Date :          01/08/2026
//
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

void DisplayHelp()
{
    printf("---------------------------------------------------------------------------------------------------\n");
    printf("----------------------------------Marvellous CVFS Help Page----------------------------------------\n");
    printf("---------------------------------------------------------------------------------------------------\n");

    printf("man :       It is used to display the manual page.\n");
    printf("clear :     It is used to clear the terminal page.\n");
    printf("creat :     It is used to create new regular file.\n");
    printf("open :      It is used to open the regular file.\n");
    printf("close :     It is used to close the regular file.\n");
    printf("write :     It is used to write the data into the file.\n");
    printf("read :      It is used to read the data from the file.\n");
    printf("stat :      It is used to display statistical information of the file.\n");
    printf("unlink :    It is used to delete the file.\n");
    printf("exit :      It is used to terminate Marvellous CVFS.\n");

    printf("---------------------------------------------------------------------------------------------------\n");
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 
// Function Name : ManPageDisplay()
// Description :   It is used to display man page of specific command
// Input :         Name of Command
// Author :        Vaishnavi Deepak Morankar
// Date :          01/08/2026
//
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

void ManPageDisplay(char Name[])
{
    if(strcmp(Name, "exit") == 0)
    {
        printf("About : It is used to terminate the project.\n");
        printf("Usage : exit\n");
    }
    else if(strcmp(Name, "ls") == 0)
    {
        printf("About : It is used to list all files from current directory.\n");
        printf("Usage : ls\n");
    }
    else if(strcmp(Name, "clear") == 0)
    {
        printf("About : It is used to clear the terminal.\n");
        printf("Usage : ls\n");
    }
    else
    {
        printf("No manual entry found for %s\n", Name);
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 
// Entry point Function of CVFS Project
// 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

int main()
{   
    // comment takaychi baki ae
    char str[80] = {'\0'};
    char Command[5][20] = {{'\0'}};

    // int iRet = 0;
    int iCount = 0;

    StartAuxillaryDataInitialisation();
    
    printf("---------------------------------------------------------------------------------------------------\n");
    printf("---------------------------Marvellous CVFS Started Successfully!-----------------------------------\n");
    printf("---------------------------------------------------------------------------------------------------\n");

    // Infinite Listenning Shell

    while(1)
    {
        fflush(stdin);          // clear old input buffer

        strcpy(str, "");        // Clear string buffer

        printf("\n Marvellous CVFS : > ");
        fgets(str, sizeof(str), stdin);

        iCount = sscanf(str, "%s %s %s %s %s", Command[0], Command[1], Command[2], Command[3], Command[4]);

        fflush(stdin);

        if(iCount == 1)
        {
            if(strcmp(Command[0], "exit") == 0)
            {
                printf("Thank you for using MMarvellous CVFS...\n");
                printf("Deallocating all resources of Marvellous CVFS...\n");

                break;
            }
            else if(strcmp(Command[0], "help") == 0)
            {
                DisplayHelp();
            }
            else if(strcmp(Command[0], "cls") == 0)
            {
                #ifdef _WIN32
                    system("cls");
                #else
                    system("clear");
                #endif
            }
            else
            {
                printf("Command not found\n");
                printf("Please refer help option to get more information...\n");
                printf("Please refer manual page of command using man...\n");
            }
        }
        else if(iCount == 2)
        {
            if(strcmp(Command[0], "man") == 0)
            {
                ManPageDisplay(Command[1]);
            }
            else
            {
                printf("Command not found\n");
                printf("Please refer help option to get more information...\n");
                printf("Please refer manual page of command using man...\n");
            }
        }
        else if(iCount == 3)
        {

        }
        else if(iCount == 4)
        {

        }
        else
        {
            printf("Command not found\n");
            printf("Please refer help option to get more information...\n");
            printf("Please refer manual page of command using man...\n");
        }
    } // End of While

    return 0;
} // End of main