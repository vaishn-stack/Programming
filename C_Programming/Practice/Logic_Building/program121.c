#include<stdio.h>
#include<stdlib.h>

void Display(int Arr[], int iSize)
{
    int iCnt = 0;

    printf("Elements of the array are : \n");

    for(iCnt = 0; iCnt < iSize; iCnt++)
    {
        printf("%d\n",Arr[iCnt]);
    }
}

int main()
{
    int *Brr = NULL;
    int iLength = 0, iCnt = 0;

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

    Display(Brr,iLength);

    // step 5 - deallocate the memory
    free(Brr);
    
    return 0;
}
 