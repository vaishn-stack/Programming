# include<stdio.h>
# include<string.h>

int main()
{
    char *str = "Ganesh";    
    int iCount = 0;                 
   
    printf("Length of String is : %lu\n",strlen(str));

    while(*str != '\0')
    {
        iCount++;
        str++;
    }

    printf("Length of String is : %d\n",iCount);

    return 0;
}