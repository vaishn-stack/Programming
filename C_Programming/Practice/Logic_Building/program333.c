// accept no from user and toogle 11th bit
/*
    input - 0   0   1   0   0   1   0   0   
    output -0   0   1   0   1   1   0   0
*/
#include<stdio.h>

typedef unsigned int UINT;

// position 11
int main()
{    
    UINT iMask = 0x1;
    UINT iNo = 0, iPos = 0;

    printf("Enter number : \n");
    scanf("%d",&iNo);

    printf("Enter the bit position : \n");
    scanf("%d",&iPos);

    iMask = iMask << (iPos - 1);
    
    iNo = iMask ^ iNo;

    printf("Updated number : %d\n",iNo);

    return 0;
}
