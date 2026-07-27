#include<stdio.h>

int CountWhite(char *str)
{
    if(*str == '\0')
    {
        return 0;
    }

    if(*str == ' ')
    {
        return 1 + CountWhite(str + 1);
    }
    else
    {
        return CountWhite(str + 1);
    }
}

int main()
{
    char arr[50];
    int iRet = 0;

    printf("Enter String : ");
    scanf("%[^\n]", arr);

    iRet = CountWhite(arr);

    printf("White spaces are : %d\n", iRet);

    return 0;
}