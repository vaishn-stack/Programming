#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>
#include<string.h>

#define BUFFER_SIZE 1024
#define ERR_OPEN -1

int CountSmall(char *FileName)
{
    char Buffer[BUFFER_SIZE] = {'\0'};
    int iRet = 0, fd = 0, iCount = 0, i = 0;

    fd = open(FileName, O_RDONLY);

    if(fd == -1)
    {
        return ERR_OPEN;
    }

    while((iRet = read(fd,Buffer,sizeof(Buffer))) != 0)
    {
        for(i = 0; i < iRet; i++)
        {
            if(Buffer[i] >= 'a' && Buffer[i] <= 'z')
            {
                iCount++;
            }
        }
        memset(Buffer,'\0',sizeof(Buffer));
    }

    return iCount;

    close(fd);
}

int main()
{
    char Fname[30] = {'\0'};
    int iRet = 0;
    
    printf("Enter the file name : \n");
    scanf("%[^'\n]s",Fname);
    
    iRet = CountSmall(Fname);

    if(iRet == ERR_OPEN)
    {
        printf("Unable to open file\n");
    }
    else
    {
        printf("Count small letters in that file : %d\n", iRet);
    }

    return 0;
}