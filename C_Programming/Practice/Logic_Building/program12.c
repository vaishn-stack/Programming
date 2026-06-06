// accept the no user check whether even or odd --> check whether asel teva answer will be true or false

#include<stdio.h>

void CheckEvenOdd(int iNo)                     // return value nhi ae mhnun void
{
    int iRemainder = 0;

    iRemainder = iNo % 2;

    if(iRemainder == 0)                         
    {
        printf("Number is Even\n");
    }
    else
    {
        printf("Number is Odd\n");
    }
}

int main()
{
    int iValue = 0;

    printf("Enter number : \n");
    scanf("%d",&iValue);

    CheckEvenOdd(iValue);

    return 0;
}