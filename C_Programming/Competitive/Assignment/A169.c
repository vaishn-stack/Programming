#include<stdio.h>

void strCpySmall(char *src, char *dest)
{
    //Filter
    if((src == NULL) || (dest == NULL))
    {
        return;
    }

    while(*src != '\0')
    {
        if((*src >= 'a') && (*src <= 'z'))
        {
            *dest = *src;
            dest++;
        }
        src++;
    }

    *dest = '\0';
}

int main()
{
    char arr[30] = "Marvellous Multi OS";
    char brr[30];                          

    strCpySmall(arr,brr);

    printf("%s",brr);                    

    return 0;
}