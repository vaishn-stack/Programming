#include<stdio.h>

int main()
{
    int Arr[] = {10,20,30,40,50};     // sequence initialisation list

    printf("%d\n",Arr);
    printf("%d\n",&Arr);
    printf("%d\n",&Arr[0]);

    return 0;
}