#include<stdio.h>
#include<stdlib.h>

int SumEven(int Arr[], int iSize)
{
    int iCnt = 0, iSum = 0;

    for(iCnt = 0; iCnt < iSize; iCnt++)
    {
        if(Arr[iCnt] % 2 == 0)
        {
            iSum = iSum + Arr[iCnt];
        }
    }

    return iSum;

}

int main()
{
    int *Brr = NULL;
    int iLength = 0, iCnt = 0;
    int iRet = 0;

    printf("Enter the number of elements : \n");
    scanf("%d",&iLength);

    Brr = (int *) malloc (sizeof(int) * iLength);

    printf("Enter the elements : \n");

    for(iCnt = 0; iCnt < iLength; iCnt++)
    {
        scanf("%d",&Brr[iCnt]);
    }

    iRet = SumEven(Brr,iLength);

    printf("Even elements Summation : %d\n",iRet);

    free(Brr);
    
    return 0;
}
 