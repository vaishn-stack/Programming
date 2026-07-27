#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>

void DisplayN(char FName[], int iSize)
{
    int fd = 0, iRet = 0;
    char Buffer[100];

    fd = open(FName, O_RDONLY);

    if(fd == -1)
        return;

    iRet = read(fd, Buffer, iSize);

    Buffer[iRet] = '\0';

    printf("%s\n", Buffer);

    close(fd);
}

int main()
{
    char FileName[30];
    int No;

    printf("Enter file name : ");
    scanf("%s", FileName);

    printf("Enter number of characters : ");
    scanf("%d", &No);

    DisplayN(FileName, No);

    return 0;
}