#include<stdio.h>

typedef unsigned int UINT;
typedef int BOOL;

#define TRUE 1
#define FALSE 0

BOOL ChkBit(UINT iNo,int iPos1,int iPos2)
{
    UINT iMask1 = 1;
    UINT iMask2 = 1;

    iMask1 = iMask1 << (iPos1-1);
    iMask2 = iMask2 << (iPos2-1);

    if((iNo & iMask1) || (iNo & iMask2))
        return TRUE;
    else
        return FALSE;
}

int main()
{
    UINT iValue;
    int iPos1,iPos2;
    BOOL bRet;

    printf("Enter number and positions : ");
    scanf("%u%d%d",&iValue,&iPos1,&iPos2);

    bRet = ChkBit(iValue,iPos1,iPos2);

    if(bRet)
        printf("TRUE");
    else
        printf("FALSE");

    return 0;
}