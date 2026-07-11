#include<stdio.h>

typedef unsigned int UINT;

int main()
{
    UINT iNo = 0, iMask = 4096, iAns = 0;        

    printf("Enter number : \n");
    scanf("%d",&iNo);

    iAns = iNo & iMask;

    if(iAns == iMask)
    {
        printf("13th bit is on");
    }
    else
    {
        printf("13th bit is off");
    }
    
    return 0;
}

