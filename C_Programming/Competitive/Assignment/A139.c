/*  Input : iRow = 5  iCol = 5
    Output : 
         * * * * * *
         * # # # * * 
         * # # * $ *
         * # * $ $ *
         * * $ $ $ *
         * * *  * * * 
*/

#include<stdio.h>

void Pattern(int iRow, int iCol)
{
    int i = 0, j = 0;

    if(iRow != iCol)
    {
        printf("Invalid Parameters!\n");
        return;
    }

    for(i = 1; i <= iRow; i++)
    {
        for(j = 1; j <= iCol; j++)
        {
            if((i == 1) || (i == iRow) ||
               (j == 1) || (j == iCol) ||
               (i + j == iCol + 1))
            {
                printf("*\t");
            }
            else if(j <= i)
            {
                printf("#\t");
            }
            else
            {
                printf("$\t");
            }
        }
        printf("\n");
    }
}

int main()
{
    int iRow = 0, iCol = 0;

    printf("Enter rows and columns : ");
    scanf("%d%d",&iRow,&iCol);

    Pattern(iRow,iCol);

    return 0;
}