#include<stdio.h>

void Display(int Arr[], int iSize)
{
    int i =0;

    while(i< iSize)
    {
        printf("%d\n",Arr[i]);
        i++;
    }
}

int main()
{
    int Brr[] = {10,20,30,40,50};

    Display(Brr,5);

    
    return 0;
}

/*
    recursion has 2 types - head recursion and tail recursion
    problems on n numbers - Array
*/
