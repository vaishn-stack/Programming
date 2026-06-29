#include<stdio.h>

typedef unsigned int UINT;

UINT OffBit(UINT iNo)
{
    UINT iMask = 0xFFFFFDBF;

    return (iNo & iMask);
}

int main()
{
    UINT iValue = 0;

    printf("Enter number : ");
    scanf("%u",&iValue);

    iValue = OffBit(iValue);

    printf("Modified number : %u\n",iValue);

    return 0;
}