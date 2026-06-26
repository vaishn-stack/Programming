#include<stdio.h>

void ReverseDisplay(char *str)
{
    char *start = NULL;

    start = str;

    while(*str != '\0')
    {
        str++;
    }

    str--;
    
    while(start <= str)
    {
        printf("%c",*str);
        str--;
    }
    printf("\n");
}

int main()
{
    char Arr[50] = {'\0'};

    printf("Enter String : \n");
    scanf("%[^'\n]s",Arr);

    ReverseDisplay(Arr);

    return 0;
}

// Learn bitwise operator --> &, |, ^ , ~, <<, >>
// Dec --> Binary, bin --> Dec, Bin --> Hex, HEx --> Bin
// Learn for DS --> Pointer, structure, Array, self referential, . operator, -> operator, #pragma pack, malloc/new, free/delete