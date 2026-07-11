#include<stdio.h>

typedef unsigned int UINT;
// position 3 and 8

int main()
{    
    UINT iMask = 0x00000084;
    UINT iNo = 0;
    UINT iResult = 0;

    printf("Enter the number : \n");
    scanf("%d",&iNo);

    iResult = iNo ^ iMask;

    printf("Updated number : %d\n", iResult);

    return 0;
}
