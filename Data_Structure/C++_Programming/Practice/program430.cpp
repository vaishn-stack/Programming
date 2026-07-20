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
{}

void SinglyCL :: DeleteFirst()
{}

void SinglyCL :: DeleteLast()
{}

void SinglyCL :: DeleteAtPos(int iPos)
{}

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

    return 0;
}

// while and for loop entry checking loop
// do while() - exit checking loop