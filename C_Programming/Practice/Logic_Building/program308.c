#include<stdio.h>

int main()
{
    int iNo = 0, iMask = 4, iAns = 0;

    printf("Enter number : \n");
    scanf("%d",&iNo);

    iAns = iNo & iMask;

    if(iAns == iMask)
    {
        printf("3rd bit is on");
    }
    else
    {
        printf("3rd bit is off");
    }
    
    return 0;
}

