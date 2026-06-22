#include<stdio.h>

void strCpyX(char *src, char *dest)
{
    while(*src != '\0')
    {
        *dest = *src;
        src++;
        dest++;
    }

    *dest = '\0';
}

int main()
{
    char arr[30] = "Marvellous Multi OS";
    char brr[30];                          // Empty string

    strCpyX(arr,brr);

    printf("%s",brr);                     // Marvellous Multi OS

    return 0;
}