#include<stdio.h>

void Display(int iCnt, int iNo)
{
    if(iCnt <= iNo)
    {
        printf(" * \t");
        Display(iCnt + 1, iNo);
    }

    printf("\n");
}

int main()
{
    int iValue = 0;

    printf("Enter number : \n");
    scanf("%d", &iValue);

    Display(1,iValue);

    return 0;
}