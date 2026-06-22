#include<stdio.h>

void DisplayASCII()
{
    int i = 0;

    for(i = 0; i <= 255; i++)
    {
        printf("%d\t %c\n",i,i);
    }
}

int main()
{
    DisplayASCII();

    return 0;
}