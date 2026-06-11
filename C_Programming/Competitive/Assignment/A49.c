#include<stdio.h>

double FhtoCs(float fTemp)
{
    return (fTemp - 32) * 5 / 9;
}

int main()
{
    float fValue = 0.0;
    double dRet = 0.0;

    printf("Enter temeperature in Fahrenheit : ");
    scanf("%f",&fValue);

    dRet = FhtoCs(fValue);

    printf("%lf\n",dRet);

    return 0;
}