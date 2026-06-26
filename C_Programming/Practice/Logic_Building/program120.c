#include<stdio.h>
#include<stdlib.h>

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

    // step 5 - deallocate the memory
    free(Brr);
    
    return 0;
}
 