# include<iostream>
using namespace std;

#pragma pack(1)

struct node
{
    int data;
    struct node *next;
};

typedef struct node NODE;
typedef struct node* PNODE;

class SinglyLL
{
    private:            // Abstraction
        PNODE first;
        int iCount;

        public:
            SinglyLL()              
            {
                cout << "Inside Constructor\n";
                this -> first = NULL;
                this -> iCount = 0;
            }

    void Display()
    {

    }

    int Count()
    {
        return this -> iCount;
    }

    void InsertFirst(int iNo)
    {

    }

    void InsertLast(int iNo)
    {

    }

    void InsertAtPos(int iNo, int iPos)
    {

    }

    void DeleteFirst()
    {

    }

    void DeleteLast()
    {

    }

    void DeleteAtPos(int iPos)
    {

    }
};

int main()
{
    SinglyLL sobj;

    return 0;
}

/*
    sinlgyLL - singly linear LinkedList
    first is a pointer like (head) in c
    public - access specifier
    PNODE as a pointer their size will be 8 byte
    this use in c, c++ - (->) when we use characteristics are non static 
    Python madhe this chya jagi self. as use krta
    
*/