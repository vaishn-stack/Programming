#include<stdio.h>

void Display(int Arr[])
{
    int iCnt = 0;
    //             issue
    for(iCnt = 0; iCnt < 5; iCnt++)
    {
        printf("%d\n",Arr[iCnt]);
    }  
}

int main()
{
    int Brr[8] = {10,20,30,40,50,60,70,80};

    Display(Brr);

    return 0;
}
 
// hardcoded means number lihne