# include<stdio.h>

int countVowels(const char *str)
{
    int iCount = 0;

    while(*str != '\0')
    {
        if((*str == 'a') || (*str == 'e') || (*str == 'i') || (*str == 'o') || (*str == 'u'))
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

    iRet = countVowels(Arr);

    printf("Vowel is : %d\n",iRet);

    return 0;
}

