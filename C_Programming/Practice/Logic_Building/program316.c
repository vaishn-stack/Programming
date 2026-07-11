#include<stdio.h>

typedef unsigned int UINT;

int main()
{
    UINT iNo = 0, iMask = 0x40, iAns = 0;        

    printf("Enter number : \n");
    scanf("%d",&iNo);

    iAns = iNo & iMask;

    if(iAns == iMask)
    {
        printf("7th bit is on");
    }
    else
    {
        printf("7th bit is off");
    }
    
    return 0;
}