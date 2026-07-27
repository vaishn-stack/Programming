#include<stdio.h>

void Display(int iCnt)
{
    if(iCnt <= 5)
    {
        printf(" * \t");
        Display(iCnt + 1);
    }

    printf("\n");
}

int main()
{
    Display(1);

    return 0;
}