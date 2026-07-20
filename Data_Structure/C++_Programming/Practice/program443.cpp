#include <iostream>
using namespace std;

#pragma pack(1)
struct node
{
    int data;
    struct node* next;
    struct node* prev;
};

typedef struct node NODE;
typedef struct node* PNODE;

#pragma pack(1)
class DoublyCL
{
    private:
        PNODE first;
        PNODE last;
        int iCount;

    public:
        DoublyCL();

    void Display();
    int Count();

    void InsertFirst(int iNo);
    void InsertLast(int iNo);
    void InsertAtPos(int iNo, int iPos);

    void DeleteFirst();
    void DeleteLast();
    void DeleteAtPos(int iPos);

};

DoublyCL :: DoublyCL()
{
    first = NULL;
    last = NULL;
    iCount = 0;
}

void DoublyCL :: Display()
{
    PNODE temp = first;

    if(first == NULL && last == NULL)
    {
        return;
    }

    do
    {
        cout<<"| "<<temp->data<<" | <=> ";
        temp = temp->next;
    }while(temp != last->next);
}

int DoublyCL :: Count()
{
    return iCount;
}

void DoublyCL :: InsertFirst(int iNo)
{
    PNODE newn = new NODE;

    newn->data = iNo;
    newn->next = NULL;
    newn->prev = NULL;

    if(first == NULL && last == NULL)
    {
        first = last = newn;
    }
    else
    {
        newn->next = first;
        first->prev = newn;
        first = newn;
    }

    last->next = first;
    first->prev = last;

    iCount++;
}

void DoublyCL :: InsertLast(int iNo)
{
    PNODE newn = new NODE;

    newn->data = iNo;
    newn->next = NULL;
    newn->prev = NULL;

    if(first == NULL && last == NULL)
    {
        first = last = newn;
    }
    else
    {
        last->next = newn;
        newn->prev = last;
        last = newn;
    }

    last->next = first;
    first->prev = last;

    iCount++;
}

void DoublyCL :: InsertAtPos(int iNo, int iPos)
{
    int i = 0;

    if((iPos < 1) || (iPos > iCount + 1))
    {
        cout<<"Invalid Position\n";
        return;
    }

    if(iPos == 1)
    {
        InsertFirst(iNo);
    }
    else if(iPos == iCount + 1)
    {
        InsertLast(iNo);
    }
    else
    {
        PNODE newn = new NODE;
        newn->data = iNo;
        newn->next = NULL;
        newn->prev = NULL;

        PNODE temp = first;

        for(i = 1; i < iPos - 1; i++)
        {
            temp = temp->next;
        }

        newn->next = temp->next;
        newn->prev = temp;

        temp->next->prev = newn;
        temp->next = newn;

        iCount++;
    }
}

void DoublyCL :: DeleteFirst()
{
    if(first == NULL && last == NULL)
    {
        return;
    }
    else if(first == last)
    {
        delete first;
        first = NULL;
        last = NULL;
    }
    else
    {
        first = first->next;
        delete first->prev;

        first->prev = last;
        last->next = first;
    }

    iCount--;
}

void DoublyCL :: DeleteLast()
{
    if(first == NULL && last == NULL)
    {
        return;
    }
    else if(first == last)
    {
        delete first;
        first = NULL;
        last = NULL;
    }
    else
    {
        last = last->prev;
        delete last->next;

        last->next = first;
        first->prev = last;
    }

    iCount--;
}

void DoublyCL :: DeleteAtPos(int iPos)
{
    int i = 0;

     if((iPos < 1) || (iPos > iCount))
    {
        cout<<"Invalid Position\n";
        return;
    }

    if(iPos == 1)
    {
        DeleteFirst();
    }
    else if(iPos == iCount)
    {
        DeleteLast();
    }
    else
    {
        PNODE temp = first;

        for(i = 1; i < iPos - 1; i++)
        {
            temp = temp -> next;
        }

        PNODE target = temp->next;

        temp->next = target->next;
        target->next->prev = temp;

        delete target;

        iCount--;
    }
}


int main()
{
    DoublyCL dobj;

    int iRet = 0;

    dobj.InsertFirst(51);
    dobj.InsertFirst(21);
    dobj.InsertFirst(11);

    dobj.InsertLast(101);
    dobj.InsertLast(111);
    dobj.InsertLast(121);

    dobj.Display();
    iRet = dobj.Count();
    cout<<"Number of nodes are : "<<iRet<<"\n";

    dobj.InsertAtPos(105,4);

    dobj.Display();
    iRet = dobj.Count();
    cout<<"Number of nodes are : "<<iRet<<"\n";

    dobj.DeleteFirst();

    dobj.Display();
    iRet = dobj.Count();
    cout<<"Number of nodes are : "<<iRet<<"\n";

    dobj.DeleteLast();

    dobj.Display();
    iRet = dobj.Count();
    cout<<"Number of nodes are : "<<iRet<<"\n";

    dobj.DeleteAtPos(4);

    dobj.Display();
    iRet = dobj.Count();
    cout<<"Number of nodes are : "<<iRet<<"\n";

    return 0;
}