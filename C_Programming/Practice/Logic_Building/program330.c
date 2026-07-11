// accept no from user and toogle 4th bit
/*
    input - 0   0   1   0   0   1   0   0   
    output -0   0   1   0   1   1   0   0
*/
#include<stdio.h>

typedef unsigned int UINT;

// position 4
int main()
{    
    UINT iMask = 0;
    UINT iNo = 0;

    printf("Enter number : \n");
    scanf("%d",&iNo);

    iMask = 0x00000008;

    iNo = iMask ^ iNo;

    printf("Updated number : %d\n",iNo);

    return 0;
}
