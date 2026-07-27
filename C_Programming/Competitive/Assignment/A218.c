#include<stdio.h>

void Display(int iCnt)
{
    if(iCnt >= 1)
    {
        printf("%d\t", iCnt);
        Display(iCnt - 1);
    }

    printf("\n");
}

int main()
{
    int iValue = 0;

    printf("Enter number : \n");
    scanf("%d", &iValue);

    Display(iValue);

    return 0;
}