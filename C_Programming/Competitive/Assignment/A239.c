#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>

int CountChar(char FName[], char Ch)
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
            if(Buffer[i] == Ch)
                iCnt++;
        }
    }

    close(fd);
    return iCnt;
}

int main()
{
    char FileName[30], ch;
    int iRet;

    printf("Enter file name : ");
    scanf("%s", FileName);

    printf("Enter character : ");
    scanf(" %c", &ch);

    iRet = CountChar(FileName, ch);

    printf("Frequency is %d\n", iRet);

    return 0;
}