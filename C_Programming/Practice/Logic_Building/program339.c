#include<stdio.h>

typedef unsigned int UINT;

// position 23
int main()
{    
    UINT iMask = 0xFFBFFFFF;
    UINT iNo = 0, iPos = 0;

    printf("Enter number : \n");
    scanf("%d",&iNo);
    
    iNo = iMask & iNo;

    printf("Updated number : %d\n",iNo);

    return 0;
}
