#include<stdio.h>

int main()
{
    int i = 11, j = 21;
    int temp = 0;

    temp = i;
    i = j;
    j = temp;

    printf("%d\n",i);
    printf("%d\n",j);
    

    return 0;
}

// Learn bitwise operator --> &, |, ^ , ~, <<, >>
// Dec --> Binary, bin --> Dec, Bin --> Hex, HEx --> Bin
// Learn for DS --> Pointer, structure, Array, self referential, . operator, -> operator, #pragma pack, malloc/new, free/delete