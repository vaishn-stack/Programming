# include<stdio.h>

#define TRUE 1
#define FALSE 0

typedef int BOOL;

BOOL chkVowels(char *str)
{
    while(*str != '\0')
    {
        if((*str == 'a') || (*str == 'e') || (*str == 'i') || (*str == 'o') || (*str == 'u') || 
        (*str == 'A') || (*str == 'E') || (*str == 'I') || (*str == 'O') || (*str == 'U'))
        {
            return TRUE;
        }  
        str++;
    }

    return FALSE;
}

int main()
{
    char arr[20];
    BOOL bRet = FALSE;

    printf("Enter String : \n");
    scanf("%[^'\n']s",arr);                          

    bRet = chkVowels(arr);

    if(bRet == TRUE)
    {
        printf("Contains vowels");
    }
    else
    {
        printf("There is no vowel");
    }

    return 0;
}

