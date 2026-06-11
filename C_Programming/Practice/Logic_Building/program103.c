#include<stdio.h>

void CallByAddress(int *iPtr)
{
    (*iPtr)++;      // Calling
}

int main()
{
    int iValue = 11;

    CallByAddress(&iValue);   // Caller

    printf("Value after function call : %d\n",iValue);

    return 0;
}
 