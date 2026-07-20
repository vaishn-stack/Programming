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
typedef struct node **PPNODE;

void Display(PNODE first)
{
    printf("\nNULL <=> ");

    while(first != NULL)                // call by value
    {
        printf("| %d | <=> ",first -> data);
        first = first -> next;
    }
    printf("NULL\n");
}

int Count(PNODE first)                  // abstract function
{
    int iCount = 0;

    while(first != NULL)
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
    newn -> prev = NULL;                // $

    if(NULL == *first)                  // LL is empty
    {
        *first = newn;
    }
    else
    {
        newn -> next = *first;
        (*first) -> prev = newn;          // $
        *first = newn;
    }

}

void InsertLast(PPNODE first, int iNo)
{
    PNODE newn = NULL;
    PNODE temp = NULL;

    newn = (PNODE) malloc (sizeof(NODE));

    newn -> data = iNo;
    newn -> next = NULL;
    newn -> prev = NULL;                // $

    if(NULL == *first)                  // LL contains one node
    {
        *first = newn;
    }
    else
    {
        temp = *first;

        while(temp -> next != NULL)
        {
            temp = temp -> next;
        }
        temp -> next = newn;
        newn -> prev = temp;            // $
    }
}

void InsertAtPos(PPNODE first, int iNo, int iPos)
{
    int iCount = 0;
    int i = 0;

    PNODE newn = NULL;
    PNODE temp = NULL;

    iCount = Count(*first);

    // filter
    if((iPos < 1) || (iPos > iCount + 1))
    {
        printf("Invalid Position\n");
        return;
    }

    if(iPos == 1)
    {
        InsertFirst(first, iNo);
    }
    else if(iPos == iCount + 1)
    {
        InsertLast(first, iNo);
    }
    else
    {
        temp = *first;

        newn = (PNODE) malloc (sizeof(PNODE));

        newn -> data = iNo;
        newn -> next = NULL;
        newn -> prev = NULL;                // $

        for(i = 1; i < iPos - 1; i++)
        {
            temp = temp -> next;
        }

        newn -> next = temp -> next;
        temp -> next -> prev = newn;        // $
        temp -> next = newn;
        newn -> prev = temp;                // $

    }
}

void DeleteFirst(PPNODE first)
{
    if(*first == NULL)
    {
        return;
    }
    else if((*first) -> next == NULL)
    {
        free(*first);
        *first = NULL;
    }
    else
    {
        *first = (*first) -> next;       

        free((*first) -> prev);                 // $
        (*first) -> prev = NULL;                // $
    }
}

void DeleteLast(PPNODE first)
{
    PNODE temp = NULL;

    if(NULL == *first)
    {
        return;
    }
    else if((*first) -> next == NULL)
    {
        free(*first);
        *first = NULL;
    }
    else
    {
        temp = *first;

        while(temp -> next -> next != NULL)
        {
            temp = temp -> next;
        }
        free(temp -> next);
        temp -> next = NULL;
    }
}

void DeleteAtPos(PPNODE first, int iPos)
{
    
    int iCount = 0;
    int i = 0;

    PNODE temp = NULL;

    iCount = Count(*first);

    // filter
    if((iPos < 1) || (iPos > iCount))
    {
        printf("Invalid Position\n");
        return;
    }

    if(iPos == 1)
    {
        DeleteFirst(first);
    }
    else if(iPos == iCount)
    {
        DeleteLast(first);
    }
    else
    {
        temp = *first;

        for(i = 1; i < iPos - 1; i++)
        {
            temp = temp -> next;
        }

        temp -> next = temp -> next -> next;
        free(temp -> next -> prev);                 // $
        temp -> next -> prev = temp;                // $
    }
}


int main()
{
    PNODE head = NULL;
    int iRet = 0;

    InsertFirst(&head,51);
    InsertFirst(&head,21);
    InsertFirst(&head,11);

    InsertLast(&head,101);
    InsertLast(&head,111);
    InsertLast(&head,121);
    InsertLast(&head,151);

    Display(head);

    iRet = Count(head);

    printf("Number of elements are : %d \n",iRet);

    DeleteFirst(&head);

    Display(head);

    iRet = Count(head);

    printf("Number of elements are : %d \n",iRet);

    DeleteLast(&head);

    Display(head);

    iRet = Count(head);

    printf("Number of elements are : %d \n",iRet);

    InsertAtPos(&head,105,4);

    Display(head);

    iRet = Count(head);

    printf("Number of elements are : %d \n",iRet);

    DeleteAtPos(&head,4);

    Display(head);

    iRet = Count(head);

    printf("Number of elements are : %d \n",iRet);

    return 0;
}