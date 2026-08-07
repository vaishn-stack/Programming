#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>              // only linux based os

int main()
{
    int fd = 0;    
    int iRet = 0;
    char Data[] = "Marvellous Infosystems";

    fd = open("Marvellous.txt",O_RDWR | O_APPEND);        

    if(fd == -1)
    {
        printf("Unable to open file \n");
    }
    else
    {
        printf("File gets Successfully opened with fd : %d\n", fd);
        iRet = write(fd, Data, 10);
        printf("%d bytes gets successfully written \n", iRet);
        close(fd);
    }

    return 0;
}