#include<stdio.h>

void strRevX(char *str)
{
    char *start = NULL;
    char *end = NULL;
    char temp = '\0';

    start = str;
 

    while(*str != '\0')
    {
        str++;
    }

    str--;

    end = str;

    while(start <= end)
    {
        temp = *start;
        *start = *end;
        *end = temp;
        start++;
        end--;
    }
}

int main()
{
    char Arr[50] = {'\0'};

    printf("Enter String : \n");
    scanf("%[^'\n]s",Arr);

    strRevX(Arr);

    printf("Updated string is : %s\n",Arr);

    return 0;
}

// Learn bitwise operator --> &, |, ^ , ~, <<, >>
// Dec --> Binary, bin --> Dec, Bin --> Hex, HEx --> Bin
// Learn for DS --> Pointer, structure, Array, self referential, . operator, -> operator, #pragma pack, malloc/new, free/delete