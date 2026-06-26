# include<stdio.h>

int main()
{
    char Arr[50] = {'\0'};

    printf("Enter String : \n");
    scanf("%s",Arr);                // Issue

    printf("Entered String is : %s\n",Arr);

    return 0;
}