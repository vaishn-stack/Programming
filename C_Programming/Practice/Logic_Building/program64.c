// Input : 5
// Output : -5 -4 -3 -2 -1 0 1 2 3 4 5 

#include<stdio.h>

void Display(int iNo)
{
    int iCnt = 0;

    // Linear
    for(iCnt = -iNo; iCnt <= iNo; iCnt++)  
    {
       printf("%d\t",iCnt);
    }

    printf("\n");
}

int main()
{
    int iValue = 0;

    printf("Enter the number : ");
    scanf("%d",&iValue);

    Display(iValue);

    return 0;
}

Time complexity : O(2N)