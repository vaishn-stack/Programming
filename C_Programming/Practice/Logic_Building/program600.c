#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>
#include<string.h>

#define BUFFER_SIZE 1024

int CalculateFileSize(char FileName[])
{
    char Buffer[BUFFER_SIZE] = {'\0'};
    int iRet = 0, fd = 0, iSize = 0;

    fd = open(FileName, O_RDONLY);

    if(fd == -1)
    {
        printf("Unable to open the file \n");
        return -1;
    }

    while((iRet = read(fd,Buffer,sizeof(Buffer))) != 0)
    {
        iSize = iSize + iRet;
    }

    close(fd);

    return iSize;
}

int main()
{
    char Fname[30] = {'\0'};
    int iRet = 0;
    
    printf("Enter the file name : \n");
    scanf("%[^'\n]s",Fname);
    
    iRet = CalculateFileSize(Fname);

    printf("File Size is : %d bytes\n", iRet);

    return 0;
}