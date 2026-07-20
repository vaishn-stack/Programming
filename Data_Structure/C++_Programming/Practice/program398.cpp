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
    public:
        PNODE first;

        SinglyLL()
        {
            cout << "Inside Constructor\n";
            this -> first = NULL;
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
    this use in c, c++ - (->) when we use non static variables
    Python madhe this chya jagi self. as use krta
*/