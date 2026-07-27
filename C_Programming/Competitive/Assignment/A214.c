#include<stdio.h>

void Display(char ch)
{
    if(ch <= 'F')
    {
        printf("%c\t",ch);
        Display(ch + 1);
    }

    printf("\n");
}

int main()
{
    Display('A');

    return 0;
}