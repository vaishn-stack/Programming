#include<stdio.h>

void strCatX(char *src, char *dest)
{
    if((src == NULL) || (dest == NULL))
    {
        return;
    }

    while(*dest != '\0')
    {
        dest++;
    }

    while(*src != '\0')
    {
        *dest = *src;
        dest++;
        src++;
    }

    *dest = '\0';
}

int main()
{
    char arr[50] = "Marvellous Multi OS";
    char brr[50] = "Logic Building";

    strCatX(brr, arr);

    printf("%s\n", arr);

    return 0;
}