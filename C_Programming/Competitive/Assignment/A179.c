#include<stdio.h>

typedef unsigned int UINT;

UINT ToggleBit(UINT iNo)
{
    UINT iMask = 0x00000240;

    return (iNo ^ iMask);
}

int main()
{
    UINT iValue = 0;

    printf("Enter number : ");
    scanf("%u",&iValue);

    iValue = ToggleBit(iValue);

    printf("Modified number : %u\n",iValue);

    return 0;
}