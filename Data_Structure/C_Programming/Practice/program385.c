// Doubly Linear Linked list

#include<stdio.h>
#include<stdlib.h>

# pragma pack(1)

struct node
{
    int data;
    struct node *next;
    struct node *prev;           // $ new line
};

typedef struct node NODE;
typedef struct node *PNODE;
typedef struct node *PPNODE;


int main()
{
    printf("%d\n",sizeof(NODE));            // 20 bytes

    return 0;
}