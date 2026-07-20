// Singly Circular LL in c++

#include <iostream>
using namespace std;

# pragma pack(1)
struct node
{
    int data;
    struct node* next;
};

typedef struct node NODE;
typedef struct node* PNODE;

class SinglyCL
{
    private:
        PNODE first;
        PNODE last;
        int iCount;

        public:
            SinglyCL();

    void Display();
    int Count();

    void InsertFirst(int iNo);
    void InsertLast(int iNo);
    void InsertAtPos(int iNo, int iPos);

    void DeleteFirst();
    void DeleteLast();
    void DeleteAtPos(int iPos);
};

SinglyCL :: SinglyCL()
{
    cout << "Inside Constructor";
    this -> first = NULL;
    this -> last = NULL;
    this -> iCount = 0;
}

void SinglyCL :: Display()
{
    PNODE temp = NULL;
    temp = first;

    do
    {
        cout << "| " << temp -> data << " | ->" ;
        temp = temp -> next;

    }  while(temp != last->next);

    cout << "\n";
}

int SinglyCL :: Count()
{
    return iCount;
}

void SinglyCL :: InsertFirst(int iNo)
{
    PNODE newn = NULL;
    newn = new NODE;

    newn -> data = iNo;
    newn -> next = NULL;

    if(first == NULL && last == NULL)
    {
        first = newn;
        last = newn;
    }
    else
    {
        newn -> next = first;
        first = newn;
    }

    last -> next = first;
    iCount++;   
}

void SinglyCL :: InsertLast(int iNo)
{
    PNODE newn = NULL;
    newn = new NODE;

    newn -> data = iNo;
    newn -> next = NULL;

    if(first == NULL && last == NULL)
    {
        first = newn;
        last = newn;
    }
    else
    {
        last -> next = newn;
        last = newn;
    }

    last -> next = first;
    iCount++;   
}

void SinglyCL :: InsertAtPos(int iNo, int iPos)
{
    PNODE newn = NULL; 
    PNODE temp = NULL;

    int i = 0;

    newn = new NODE;

    newn -> data = iNo;
    newn -> next = NULL;

    if((iPos < 1) || (iPos > this -> iCount + 1))
    {
        cout<<"Invalid Position"<<endl;
        return;
    }

    if(iPos == 1)
    {
        this -> InsertFirst(iNo);
        return;
    }
    else if(iPos == this -> iCount + 1)
    {
        this -> InsertLast(iNo);
        return;
    }
    else
    {
        temp = first;

        for(i = 1; i < iPos - 1; i++)
        {
            temp = temp -> next;
        }

        newn -> next = temp -> next;
        temp -> next = newn;

        last -> next = first;
    }
    iCount++;
}

void SinglyCL :: DeleteFirst()
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
        first = first -> next;
        delete last -> next;
    }
    last -> next = first;
    iCount--;
}

void SinglyCL :: DeleteLast()
{
    PNODE temp = NULL;

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
        temp = first;
        while(temp -> next != last)
        {
            temp = temp -> next;
        }
        delete last;
        last = temp;
    }
    last -> next = first;
    iCount--;
}

void SinglyCL :: DeleteAtPos(int iPos)
{
    int i = 0;
    PNODE temp = NULL;
    PNODE target = NULL;

    if((iPos < 1) || (iPos > iCount))
    {
        cout<<"Invalid Position"<<endl;
        return;
    }

    if(iPos == 1)
    {
        this -> DeleteFirst();
        return;
    }
    else if(iPos == iCount)
    {
        this -> DeleteLast();
        return;
    }
    else
    {
        temp = first;

        for(i = 1; i < iPos - 1; i++)
        {
            temp = temp -> next;
        }
        target = temp -> next;
        temp -> next = target -> next;

        delete target;
        last -> next = first;
    }
    iCount--;
}

int main()
{
    SinglyCL sobj;

    int iRet = 0;

    sobj.InsertFirst(51);
    sobj.InsertFirst(21);
    sobj.InsertFirst(11);

    sobj.InsertLast(101);
    sobj.InsertLast(111);
    sobj.InsertLast(121);

    sobj.Display();
    iRet = sobj.Count();
    cout<<"Number of nodes are : "<< iRet <<endl;

    sobj.InsertAtPos(105,4);

    sobj.Display();
    iRet = sobj.Count();
    cout<<"Number of nodes are : "<< iRet <<endl;

    sobj.DeleteFirst();

    sobj.Display();
    iRet = sobj.Count();
    cout<<"Number of nodes are : "<< iRet <<endl;

    sobj.DeleteLast();

    sobj.Display();
    iRet = sobj.Count();
    cout<<"Number of nodes are : "<< iRet <<endl;

    sobj.DeleteAtPos(4);
    sobj.Display();
    iRet = sobj.Count();
    cout<<"Number of nodes are : "<< iRet <<endl;

    return 0;
}

// while and for loop entry checking loop
// do while() - exit checking loop