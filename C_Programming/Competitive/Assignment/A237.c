#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>
#include<string.h>

int main()
{
    char FileName[30];
    char Str[100];
    int fd = 0;

    printf("Enter file name : ");
    scanf("%s", FileName);

    getchar();

    printf("Enter string : ");
    fgets(Str,100,stdin);

    fd = open(FileName, O_WRONLY | O_APPEND);

    if(fd == -1)
    {
        printf("Unable to open file\n");
        return 0;
    }

    write(fd, Str, strlen(Str));

    printf("Data written successfully\n");

    close(fd);

    return 0;
}