// Addition of 2 numbers

#include<stdio.h>

int main()
{
    float fValue1 = 0.0f;                       // To store first input  - intent comment
    float fValue2 = 0.0f;                       // To store second input
    float fResult = 0.0f;                       // To store the result

    printf("Enter First Number : \n");
    scanf("%f",&fValue1);

    printf("Enter Second Number : \n");
    scanf("%f",&fValue2);

    fResult = fValue1 + fValue2;                // Perform the addition

    printf("Addition is : %f\n",fResult);

    return 0;
}