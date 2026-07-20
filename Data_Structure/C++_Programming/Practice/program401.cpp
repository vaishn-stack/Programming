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
typedef struct node** PPNODE;

class SinglyLL
{
    private:
        PNODE first;
        int iCount;

        public:
            SinglyLL()              
            {
                cout << "Inside Constructor\n";
                this -> first = NULL;
                this -> iCount = 0;
            }
};

int main()
{
    SinglyLL sobj;

    // 5 nodes

    sobj.first = NULL;      // Error
    sobj.iCount = 15;       // Error
    
    return 0;
}

/*
    sinlgyLL - singly linear LinkedList
    first is a pointer like (head) in c
    public - access specifier
    PNODE as a pointer their size will be 8 byte
    this use in c, c++ - (->) when we use non static variables
    Python madhe this chya jagi self. as use krta
    sobj.first = NULL;     sobj.iCount = 15; --> change their Access specifier to creating the object and insert data
*/