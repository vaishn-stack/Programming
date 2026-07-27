#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>

int main()
{
    char FileName[30];
    int fd = 0;

    printf("Enter file name : ");
    scanf("%s", FileName);

    fd = open(FileName, O_CREAT, 0777);

    if(fd == -1)
    {
        printf("Unable to create file\n");
    }
    else
    {
        printf("File created successfully\n");
        close(fd);
    }

    return 0;
}