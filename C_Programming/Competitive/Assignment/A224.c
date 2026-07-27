#include<stdio.h>

int Fact(int iNo)
{
    int iFact = 1;

    if(iNo == 0)
    {
        return 1;
    }
    iFact = iNo;
    iFact = iFact * Fact(iNo - 1);

    return iFact;
}

int main()
{
    int iValue = 0, iRet = 0;

    printf("Enter number : ");
    scanf("%d", &iValue);

    iRet = Fact(iValue);

    printf("Factorial is : %d\n", iRet);

    return 0;
}