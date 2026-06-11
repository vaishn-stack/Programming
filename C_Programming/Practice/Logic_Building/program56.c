// Input : 5
// Output : 1 2 3 4

#include<stdio.h>

void Display(int iNo)
{
    int iCnt = 0;

    // Linear
    for(iCnt = 1; iCnt < iNo; iCnt += 1)  // += ->  ternary operator
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