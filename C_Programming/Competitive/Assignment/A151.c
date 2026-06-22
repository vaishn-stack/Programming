#include<stdio.h>

int CountCapital(char *str)
{
    int iCnt = 0;

    // Filter
    if(str == NULL)
    {
        return -1;
    }

    while(*str != '\0')
    {
        if(*str >= 'A' && *str <= 'Z')
        {
            iCnt++;
        }
        str++;
    }
    return iCnt;
}

int main()
{
    char arr[20];
    int iRet = 0;
    
    printf("Enter String : \n");
    scanf("%[^'\n']s",arr);

    iRet = CountCapital(arr);

    printf("%d",iRet);

    return 0;
}