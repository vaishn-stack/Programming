# include<stdio.h>

int countCapital(const char *str)
{
    int iCount = 0;

    while(*str != '\0')
    {
        if((*str >= 'A') && (*str <= 'Z'))
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

    iRet = countCapital(Arr);

    printf("Frequency is : %d\n",iRet);

    return 0;
}

