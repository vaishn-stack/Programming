#include<stdio.h>

#pragma pack(1)

struct node             
{
    int data;
    struct node *next;
};

int main()
{
    struct node obj1, obj2;                 // 2 node Linked list
    
    obj1.data = 11;
    obj1.next = &obj2;           
    
    obj2.data = 21;
    obj2.next = NULL;

    printf("%u\n",&obj1);                   // unsigned integer (%u) 6422296
    printf("%u\n",&obj2);                   // 6422288

    printf("%u\n",obj1.next);               // 6422288
    printf("%u\n",obj2.next);               // 0

    printf("%d\n",obj1.next -> data);       // 21

    return 0;
}

/*
                obj1            obj2
            data  node  --->  data  node
            11    200   --->   21   NULL ----
Address-  100                200

&obj1 = 100
&obj2 = 200
obj1.next = 200
obj2.next = NULL
obj1.next -> data = 21

*/