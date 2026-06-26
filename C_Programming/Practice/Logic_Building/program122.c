#include<stdio.h>
#include<stdlib.h>

int Summation(int Arr[], int iSize)
{
    int iCnt = 0;
    int iSum = 0;

    for(iCnt = 0; iCnt < iSize; iCnt++)
    {
       iSum = iSum + Arr[iCnt];
    }

    return iSum;
}

int main()
{
    int *Brr = NULL;
    int iLength = 0, iCnt = 0;
    int iRet = 0;

    // step 1 - Accept the number of elements
    printf("Enter number of elements : \n");
    scanf("%d",&iLength);

    // step2 - Allocate the memory
    Brr = (int *) malloc (iLength * sizeof(int));

    // step 3 - Accept the values from user
    printf("Enter the Elements : \n");
    
    for(iCnt = 0; iCnt < iLength; iCnt++)
    {
        scanf("%d",&Brr[iCnt]);
    }

    // step 4 - use the memory(logic) , call the function

    iRet = Summation(Brr,iLength);

    printf("Addition of All Elements : %d\n",iRet);

    // step 5 - deallocate the memory
    free(Brr);
    
    return 0;
}
 