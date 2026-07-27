#include<stdio.h>

int Mult(int iNo)
{
    int iMult = 0;

    if(iNo == 0)
    {
        return 1;
    }

    iMult = iNo % 10;
    iNo = iNo / 10;
    iMult = iMult * Mult(iNo);

    return iMult;
}

int main()
{
    int iValue = 0, iRet = 0;

    printf("Enter number : ");
    scanf("%d", &iValue);

    iRet = Mult(iValue);

    printf("Multiplication of digits : %d\n",iRet);

    return 0;
}