#include<stdio.h>

int LastChar(char *str, char ch)
{
    int i = 0, pos = -1;

    while(str[i] != '\0')
    {
        if(str[i] == ch)
        {
            pos = i;
        }
        i++;
    }

    return pos;
}

int main()
{
    char arr[50], cValue;

    printf("Enter string : ");
    scanf("%[^\n]", arr);

    printf("Enter character : ");
    scanf(" %c", &cValue);

    printf("Index : %d", LastChar(arr, cValue));

    return 0;
}