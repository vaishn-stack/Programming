#include<stdio.h>

int Reverse(int iNo)
{
    static int iRev = 0;

    if(iNo == 0)
    {
        return iRev;
    }

    iRev = (iRev * 10) + (iNo % 10);

    Reverse(iNo / 10);

    return iRev;
}

int main()
{
    int iValue = 0;
    int iRet = 0;

    printf("Enter number : ");
    scanf("%d",&iValue);

    iRet = Reverse(iValue);

    printf("Reverse number is : %d\n",iRet);

    return 0;
}