#include<stdio.h>

void Display(int Arr[], int iSize)
{
    int iCnt = 0;

    for(iCnt = 0; iCnt < iSize; iCnt++)
    {
        printf("%d\n",Arr[iCnt]);
    }  
}

int main()
{
    int iLength = 4;

    int Brr[iLength] = {10,20,30,40};       // Error

    Display(Brr,iLength);

    return 0;
}
 