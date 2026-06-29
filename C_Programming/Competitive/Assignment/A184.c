#include<stdio.h>

typedef unsigned int UINT;

UINT ToggleBit(UINT iNo, int iPos)
{
    UINT iMask = 1;

    iMask = iMask << (iPos-1);

    return (iNo ^ iMask);
}

int main()
{
    UINT iValue = 0;
    int iPos = 0;

    printf("Enter number and position : ");
    scanf("%u%d",&iValue,&iPos);

    printf("%u",ToggleBit(iValue,iPos));

    return 0;
}