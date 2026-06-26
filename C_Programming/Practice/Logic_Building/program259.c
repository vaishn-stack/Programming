# include<stdio.h>

void Update(char *str)
{
    int iCount = 0;

    while(*str != '\0')
    {
        if(*str == 'l')
        {
            *str = 'L';
        }  
        str++;
    }
}

int main()
{
    char Arr[50] = {'\0'};

    printf("Enter String : \n");
    scanf("%[^'\n']s",Arr);                          

    Update(Arr);

    printf("Updated string is : %s\n",Arr);

    return 0;
}

