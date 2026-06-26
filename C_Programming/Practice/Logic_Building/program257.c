# include<stdio.h>

int countSpace(const char *str)
{
    int iCount = 0;

    while(*str != '\0')
    {
        if(*str == ' ')
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

    iRet = countSpace(Arr);

    printf("Frequency is : %d\n",iRet);

    return 0;
}

