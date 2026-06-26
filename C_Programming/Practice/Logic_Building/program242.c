# include<stdio.h>

void Display(char *str)
{
    printf("Input String is : %s\n",str);
}

int main()
{
    char Arr[50] = {'\0'};

    printf("Enter String : \n");
    scanf("%[^'\n']s",Arr);                          

    printf("Entered String is : %s\n",Arr);

    Display(Arr);

    return 0;
}

