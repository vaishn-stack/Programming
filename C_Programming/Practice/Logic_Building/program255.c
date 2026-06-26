# include<stdio.h>

int countSmall(const char *str)
{
    int iCount = 0;

    while(*str != '\0')
    {
        if((*str >= 97) && (*str <= 122))
        {
            iCount++;
        }  
        str++;
    }

    return iCount;
}

int main()
{
    char Arr[50] = {'\0'};
    int iRet = 0;

    printf("Enter String : \n");
    scanf("%[^'\n']s",Arr);                          

    iRet = countSmall(Arr);

    printf("Frequency is : %d\n",iRet);

    return 0;
}

