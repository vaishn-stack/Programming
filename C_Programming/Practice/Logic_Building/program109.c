#include<stdio.h>

void Display(int Arr[])
{
    printf("%d\n",Arr[0]);     // subscript operator []
    printf("%d\n",Arr[1]);     // Descrit operator *
    printf("%d\n",Arr[2]);
    printf("%d\n",Arr[3]);
    printf("%d\n",Arr[4]);
}

int main()
{
    int Brr[5] = {10,20,30,40,50};

    Display(Brr);

    return 0;
}
 