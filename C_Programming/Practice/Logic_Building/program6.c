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
    // variable creation with default values
    float i = 0.0f, j = 0.0f, k = 0.0f;                       // Local variables

    printf("Enter First Number : \n");
    scanf("%f",&i);

    printf("Enter Second Number : \n");
    scanf("%f",&j);

    k = i + j;                         // Business Logic

    printf("Addition is : %f\n",k);

    return 0;
}