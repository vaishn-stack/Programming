#include<stdio.h>

int Display(int Arr[], int iSize)
{
    static int i = 0;
    static int isum = 0;

    if(i < iSize)
    {
        isum = isum + Arr[i];
        i++;
        Display(Arr,iSize);
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
