#include<stdio.h>

void Display(int iNo)
{
    int iCnt = 0;
    iCnt = iNo; 

    if(iCnt >= 1)
    {
        printf("%d\t",iCnt);
        Display(iCnt - 1);
    }

    printf("\n");
}

int main()
{
    Display(5);

    return 0;
}