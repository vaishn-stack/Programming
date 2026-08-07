#include<stdio.h>

int main()
{
    char str[80] = {'\0'};
    char Command1[20] = {'\0'};
    char Command2[20] = {'\0'};
    char Command3[20] = {'\0'};

    printf("Enter Command : \n");

    fgets(str, sizeof(str), stdin);

    printf("Entered Command is : %s\n", str);

    sscanf(str,"%s %s %s", Command1, Command2, Command3);

    printf("First Token : %s\n", Command1);
    printf("Second Token : %s\n", Command2);
    printf("Third Token : %s\n", Command3);

    return 0;
}

