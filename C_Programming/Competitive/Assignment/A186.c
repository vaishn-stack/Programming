#include<stdio.h>

typedef unsigned int UINT;

UINT CountOne(UINT iNo)
{
    UINT iCnt = 0;

    while(iNo != 0)
    {
        if((iNo & 1) == 1)
        {
            iCnt++;
        }
        iNo = iNo >> 1;
    }
    return iCnt;
}

int main()
{
    UINT iValue = 0;

    printf("Enter number : ");
    scanf("%u",&iValue);

    printf("%u",CountOne(iValue));

    return 0;
}