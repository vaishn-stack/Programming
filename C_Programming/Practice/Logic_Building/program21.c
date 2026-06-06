//Scenario - Based question - Amusement park Ticket Price as per Age Calculation

#include<stdio.h>

int CalculateTicketPrice(int iAge)
{
    // Input Filter

    if(iAge < 0)
    {
        return -1;
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

int main()
{
    int iValue = 0;
    int iRet = 0;

    printf("Please Enter your Age to calculate ticket price : ");
    scanf("%d",&iValue);

    iRet = CalculateTicketPrice(iValue);

    printf("Your Ticket Price will be %d Rs.\n",iRet);

    return 0; 
}