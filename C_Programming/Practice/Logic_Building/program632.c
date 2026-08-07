#include<stdio.h>

int main()
{
    char str[50];
    int iRet = 0;

    iRet = sprintf(str, "Jay Ganesh...");

    printf("Value from iRet is : %d\n",iRet);

    return 0;
}

