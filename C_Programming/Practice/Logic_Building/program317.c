#include<stdio.h>

typedef unsigned int UINT;

int main()
{
    UINT iNo = 0, 
    iMask = 0x1, 
    iAns = 0,
    iPos = 0;        

    printf("Enter number : \n");
    scanf("%d",&iNo);

    printf("Enter Position : \n");
    scanf("%d",&iPos);

    iMask = iMask << (iPos - 1);

    iAns = iNo & iMask;

    if(iAns == iMask)
    {
        printf("Bit is on");
    }
    else
    {
        printf("Bit is off");
    }
    
    return 0;
}

// check the specific number chi konti bit is on or off