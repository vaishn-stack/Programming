/*  Input : iRow = 6  iCol = 5
    Output : 
            *  * * * 
            *  * * 
            *  *
            *
*/

#include<stdio.h>

void Pattern(int iRow, int iCol)
{
    int i = 0;
    int j = 0;

    if(iRow != iCol) 
    {
        printf("Invalid Parameters !");
        printf("Number of rows and columns should be same");
        return;
    }

    for(i = iCol; i >= 1; i--)
    {
        for(j = 1; j <= i; j++)
        {
            printf("*\t");
        }
        printf("\n");
    }
}

int main()
{
    int iValue1 = 0, iValue2 = 0;

    printf("Enter number of rows and columns :\n");
    scanf("%d %d", &iValue1, &iValue2);

    Pattern(iValue1, iValue2);

    return 0;
}