#include<stdio.h>

void strNCpyX(char *src, char *dest, int iCnt)
{
    while((*src != '\0') && (iCnt > '\0'))
    {
        *dest = *src;
        src++;
        dest++;
        iCnt--;
    }

    *dest = '\0';
}

int main()
{
    char arr[30] = "Marvellous Multi OS";
    char brr[30];                          

    strNCpyX(arr,brr,10);

    printf("%s",brr);                    

    return 0;
}