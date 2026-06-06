// accept the no user check whether even or odd --> check whether asel teva answer return value will be boolean - true or false
// short hand coding strategy

//////////////////////////////////////////////////////////////////////
//
//  Include required header files
//
//////////////////////////////////////////////////////////////////////

#include<stdio.h>
#include<stdbool.h>          // Boolean value print krnyasathi

//////////////////////////////////////////////////////////////////////
//  
//  Function Name : CheckEvenOdd
//  Input :         int
//  Output:         int
//  Description :   accept the no user check whether even or odd 
//  Date :          10/05/2026
//  Author :        Vaishnavi Deepak Morankar
//
//////////////////////////////////////////////////////////////////////

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

//////////////////////////////////////////////////////////////////////
//  
//  Application to accept the no user check whether even or odd 
//
//////////////////////////////////////////////////////////////////////

int main()
{
    int iValue = 0;
    bool bRet = false;                                              // false = 0 , true = 1

    printf("Enter number to check whether it is Even or Odd : ");
    scanf("%d",&iValue);

    bRet = CheckEvenOdd(iValue);

    if(bRet)
    {
        printf("%d is Even.\n",iValue);
    }
    else
    {
        printf("%d is Odd.\n",iValue);
    }

    return 0;
}

//////////////////////////////////////////////////////////////////////
//
//  Input  : 13
//  Output : 13 is odd.
//
//////////////////////////////////////////////////////////////////////