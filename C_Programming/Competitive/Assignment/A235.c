#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>

int main()
{
    char FileName[30], Buffer[100];
    int fd = 0, iRet = 0;

    printf("Enter file name : ");
    scanf("%s", FileName);

    fd = open(FileName, O_RDONLY);

    if(fd == -1)
    {
        printf("Unable to open file\n");
        return 0;
    }

    while((iRet = read(fd, Buffer, sizeof(Buffer)-1)) != 0)
    {
        Buffer[iRet] = '\0';
        printf("%s", Buffer);
    }

    close(fd);

    return 0;
}