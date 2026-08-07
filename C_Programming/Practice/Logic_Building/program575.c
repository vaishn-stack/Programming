#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>              // only linux based os

int main()
{
    int fd = 0;    

    fd = open("Marvellous.txt",O_RDONLY);        

    if(fd == -1)
    {
        printf("Unable to open file \n");
    }
    else
    {
        printf("File gets Successfully opened with fd : %d\n", fd);
        close(fd);
    }

    return 0;
}