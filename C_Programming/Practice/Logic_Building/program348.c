#include<stdio.h>

typedef unsigned int UINT;
// position 3 and 8

int main()
{    
    UINT iMask1 = 0x00000004;
    UINT iMask2 = 0x00000080;
    UINT iMask = 0;

    UINT iNo = 0;
    UINT iResult = 0;

    printf("Enter the number : \n");
    scanf("%d",&iNo);

    iMask = iMask1 | iMask2;

    iResult = iNo ^ iMask;

    printf("Updated number : %d\n", iResult);

    return 0;
}
