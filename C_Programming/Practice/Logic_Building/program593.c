#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>              // only linux based os
#include<string.h>

#define BUFFER_SIZE 1024  // macro

int main()
{
    char Buffer[BUFFER_SIZE] = {'\0'};
    int iRet = 0, fd = 0;

    fd = open("program592.c", O_RDONLY);

    while((iRet = read(fd,Buffer,sizeof(Buffer))) != 0)
    {
        printf("%s", Buffer);
        memset(Buffer,'\0',sizeof(Buffer));
    }
    
    close(fd);
    return 0;
}