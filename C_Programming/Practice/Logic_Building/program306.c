#include<stdio.h>

int main()
{
    int iNo = 0, iCount = 0, iDigit;

    printf("Enter number : \n");
    scanf("%d",&iNo);

    while(iNo != 0)
    {
        iDigit = iNo % 2;
        if(iDigit == 1)
        {
            iCount++;
        }
        iNo = iNo / 2;
    }
    printf("Number of 1's are : %d", iCount);

    printf("\n");

    return 0;
}

