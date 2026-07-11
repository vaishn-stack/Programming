#include<stdio.h>

typedef unsigned int UINT;
int main()
{
    UINT iMask = 0x00000000;

    // Smallest value of int
    printf("%d\t%X\n",iMask,iMask);

    
    return 0;
}
