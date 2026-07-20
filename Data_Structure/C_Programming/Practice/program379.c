#include<stdio.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node *next;
};

typedef struct node NODE;
typedef struct node * PNODE;
typedef struct node ** PPNODE;

void Display(PNODE first)
{
    while(first)                     
    {
        printf("| %d | -> ",first -> data);
        first = first -> next;
    }

    printf("NULL\n");
}

int Count(PNODE first)
{
    int iCount = 0;

    while(first)
    {
        iCount++;
        first = first -> next;
    }
    return iCount;
}

void InsertFirst(PPNODE first, int iNo)         
{
    PNODE newn = NULL;

    newn = (PNODE) malloc (sizeof(NODE));       
    newn -> data = iNo;                         

    newn -> next = NULL;                        

    if(NULL == *first)                         // Linked List is empty
    {
        *first = newn;
    }
    else                                       // LL contains at least 1 node
    {
        newn -> next = *first;                 

        *first = newn;
    }

}

void InsertLast(PPNODE first, int iNo)
{
    PNODE newn = NULL;

    newn = (PNODE) malloc (sizeof(NODE));       

    newn -> data = iNo;                         

    // Linked List is empty
    if(*first == NULL)                        
    {
        *first = newn;
    }
    else                                       // LL contains at least 1 node
    {
        
    }
}

void InsertAtPos(PPNODE first, int no, int iPos)
{

}

void DeleteFirst(PPNODE first)
{

}

void DeleteLast(PPNODE first)
{

}

void DeleteAtPos(PPNODE first,int iPos)
{

}

int main()
{
    PNODE head = NULL;
    int iRet = 0;

    InsertFirst(&head,101);
    InsertFirst(&head,51);
    InsertFirst(&head,21);
    InsertFirst(&head,11);

    Display(head);
    iRet = Count(head);

    printf("Number of nodes are : %d\n",iRet);
    
    return 0;
}