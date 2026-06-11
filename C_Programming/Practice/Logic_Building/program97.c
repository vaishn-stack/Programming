#include<stdio.h>

int Arr[7];

int main()
{
    Arr[0] = 10;
    Arr[3] = 20;
    Arr[6] = 30;

    printf("%d\n",sizeof(Arr));

    printf("%d\n",Arr[0]);
    printf("%d\n",Arr[3]);
    printf("%d\n",Arr[6]);

    printf("%d\n",Arr[2]);
    printf("%d\n",Arr[5]);

    return 0;
}