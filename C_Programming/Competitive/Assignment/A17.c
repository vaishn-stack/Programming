// Accept number from user and display its factors in increasing order.

#include<stdio.h>

void FactRev(int iNo)
{
    int iCnt = 0;

    for(iCnt = 1; iCnt <= iNo / 2; iCnt++)
    {
        if(iNo % iCnt == 0)
        {
            printf("%d\n",iCnt);
        }
    }
}

int main()
{
    int iValue = 0;

    printf("Enter number : ");
    scanf("%d",&iValue);

    FavtRev(iValue);

    return 0;
}