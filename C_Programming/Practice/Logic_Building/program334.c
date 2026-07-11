#include<stdio.h>

typedef unsigned int UINT;

UINT ToggleBit(UINT iNo, UINT iPos)
{
    UINT iMask = 0x1;
    UINT iResult = 0;

    iMask = iMask << (iPos - 1);
    iResult = iNo ^ iMask;

    return iResult;
}

int main()
{    
    UINT iValue = 0, iRet = 0, iLocation = 0;

    printf("Enter number : \n");
    scanf("%d",&iValue);

    printf("Enter the bit position : \n");
    scanf("%d",&iLocation);

    iRet = ToggleBit(iValue, iLocation);

    printf("Updated number is : %d\n",iRet);

    return 0;
}
// Github