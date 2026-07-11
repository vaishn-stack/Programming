#include<stdio.h>

typedef unsigned int UINT;

int main()
{
    UINT iNo = 0, iMask = 0x00010000, iAns = 0;        

    printf("Enter number : \n");
    scanf("%d",&iNo);

    iAns = iNo & iMask;

    if(iAns == iMask)
    {
        printf("17th bit is on");
    }
    else
    {
        printf("17th bit is off");
    }
    
    return 0;
}

// 0000 0000 0000 0001 0000 0000 0000 0000
//  0    0     0   1    0     0    0    0
// 2 raised to 16
