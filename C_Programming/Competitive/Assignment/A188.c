#include<stdio.h>

typedef unsigned int UINT;
typedef int BOOL;

#define TRUE 1
#define FALSE 0

BOOL ChkBit(UINT iNo)
{
    UINT iMask = 0x900;   // 9th + 12th

    if((iNo & iMask) != 0)
        return TRUE;
    else
        return FALSE;
}

int main()
{
    UINT iValue;
    BOOL bRet;

    printf("Enter number : ");
    scanf("%u",&iValue);

    bRet = ChkBit(iValue);

    if(bRet)
        printf("TRUE");
    else
        printf("FALSE");

    return 0;
}