#include<stdio.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node *next;
};

typedef struct node NODE;
typedef struct node *PNODE;
typedef struct node **PPNODE;

void InsertFirst(PPNODE head, int No)
{
    PNODE newn = (PNODE)malloc(sizeof(NODE));

    newn->data = No;
    newn->next = NULL;

    if(*head == NULL)
    {
        *head = newn;
    }
    else
    {
        newn->next = *head;
        *head = newn;
    }
}

void Display(PNODE head)
{
    while(head != NULL)
    {
        printf("|%d| -> ", head->data);
        head = head->next;
    }
    printf("NULL\n");
}

int CountGreater(PNODE head, int X)
{
    int Count = 0;

    while(head != NULL)
    {
        if(head->data > X)
        {
            Count++;
        }

        head = head->next;
    }

    return Count;
}

int main()
{
    PNODE First = NULL;
    int iRet = 0;

    InsertFirst(&First,11);
    InsertFirst(&First,25);
    InsertFirst(&First,30);
    InsertFirst(&First,15);
    InsertFirst(&First,40);
    InsertFirst(&First,20);

    Display(First);

    iRet = CountGreater(First,20);

    printf("Elements greater than 20 are : %d\n", iRet);

    return 0;
}