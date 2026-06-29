#include<stdio.h>

typedef unsigned int UINT;

UINT ToggleBit(UINT iNo)
{
    UINT iMask = 0xF000000F;

    return (iNo ^ iMask);
}

int main()
{
    UINT iValue = 0;

    printf("Enter number : ");
    scanf("%u",&iValue);

    printf("%u",ToggleBit(iValue));

    return 0;
}