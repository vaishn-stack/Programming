#include<stdio.h>

#pragma pack(1)

struct node             
{
    int data;
    struct node *next;
};

int main()
{
    struct node obj1, obj2 , obj3;                 // 3 node Linked list
    
    obj1.data = 11;
    obj1.next = &obj2;           
    
    obj2.data = 21;
    obj2.next = &obj3;

    obj3.data = 51;
    obj3.next = NULL;

    printf("%u\n",&obj1);                           // unsigned integer (%u) 6422296
    printf("%u\n",&obj2);                           // 6422288
    printf("%u\n",&obj3);                           // 6422280

    printf("%u\n",obj1.next);                       // 6422288
    printf("%u\n",obj2.next);                       // 6422280
    printf("%u\n",obj3.next);                       // 0

    printf("%d\n",obj1.data);                       // 11
    printf("%d\n",obj1.next -> data);               // 21
    printf("%d\n",obj1.next ->next -> data);        // 51

    return 0;
}

/*
                obj1            obj2              obj3
            data  node  --->  data  node --->  data  node
            11    200   --->   21   300  --->   51   NULL 
Address-  100                200              300

&obj1 = 100
&obj2 = 200
&obj3 = 300
obj1.next = 200
obj2.next = 300
obj3.next = NULL
obj1.next -> data = 21
obj1.next ->next -> data = 51


*/