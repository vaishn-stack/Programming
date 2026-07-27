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
    PNODE newn = NULL;

    newn = (PNODE)malloc(sizeof(NODE));

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

void DisplayEven(PNODE head)
{
    while(head != NULL)
    {
        if((head->data % 2) == 0)
        {
            printf("%d\t", head->data);
        }
        Head = head->next;
    }

    printf("\n");
}

int main()
{
    PNODE First = NULL;

    InsertFirst(&First,51);
    InsertFirst(&First,40);
    InsertFirst(&First,30);
    InsertFirst(&First,21);
    InsertFirst(&First,10);

    Display(First);

    printf("Even Elements are : ");
    DisplayEven(First);

    return 0;
}