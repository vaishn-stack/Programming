#include<iostream>
using namespace std;

#pragma pack(1)

struct node
{
    int data;
    struct node *next;
    struct node *prev;          // $
};

typedef struct node NODE;
typedef struct node* PNODE;

class DoublyLL
{
    private:            
        PNODE first;
        int iCount;

        public:
            DoublyLL();         // $

    void Display();

    int Count();

    void InsertFirst(int iNo);

    void InsertLast(int iNo);

    void InsertAtPos(int iNo, int iPos);

    void DeleteFirst();

    void DeleteLast();

    void DeleteAtPos(int iPos);
};


DoublyLL :: DoublyLL()            
{
    this -> first = NULL;
    this -> iCount = 0;
}

void DoublyLL :: Display()
{
    PNODE temp = NULL;

    temp = this -> first;

    while(temp != NULL)
    {
        cout << "| " << temp -> data << " | <=> ";
        temp = temp -> next;
    }

    cout << "NULL" << endl;
}

int DoublyLL :: Count()
{
    return this -> iCount;
}
        
void DoublyLL :: InsertFirst(int iNo)
{
    PNODE newn = NULL;

    newn = new NODE;
 
    newn -> data = iNo;
    newn -> next = NULL;
    newn -> prev = NULL;        // $

    if(this -> first == NULL)
    {
        this -> first = newn;
    }
    else
    {
        newn -> next = this -> first;

        this -> first -> prev = newn;        // $

        this -> first = newn;
    }
    this -> iCount++;
}

void DoublyLL :: InsertLast(int iNo)
{
    PNODE newn = NULL;
    PNODE temp = NULL;

    newn = new NODE;
 
    newn -> data = iNo;
    newn -> next = NULL;
    newn -> prev = NULL;        // $

    if(this -> first == NULL)
    {
        this -> first = newn;
    }
    else
    {
        temp = this -> first;

        while(temp -> next != NULL)
        {
            temp = temp -> next;
        }

        temp -> next = newn;
        newn -> prev = temp;        // $
    }
    this -> iCount++;
}

void DoublyLL :: InsertAtPos(int iNo, int iPos)
{
    int i = 0;

    PNODE newn = NULL;
    PNODE temp = NULL; 

    newn = new NODE;

    newn -> data = iNo;
    newn -> next = NULL;
    newn -> prev = NULL;

    if((iPos < 1) || (iPos > iCount + 1))
    {
        cout << "Invalid Position \n";
        return;
    }

    if(iPos == 1)
    {
        this -> InsertFirst(iNo);
    }
    else if(iPos == this -> iCount + 1)
    {
        this -> InsertLast(iNo);
    }
    else
    {
        temp = this -> first;

        newn -> next = NULL;
        newn -> prev = NULL;            // $

        for(int i = 1; i < iPos - 1; i++)
        {
            temp = temp -> next;
        }

        newn -> next = temp -> next;
        temp -> next -> prev = newn;        // $
        temp -> next = newn;
        newn -> prev = temp;                // $

        this -> iCount++;
    }
}

void DoublyLL :: DeleteFirst()
{

}

void DoublyLL :: DeleteLast()
{

}

void DoublyLL :: DeleteAtPos(int iPos)
{
    PNODE temp = NULL;

    if((iPos < 1) || (iPos > iCount))
    {
        cout << "Invalid Position \n";
        return;
    }

    if(iPos == 1)
    {
        this -> DeleteFirst();
    }
    else if(iPos == this -> iCount)
    {
        this -> DeleteLast();
    }
    else
    {
        temp = this -> first;

        for(int i = 1; i < iPos - 1; i++)
        {
            temp = temp -> next;
        }

        this -> iCount--;
    }
}

int main()
{
    DoublyLL dobj;
    int iRet = 0;

    dobj.InsertFirst(51);
    dobj.InsertFirst(21);
    dobj.InsertFirst(11);

    dobj.Display();
    iRet = dobj.Count();
    cout << "Number of Linked List elements are : " << iRet << endl;

    dobj.InsertLast(101);
    dobj.InsertLast(111);
    dobj.InsertLast(121);

    dobj.Display();
    iRet = dobj.Count();
    cout << "Number of Linked List elements are : " << iRet << endl;

    dobj.InsertAtPos(105,4);

    dobj.Display();
    iRet = dobj.Count();
    cout << "Number of Linked List elements are : " << iRet << endl;

    return 0;
}

/*
    DoublyLL - doubly linear LinkedList in c++
 */