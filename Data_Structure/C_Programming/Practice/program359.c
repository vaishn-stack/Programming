// 357.c == 359.c

#include<stdio.h>

#pragma pack(1)

struct node             
{
    int data;
    struct node *next;
};

typedef struct node NODE;
typedef struct node * PNODE;    // the * gets initalised with symbollically 

int main()
{
    PNODE head = NULL;              // ethe star(*) nhi dist ae pn internally ae
    NODE obj1, obj2 , obj3;                 
    
    head = &obj1;

    obj1.data = 11;
    obj1.next = &obj2;           
    
    obj2.data = 21;
    obj2.next = &obj3;

    obj3.data = 51;
    obj3.next = NULL;

    printf("%d\n",head -> data);
    printf("%d\n",head -> next -> data);
    printf("%d\n",head -> next -> next -> data);

    return 0;
}

/*
                  obj1            obj2              obj3
head           data  node  --->  data  node --->  data  node
100            11    200   --->   21   300  --->   51   NULL 
60 68       100                200              300

&obj1 = 100
&obj2 = 200
&obj3 = 300
obj1.next = 200
obj2.next = 300
obj3.next = NULL
obj1.next -> data = 21
obj1.next ->next -> data = 51


*/