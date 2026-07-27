#include<stdio.h>

void Display(char ch)
{
    if(ch <= 'f')
    {
        printf("%c\t",ch);
        Display(ch + 1);
    }

    printf("\n");
}

int main()
{
    Display('a');

    return 0;
}