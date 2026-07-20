// input : 4
// Output : 1 + 2 + 3 + 4 = 10

// input : 7
// Output : 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28
#include<stdio.h>

int summation(int iNo)
{
    int iSum =0;
    int i = 0;

    for(i = 1; i <= iNo; i++)
    {
        iSum = iSum + i;
    }
    return iSum;
}

int main()
{
    int iValue = 0, iRet = 0;

    printf("Enter frequency :\n");
    scanf("%d",&iValue);

    iRet = summation(iValue);

    printf("Summation is : %d\n",iRet);
    
    return 0;
}
