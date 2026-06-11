#include<stdio.h>

double CircleArea(float fRadius)
{
    float fPi = 3.14f;

    return fPi * fRadius * fRadius;
}

int main()
{
    float fValue = 0.0f;
    double dRet = 0.0f;

    printf("Enter Radius : ");
    scanf("%f",&fValue);

    dRet = CicleArea(fValue);

    printf("%lf\n",dRet);

    return 0;
}