#include<stdio.h>

int CountEven(int iNo)
{
    int iCnt = 0;
    int iDigit = 0;
    
    while(iNo != 0)
    {
        iDigit = iNo % 10;

        if(iDigit % 2 == 0)
        {
            iCnt++;
        }

        iNo = iNo / 10;
    }

    return iCnt;

}

int main()
{
    int iValue = 0;
    int iRet = 0;

    printf("Enter number : ");
    scanf("%d",&iValue);

    iRet = CountEven(iValue);

     printf("Number of even digits are : %d\n", iRet);

    return 0;
}