// input : 4
// Output : 4*3*2*1 = 24

#include<stdio.h>

typedef unsigned long int ULONG;

ULONG Factorial(int iNo)
{
    ULONG iMult = 1;

    while(iNo > 0)
    {
        iMult = iMult * iNo;
        iNo--;
    }
    return iMult;
}

int main()
{
    int iValue = 0; 
    ULONG iRet = 0;

    printf("Enter frequency :\n");
    scanf("%lu",&iValue);

    iRet = Factorial(iValue);

    printf("Factorial is : %lu\n",iRet);
    
    return 0;
}
