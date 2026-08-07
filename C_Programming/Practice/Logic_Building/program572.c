#include<stdio.h>
#include<fcntl.h>

int main()
{
    int fd = 0;    //File Descriptor

    fd = creat("Marvellous.txt",0777);         // Marvellous. txt - filename, 0777 - Permission

    if(fd == -1)
    {
        printf("Unable to create file \n");
    }
    else
    {
        printf("File gets created Successfully!....");
    }

    return 0;
}