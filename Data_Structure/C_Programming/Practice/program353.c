#include<stdio.h>

#pragma pack(1)

struct node             
{
    int data;
    struct node *next;
};

int main()
{
    struct node obj;                        // 1 node Linked list
    
    obj.data = 11;
    obj.next = NULL;                        // direct memory initialisation using . operator

    printf("%d\n",obj.data);           

    return 0;
}