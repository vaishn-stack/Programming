#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>
#include<string.h>
#include<sys/stat.h>        // Linux

#define BUFFER_SIZE 1024

void DisplayFileInformation(char FileName[])
{
    struct stat sobj;

    stat(FileName,&sobj);

    printf("File name : %s\n",FileName);
    printf("Inode number : %llu\n",sobj.st_ino);
    printf("File Size is : %d\n",sobj.st_size);
}

int main()
{
    char Fname[30] = {'\0'};
    int iRet = 0;
    
    printf("Enter the file name : \n");
    scanf("%[^'\n]s",Fname);
    
    DisplayFileInformation(Fname);

    return 0;
}