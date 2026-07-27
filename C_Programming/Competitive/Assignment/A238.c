#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>

int CountWhite(char FName[])
{
    int fd = 0, iRet = 0, iCnt = 0, i = 0;
    char Buffer[100];

    fd = open(FName, O_RDONLY);

    if(fd == -1)
        return -1;

    while((iRet = read(fd, Buffer, sizeof(Buffer))) != 0)
    {
        for(i = 0; i < iRet; i++)
        {
            if(Buffer[i] == ' ')
                iCnt++;
        }
    }

    close(fd);
    return iCnt;
}

int main()
{
    char FileName[30];
    int iRet;

    printf("Enter file name : ");
    scanf("%s", FileName);

    iRet = CountWhite(FileName);

    printf("Number of white spaces are %d\n", iRet);

    return 0;
}