#include<stdio.h>

void Display(int iCnt, int iNo)
{
    if(iCnt >= iNo)
    {
        printf("%d\t*\t",iCnt);
        Display(iCnt - 1, iNo);
    }

    printf("\n");
}

int main()
{
    int iValue = 0;

    printf("Enter number : \n");
    scanf("%d", &iValue);

    Display(iValue,1);

    return 0;
}