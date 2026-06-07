// use iterations - for loop

#include<stdio.h>

void display(int iNo)
{
    int iCnt = 0;

    // Input Filter
    if(iNo < 0)
    {
        printf("Invalid Input...\n");
        return;
    }

    for(iCnt = 1; iCnt <= iNo; iCnt++)
    {
        printf("%d\n",iCnt);
    }
}

int main()
{
    int iValue = 0;

    printf("Enter the Frequency : ");
    scanf("%d",&iValue);
    
    display(iValue);

    return 0;
}