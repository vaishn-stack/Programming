#include<stdio.h>

int Difference(char *str)
{
    int iCap = 0;
    int iSmall = 0;

    // Filter
    if(str == NULL)
    {
        return 0;
    }

    while(*str != '\0')
    {
        if(*str >= 'A' && *str <= 'Z')
        {
            iCap++;
        }
        else if(*str >= 'a' && *str <= 'z')
        {
            iSmall++;
        }
        str++;
    }

    return (iCap - iSmall);
}

int main()
{
    char arr[20];
    int iRet = 0;

    printf("Enter String : ");
    scanf("%[^'\n']s",arr);

    iRet = Difference(arr);

    printf("%d",iRet);

    return 0;
}