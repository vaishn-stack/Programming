#include<stdio.h>

typedef unsigned int UINT;

UINT ToggleBitRange(UINT iNo,int iStart,int iEnd)
{
    UINT iMask = 0;

    while(iStart <= iEnd)
    {
        iMask = iMask | (1 << (iStart-1));
        iStart++;
    }

    return (iNo ^ iMask);
}

int main()
{
    UINT iValue;
    int iStart,iEnd;

    printf("Enter number : ");
    scanf("%u",&iValue);

    printf("Enter start and end position : ");
    scanf("%d%d",&iStart,&iEnd);

    printf("%u",ToggleBitRange(iValue,iStart,iEnd));

    return 0;
}