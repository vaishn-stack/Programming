# include<stdio.h>

int main()
{
    char Arr[50] = {'\0'};

    printf("Enter String : \n");
    scanf("%[^'\n']s",Arr);                          // ^ negate symbol - opposite work - regex used Pattern matching / validation

    printf("Entered String is : %s\n",Arr);

    return 0;
}

// [^'\n'] yacha use enter krt nhi to prynat program stop hot nhi