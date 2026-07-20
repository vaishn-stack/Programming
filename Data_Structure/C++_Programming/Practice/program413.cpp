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

}

void DoublyLL :: InsertLast(int iNo)
{

}

void DoublyLL :: InsertAtPos(int iNo, int iPos)
{

}

void DoublyLL :: DeleteFirst()
{

}

void DoublyLL :: DeleteLast()
{

}

void DoublyLL :: DeleteAtPos(int iPos)
{

}

int main()
{
    DoublyLL dobj;
    int iRet = 0;

    cout << "Size is : " << sizeof(NODE) << endl;
    dobj.Display();

    iRet = dobj.Count();

    return 0;
}

/*
    DoublyLL - doubly linear LinkedList in c++
 */