#include<stdio.h>

int summation(int iNo)
{
    static int iSum = 0;
    static int i = 1;

    // Recursion

    if(i <= iNo)
    {
        iSum = iSum + i;
        i++;
        
        summation(iNo);
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
