#include<stdio.h>

typedef unsigned int UINT;

void CommonBits(UINT iNo1, UINT iNo2)
{
    UINT iMask = 1;
    int iPos = 1;

    while(iMask != 0)
    {
        if((iNo1 & iMask) && (iNo2 & iMask))
        {
            printf("%d ",iPos);
        }

        iMask = iMask << 1;
        iPos++;
    }
}

int main()
{
    UINT iNo1,iNo2;

    printf("Enter two numbers : ");
    scanf("%u%u",&iNo1,&iNo2);

    CommonBits(iNo1,iNo2);

    return 0;
}