#include<stdio.h>

int main()
{
    char str[80] = {'\0'};

    // char Command1[20] = {'\0'};
    // char Command2[20] = {'\0'};
    // char Command3[20] = {'\0'};

    char Command[4][20] = {{'\0'}};

    printf("Enter Command : \n");

    fgets(str, sizeof(str), stdin);

    printf("Entered Command is : %s\n", str);

    sscanf(str,"%s %s %s", Command[0], Command[1], Command[2]);

    printf("First Token : %s\n", Command[0]);
    printf("Second Token : %s\n", Command[1]);
    printf("Third Token : %s\n", Command[2]);
   // printf("Fourth Token : %s\n", Command4);

    return 0;
}

