#include<stdio.h>

int main()
{
    int iRet = 0;
    int i = 0, j = 0, k = 0;

    printf("Enter 3 Numbers : \n");
    iRet = scanf("%d %d %d", &i, &j, &k);

    printf("Value of iRet is : %d\n",iRet);
    
    return 0;
}

