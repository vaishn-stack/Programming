#include<stdio.h>

void Display(int *iPtr)
{
    printf("%d",*iPtr);
}

int main()
{
    int Arr[5] = {10,20,30,40,50};

    Display(Arr);

    return 0;
}
 