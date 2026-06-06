// accept the no user check whether even or odd --> check whether asel teva answer will be true or false

#include<stdio.h>

int CheckEvenOdd(int iNo)                          
{
    int iRemainder = 0;

    iRemainder = iNo % 2;

    return iRemainder;
}

int main()
{
    int iValue = 0;
    int iRet = 0;

    printf("Enter number : \n");
    scanf("%d",&iValue);

    iRet = CheckEvenOdd(iValue);

    if(iRet == 0)
    {
        printf("Number is Even.\n");
    }
    else
    {
        printf("Number is Odd.\n");
    }

    return 0;
}