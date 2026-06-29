#include<stdio.h>

typedef unsigned int UINT;

UINT OnBit(UINT iNo)
{
    UINT iMask = 0x0000000F;

    return (iNo | iMask);
}

int main()
{
    UINT iValue = 0;

    printf("Enter number : ");
    scanf("%u",&iValue);

    iValue = OnBit(iValue);

    printf("Modified number : %u\n",iValue);

    return 0;
}