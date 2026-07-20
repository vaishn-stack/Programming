#include<stdio.h>

int CountCapital(char *str)
{
    static int iCount = 0;

    if(*str != '\0')
    {
        if(*str >= 'A' && *str <= 'Z')
        {
            iCount++;
        }
        
        str++;

        CountCapital(str);
    }

    return iCount;
}

int main()
{
    char Arr[20] = {'\0'};
    int iRet = 0;

    printf("Enter String : \n");
    scanf("%[^'\n]s", Arr);

    iRet = CountCapital(Arr);

    printf("Count Capital letters : %d\n",iRet);
    
    return 0;
}

/*
    recursion has 2 types - head recursion and tail recursion
    problems on string
*/
