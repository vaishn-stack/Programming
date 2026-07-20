#include<stdio.h>

#pragma pack(1)

struct node             
{
    int data;
    struct node *next;
};

int main()
{
    struct node obj1, obj2;             // 2 node Linked list
    
    obj1.data = 11;
    obj1.next = &obj2;           
    
    obj2.data = 21;
    obj2.next = NULL;

    printf("%d\n",obj1.data);    
    printf("%d\n",obj2.data); 

    return 0;
}