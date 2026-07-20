#include<stdio.h>

#pragma pack(1)

struct node             
{
    int data;
    struct node *next;
};

typedef struct node NODE;
typedef struct node * PNODE;    

int count(PNODE first)
{
    int iCount = 0; 

    while(first != NULL)
    {
        iCount++;
        first = first -> next;
    }

    return iCount;
}

void display(PNODE first)
{
    while(first != NULL)
    {
        printf("%d\n",first -> data);
        first = first -> next;
    }

}

int main()
{
    PNODE head = NULL;           

    int iRet = 0;

    NODE obj1, obj2 , obj3;                 
    
    head = &obj1;

    obj1.data = 11;
    obj1.next = &obj2;           
    
    obj2.data = 21;
    obj2.next = &obj3;

    obj3.data = 51;
    obj3.next = NULL;

    display(head);

    iRet = count(head);              // count(100);

    printf("Number of Nodes are : %d\n",iRet);

    return 0;
}

/*
                       obj1            obj2              obj3
head/temp --->    data  node  --->  data  node --->  data  node
100                11    200  --->   21   300  --->   51   NULL 
60 68           100                200              300

&obj1 = 100
&obj2 = 200
&obj3 = 300
obj1.next = 200
obj2.next = 300
obj3.next = NULL
obj1.next -> data = 21
obj1.next ->next -> data = 51

Time complexity - o(N)

*/