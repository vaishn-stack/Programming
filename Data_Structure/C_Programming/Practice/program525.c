// input : 4
// Output : 4+3+2+1 = 10

#include<stdio.h>

int summation(int iNo)
{
    static int iSum = 0;

    if(iNo != 0)
    {
        iSum = iSum + iNo;
        iNo--;

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
