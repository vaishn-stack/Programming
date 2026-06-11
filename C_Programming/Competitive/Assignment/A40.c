// Accept area in square feet and convert it into square meter. (1 Square feet = 0.0929 Square meter)

#include<stdio.h>

double SquareMeter(int iNo)
{
    double dMeter = 0.0;

    dMeter = iNo * 0.0929;

    return dMeter;
}

int main()
{
    int iValue = 0;
    double dRet = 0.0;

    printf("Enter area in square feet : ");
    scanf("%d",&iValue);

    dRet = SquareMeter(iValue);

    printf("Area in square meter is %lf", dRet);

    return 0;
}