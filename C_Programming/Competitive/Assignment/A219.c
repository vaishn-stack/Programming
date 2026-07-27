#include<stdio.h>

void Display(char ch,int iNo)
{
    if(iNo > 0)
    {
        printf("%c\t",ch);
        Display(ch + 1, iNo - 1);
    }

    printf("\n");
}

int main()
{
    int iValue = 0;

    printf("Enter number : \n");
    scanf("%d", &iValue);

    Display('A',iValue);

    return 0;
}