#include<stdio.h>

int Sum(int iNo)
{
    int iSum = 0;

    if(iNo == 0)
    {
        return 0;
    }

    iSum = iNo % 10;
    iNo = iNo / 10;
    iSum = iSum + Sum(iNo);

    return iSum;
}

int main()
{
    int iValue = 0, iRet = 0;

    printf("Enter number : ");
    scanf("%d", &iValue);

    iRet = Sum(iValue);

    printf("Summation of digits : %d\n",iRet);

    return 0;
}