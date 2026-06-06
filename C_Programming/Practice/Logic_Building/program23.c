//Scenario - Based question - Amusement park Ticket Price as per Age Calculation
//////////////////////////////////////////////////////////////////////
//
//  Include required header files
//
//////////////////////////////////////////////////////////////////////

#include<stdio.h>

// User Defined Macro
#define AGE_INVALID -1

//////////////////////////////////////////////////////////////////////
//  
//  Function Name : CalculateTicketPrice
//  Input :         int
//  Output:         int
//  Description :   Amusement park Ticket Price as per Age Calculation
//  Date :          10/05/2026
//  Author :        Vaishnavi Deepak Morankar
//
//////////////////////////////////////////////////////////////////////

int CalculateTicketPrice(int iAge)
{
    // Input Filter

    if(iAge < 0)
    {
        return AGE_INVALID;
    }

    if(iAge >= 0 && iAge <= 5)
    {
        return 0;
    }
    else if(iAge >= 6 && iAge <= 18)
    {
        return 500;
    }
    else if(iAge >= 19 && iAge <= 50)
    {
        return 900;
    }
    else
    {
        return 400;
    }
}

//////////////////////////////////////////////////////////////////////
//  
//  Application to calculate ticket price as per Age
//
//////////////////////////////////////////////////////////////////////


int main()
{
    int iValue = 0;
    int iRet = 0;

    printf("Please Enter your Age to calculate ticket price : ");
    scanf("%d",&iValue);

    iRet = CalculateTicketPrice(iValue);

    if(iRet == AGE_INVALID)
    {
        printf("Please enter Positive Age\n");
    }
    else
    {
        printf("Your Ticket Price will be %d Rs.\n",iRet);
    }

    return 0; 
}

//////////////////////////////////////////////////////////////////////
//
//  Input  : Age : 34
//  Output : price :  900
//
//////////////////////////////////////////////////////////////////////