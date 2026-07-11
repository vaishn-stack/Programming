#include<stdio.h>

typedef unsigned int UINT;
int main()
{
    UINT iMask = 1;
    int iCnt = 0;

    for(iCnt = 1; iCnt <= 32; iCnt++)
    {
        printf("%d : %X\n",iCnt,iMask);       
        iMask = iMask << 1;
    }
    
    return 0;
}

// LSB (least significant bit/ byte) & MsB (most significant bit/ byte)