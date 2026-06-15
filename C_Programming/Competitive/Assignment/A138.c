/*  Input : iRow = 5  iCol = 5
    Output : 
        %  %  %  %  %  %
        %           *  %
        %        *     %
        %      *       %
        %    *         %
        %  %  %  %  %  %
*/

#include<stdio.h>

void Pattern(int iRow, int iCol)
{
    int i = 0;
    int j = 0;

    if(iRow != iCol)
    {
        printf("Invalid Parameters!\n");
        printf("Number of rows and columns should be same\n");
        return;
    }

    for(i = 1; i <= iRow; i++)
    {
        for(j = 1; j <= iCol; j++)
        {
            if((i == 1) || (i == iRow) ||(j == 1) || (j == iCol) ||(i + j) == (iCol + 1))
            {
                printf("*\t");
            }
            else
            {
                printf("\t");
            }
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