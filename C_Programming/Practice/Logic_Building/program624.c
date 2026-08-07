#include<stdio.h>

int main()
{
    char str[80] = {'\0'};

    printf("Enter Command : \n");
    // scanf("%[^'\n]s", str);

    fgets(str, sizeof(str), stdin);

    printf("Entered Command is : %s\n", str);

    return 0;
}

