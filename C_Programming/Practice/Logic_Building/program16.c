// accept the no user check whether even or odd --> check whether asel teva answer return value will be boolean - true or false
// short hand coding strategy

#include<stdio.h>
#include<stdbool.h>                                                // Boolean value print krnyasathi

bool CheckEvenOdd(int iNo)                          
{
    if((iNo % 2) == 0)
    {
        return true;                                                // true and false are keywords
    }
    else
    {
        return false;
    }
}

int main()
{
    int iValue = 0;
    bool bRet = false;                                              // false = 0 , true = 1

    printf("Enter number to check whether it is Even or Odd : ");
    scanf("%d",&iValue);

    bRet = CheckEvenOdd(iValue);

    if(bRet == true)
    {
        printf("%d is Even.\n",iValue);
    }
    else
    {
        printf("%d is Odd.\n",iValue);
    }

    return 0;
}