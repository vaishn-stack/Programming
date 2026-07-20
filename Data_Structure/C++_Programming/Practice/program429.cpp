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

void Display()
{}

int Count()
{}

void InsertFirst(int iNo)
{}

void InsertLast(int iNo)
{}

void InsertAtPos(int iNo, int iPos)
{}

void DeleteFirst()
{}

void DeleteLast()
{}

void DeleteAtPos(int iPos)
{}

int main()
{
    SinglyCL sobj;

    return 0;
}

// while and for loop entry checking loop
// do while() - exit checking loop