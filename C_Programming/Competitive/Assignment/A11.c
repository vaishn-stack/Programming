// Accept one number from user and print that number of even numbers on screen 

#include<stdio.h>

void PrintEven(int iNo)
{
    int iCnt = 1;
    if(iNo <= 0)
    {
        return;
    }

    // logic
    while(iCnt <= iNo)
    {
        printf("%d\n",iCnt * 2);
        iCnt++;
    }
}

int main()
{
    int iValue = 0;

    printf("Enter number : ");
    scanf("%d",&iValue);

    PrintEven(iValue);

    return 0;
}