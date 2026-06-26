// problems on string imp for interview

# include<stdio.h>
# include<string.h>

int main()
{
    char str[] = "Jay Ganesh";                      // 11 bytes memory '\0' also calculated
    int iRet = 0;

    iRet = strlen(str);             
    printf("Length of string is : %d\n",iRet);

    iRet = sizeof(str);                             // sizeof is a operator
    printf("Size of string is : %d\n",iRet);

    return 0;
}