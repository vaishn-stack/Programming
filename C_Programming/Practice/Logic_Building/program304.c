#include<stdio.h>

int main()
{
   int No1 = 0, No2 = 0, Ans = 0;

   printf("Enter First number : \n");
   scanf("%d",&No1);

   printf("Enter second number : \n");
   scanf("%d",&No2);

   Ans = No1 & No2;

   printf("Result is : %d\n",Ans);

   printf("\n");

    return 0;
}

