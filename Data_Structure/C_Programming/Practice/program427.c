// Singly Circular LL

#include <stdio.h>
#include <stdlib.h>

# pragma pack(1)
struct node
{
    int data;
    struct node* next;
};

typedef struct node NODE;
typedef struct node* PNODE;
typedef struct node** PPNODE;

void Display(PNODE first, PNODE last)
{
    // filter
    if(first == NULL && last == NULL)
    {
        return;
    }

    do                                                              
    {
        printf("| %d | -> ", first->data);
        first = first->next;
    } while(first != last -> next);

    printf("\n");
}

int Count(PNODE first, PNODE last)
{
    int iCount = 0;

    if(first == NULL && last == NULL)
    {
        return iCount;
    }

    do                                                              
    {
        iCount++;
        first = first -> next;

    } while(first != last -> next);

    return iCount;

    printf("\n");
}

void InsertFirst(PPNODE first, PPNODE last, int iNo)
{
    PNODE newn = NULL;

    newn = (PNODE) malloc (sizeof(NODE));

    newn -> data = iNo;
    newn -> next = NULL;

    if(*first == NULL && *last == NULL)
    {
        *first = newn;
        *last = newn;
    }
    else
    {
        newn -> next = *first;
        *first = newn;
    }

    (*last)-> next = *first;
}

void InsertLast(PPNODE first, PPNODE last, int iNo)
{
    PNODE newn = NULL;

    newn = (PNODE) malloc (sizeof(NODE));

    newn -> data = iNo;
    newn -> next = NULL;

    if(*first == NULL && *last == NULL)
    {
        *first = newn;
        *last = newn;
    }
    else
    {
        (*last) -> next = newn;

        *last = (*last) -> next;            // *last = newn;
    }

    (*last)-> next = *first;
}

void InsertAtPos(PPNODE first, PPNODE last, int iNo, int iPos)
{
    int iCount = 0;
    int i = 0;

    PNODE newn = NULL;
    PNODE temp = NULL;

    iCount = Count(*first, *last);

    // filter
    if((iPos < 1) || (iPos > iCount + 1))
    {
        printf("Invalid Position \n");
        return;
    }

    if(iPos == 1)
    {
        InsertFirst(first,last,iNo);
    }
    else if(iPos == iCount + 1)
    {
        InsertLast(first,last,iNo);
    }
    else
    {
        temp = *first;

        newn = (PNODE) malloc (sizeof(NODE));

        newn -> data = iNo;
        newn -> next = NULL;

        for(i = 1; i < iPos - 1; i++)
        {
            temp = temp -> next;
        }

        newn -> next = temp -> next;
        temp -> next = newn; 
        (*last)-> next = *first;

    }
}

void DeleteFirst(PPNODE first, PPNODE last)
{
    if(*first == NULL && *last == NULL)
    {
        return;
    }
    else if(*first == *last)        // ((*first) -> next == NULL && (*last) -> next == NULL)
    {
        free(*first);

        *first = NULL;
        *last = NULL;
    }
    else
    {
        *first = (*first) -> next;
        free((*last) -> next);              // change zalay

        (*last)-> next = *first;
    }

}

void DeleteLast(PPNODE first, PPNODE last)
{
    PNODE temp = NULL;

    if(*first == NULL && *last == NULL)
    {
        return;
    }
    else if(*first == *last)        // ((*first) -> next == NULL && (*last) -> next == NULL)
    {
        free(*first);
        
        *first = NULL;
        *last = NULL;
    }
    else
    {
        temp = *first;

        while(temp -> next != *last)
        {
            temp = temp -> next;
        }

        free(*last);            // free(temp -> next);
        *last = temp;

        (*last)-> next = *first;
    }
    
}

void DeleteAtPos(PPNODE first, PPNODE last, int iPos)
{
    int iCount = 0;
    int i = 0;

    PNODE temp = NULL;
    PNODE target = NULL;

    iCount = Count(*first, *last);

    // filter
    if((iPos < 1) || (iPos > iCount))
    {
        printf("Invalid Position \n");
        return;
    }

    if(iPos == 1)
    {
        DeleteFirst(first,last);
    }
    else if(iPos == iCount)
    {
        DeleteLast(first,last);
    }
    else
    {
        temp = *first;

        for(i = 1; i < iPos - 1; i++)
        {
            temp = temp -> next;
        }

        target = temp -> next;
        temp -> next = target -> next;
        free(target);

        (*last)-> next = *first;

    }
}

int main()
{
    PNODE head = NULL;
    PNODE tail = NULL;

    int iRet = 0;

    InsertFirst(&head, &tail, 51);
    InsertFirst(&head, &tail, 21);
    InsertFirst(&head, &tail, 11);

    InsertLast(&head, &tail, 101);
    InsertLast(&head, &tail, 111);
    InsertLast(&head, &tail, 121);

    Display(head,tail);
    iRet = Count(head, tail);
    printf("Number of nodes are : %d\n",iRet);

    DeleteFirst(&head, &tail);

    Display(head,tail);
    iRet = Count(head, tail);
    printf("Number of nodes are : %d\n",iRet);

    DeleteLast(&head, &tail);
    
    Display(head,tail);
    iRet = Count(head, tail);
    printf("Number of nodes are : %d\n",iRet);

    InsertAtPos(&head, &tail, 105, 4);

    Display(head,tail);
    iRet = Count(head, tail);
    printf("Number of nodes are : %d\n",iRet);

    DeleteAtPos(&head, &tail, 4);

    Display(head,tail);
    iRet = Count(head, tail);
    printf("Number of nodes are : %d\n",iRet);

    return 0;
}

// while and for loop entry checking loop
// do while() - exit checking loop