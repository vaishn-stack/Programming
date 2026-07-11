#include<stdio.h>

typedef unsigned int UINT;

// position 13
int main()
{    
    UINT iMask = 0xFFFFEFFF;
    UINT iNo = 0, iPos = 0;

    printf("Enter number : \n");
    scanf("%d",&iNo);
    
    iNo = iMask & iNo;

    printf("Updated number : %d\n",iNo);

    return 0;
}
