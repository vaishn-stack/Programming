#include<stdio.h>

int Display(int Arr[], int iSize)
{
    int i = 0;
    int isum = 0;

    while(i < iSize)
    {
        isum = isum + Arr[i];
        i++;
    }
    return isum;
}

int main()
{
    int Brr[] = {10,20,30,40,50};

    int iRet = 0;

    iRet = Display(Brr,5);

    printf("Addition is : %d\n",iRet);
    return 0;
}

/*
    recursion has 2 types - head recursion and tail recursion
    problems on n numbers - Array
*/
