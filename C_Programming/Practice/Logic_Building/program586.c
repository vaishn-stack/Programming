#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>              // only linux based os
#include<string.h>

#define BUFFER_SIZE 100

int main()
{
    int fd = 0;    
    int iRet = 0;
    char Data[BUFFER_SIZE] = {'\0'};

    fd = open("Marvellous.txt",O_RDONLY);        

    if(fd == -1)
    {
        printf("Unable to open file \n");
    }
    else
    {
        printf("File gets Successfully opened with fd : %d\n", fd);
        iRet = read(fd, Data, 13);
        printf("%d bytes gets successfully read \n", iRet);
        printf("Data from file is : %s\n", Data);

        memset(Data,'\0', sizeof(Data));
        iRet = read(fd, Data, 3);
        printf("%d bytes gets successfully read \n", iRet);
        printf("Data from file is : %s\n", Data);

        close(fd);
    }

    return 0;
}