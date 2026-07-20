#include<stdio.h>



int main()
{
    char Arr[20] = {'\0'};

    printf("Enter String : \n");
    scanf("%[^'\n]s", Arr);

    printf("%s\n",Arr);
    
    return 0;
}

/*
    recursion has 2 types - head recursion and tail recursion
    problems on string
*/
