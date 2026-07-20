// 370 template of ds program

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

}

int Count(PNODE first)
{
    return 0;
}

void InsertFirst(PPNODE first, int iNo)         // dynamically grown language 
{
    PNODE newn = NULL;

    newn = (PNODE) malloc (sizeof(NODE));       // Pnode pointer krto newn la as a pointer

    newn -> data = iNo;                         // eg - shirtavr no lihayla ae

    newn -> next = NULL;                        // eg - haath point krto duaryala (pocket madhe haath ghalto)

    // Linked List is empty
    if(*first == NULL)                         // == chya aivayji = vaprl tr NULL head la initialize hoto , head will be NULL
    {
        *first = newn;
    }
    else                                       // LL contains at least 1 node
    {
        newn -> next = *first;                 // eg - teacher chya dokyat jo mulga hota tyachya aivayji dusra mulga first no la initialise zala

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

    InsertFirst(&head,101);
    InsertFirst(&head,51);
    InsertFirst(&head,21);
    InsertFirst(&head,11);

    return 0;
}