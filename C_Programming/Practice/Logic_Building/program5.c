// Addition of 2 numbers

/* 
    Algorithm -->

    START
        Accept first number as No1
        Accpet second number as No2 
        Perform Addition of No1 and No2
        Display the Result
    STOP
*/

#include<stdio.h>

int main()
{
    float i,j,k;                       // Local variables

    printf("Enter First Number : \n");
    scanf("%f",&i);

    printf("Enter Second Number : \n");
    scanf("%f",&j);

    k = i + j;                         // Business Logic

    printf("Addition is : %f\n",k);

    return 0;
}