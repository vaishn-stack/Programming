// input : 5678
// Output : 8 7 6 5

#include<stdio.h>

void Display(int iNo)
{
    int iDigit = 0;

    if(iNo > 0)
    {
        iDigit = iNo % 10;
        iNo = iNo / 10;

        Display(iNo);            // tail recursion
        printf("%d\n",iDigit);
    }
}

int main()
{
    int iValue = 0;

    printf("Enter Number :\n");
    scanf("%d",&iValue);

    Display(iValue);
    
    return 0;
}

/*
    recursion has 2 types - head recursion and tail recursion

*/
