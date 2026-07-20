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
    while(first != NULL)                     // Type1
    {
        printf("| %d | -> ",first -> data);
        first = first -> next;
    }

    printf("NULL\n");
}

int Count(PNODE first)
{
    int iCount = 0;

    while(first != NULL)                        // Type 1
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

    PNODE temp = NULL;

    newn = (PNODE) malloc (sizeof(NODE));       

    newn -> data = iNo;  
    newn -> next = NULL;


    // Linked List is empty
    if(*first == NULL)                        
    {
        *first = newn;
    }
    else                                       // LL contains at least 1 node
    {
        temp = *first;

        while(temp -> next != NULL)             // Type 2
        {
            temp = temp -> next;
        }

        temp -> next = newn;            // eg. mulacha haath khalich hota
    }
}

void InsertAtPos(PPNODE first, int iNo, int iPos)
{
    int iCount = 0;
    int i = 0;

    PNODE newn = NULL;
    PNODE temp = NULL;

    iCount = Count(*first);  // call by value

    // filter
    if((iPos < 1) || (iPos > iCount + 1))
    {
        printf("Invalid position\n");
        return;
    }

    if(iPos == 1)
    {
        InsertFirst(first,iNo);
    }
    else if(iPos == iCount + 1)
    {
        InsertLast(first,iNo);
    }
    else
    {
        newn = (PNODE) malloc (sizeof(NODE));

        newn -> data = iNo;
        newn -> next = NULL;

        temp = *first;

        for(i = 1; i < iPos - 1; i++)
        {
            temp = temp -> next;
        }

        newn -> next = temp -> next;
        temp -> next = newn;
    }
}

void DeleteFirst(PPNODE first)
{
    PNODE temp = NULL;

    if(*first == NULL)                      // LL is empty
    {
        return;
    }
    else if((*first) -> next == NULL)         // LL contains one node
    {
        free(*first);
        *first = NULL;
    }
    else                                    // LL contains more than 1 nodes
    {
        temp = *first;

        *first = (*first) -> next;          // arrow chya adhi * lagt asel tr tyla () madhe takaycha

        free(temp);
    }
}

void DeleteLast(PPNODE first)
{
    PNODE temp = NULL;

    if(*first == NULL)                      // LL is empty
    {
        return;
    }
    else if((*first) -> next == NULL)         // LL contains one node
    {
        free(*first);
        *first = NULL;
    }
    else                                    // LL contains more than 1 nodes
    {
        temp = *first;

        while(temp -> next -> next != NULL)      // Type 3
        {
            temp = temp -> next;
        }

        free(temp ->  next);

        temp -> next = NULL;
    }
}

void DeleteAtPos(PPNODE first,int iPos)
{
    int iCount = 0;

    iCount = Count(*first);  // call by value

    // filter
    if((iPos < 1) || (iPos > iCount))
    {
        printf("Invalid position\n");
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
        // newn = (PNODE) malloc (sizeof(NODE));

        // newn -> data = iNo;
        // newn -> next = NULL;

        // temp = *first;

        // for(i = 1; i < iPos - 1; i++)
        // {
        //     temp = temp -> next;
        // }
        
        // newn -> next = temp -> next;
        // temp -> next = newn;
    }
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

    InsertLast(&head,111);
    InsertLast(&head,121);

    Display(head);
    iRet = Count(head);

    printf("Number of nodes are : %d\n",iRet);

    DeleteFirst(&head);
    
    Display(head);
    iRet = Count(head);

    printf("Number of nodes are : %d\n",iRet);

    DeleteLast(&head);

    Display(head);
    iRet = Count(head);

    printf("Number of nodes are : %d\n",iRet);
    
    InsertAtPos(&head,105,4);
    
    Display(head);
    iRet = Count(head);

    printf("Number of nodes are : %d\n",iRet);

    return 0;
}