#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node *next;
};

typedef struct node NODE;
typedef struct node *PNODE;

bool Search(PNODE head, int iNo)
{
    while(head != NULL)
    {
        if(head->data == iNo)
        {
            return true;
        }
        head = head->next;
    }
    return false;
}

int main()
{
    PNODE head = NULL;
    bool bRet;

    head = (PNODE)malloc(sizeof(NODE));
    head->data = 10;
    head->next = NULL;

    head->next = (PNODE)malloc(sizeof(NODE));
    head->next->data = 20;
    head->next->next = NULL;

    head->next->next = (PNODE)malloc(sizeof(NODE));
    head->next->next->data = 30;
    head->next->next->next = NULL;

    bRet = Search(head,30);

    if(bRet == true)
    {
        printf("Element Found\n");
    }
    else
    {
        printf("Element Not Found\n");
    }

    return 0;
}