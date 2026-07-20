#include<stdio.h>

#pragma pack(1)

struct node             
{
    int data;
    struct node *next;
};

int main()
{
    struct node obj;                

    printf("%lu\n",sizeof(obj));             // 12 (pragma pack mule padding kami zal)
    // 4(int) + 8(pointer)

    return 0;
}