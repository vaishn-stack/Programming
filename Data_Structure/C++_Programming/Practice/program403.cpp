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
            SinglyLL();     // declaration

    void Display();

    int Count();

    void InsertFirst(int iNo);

    void InsertLast(int iNo);

    void InsertAtPos(int iNo, int iPos);

    void DeleteFirst();

    void DeleteLast();

    void DeleteAtPos(int iPos);
};


SinglyLL :: SinglyLL()            // definition  
{
    cout << "Inside Constructor\n";
    this -> first = NULL;
    this -> iCount = 0;
}

void SinglyLL :: Display()
{

}

int SinglyLL :: Count()
{
    return this -> iCount;
}
        
void SinglyLL :: InsertFirst(int iNo)
{

}

void SinglyLL :: InsertLast(int iNo)
{

}

void SinglyLL :: InsertAtPos(int iNo, int iPos)
{

}

void SinglyLL :: DeleteFirst()
{

}

void SinglyLL :: DeleteLast()
{

}

void SinglyLL :: DeleteAtPos(int iPos)
{

}

int main()
{
    SinglyLL sobj;

    return 0;
}

/*
    sinlgyLL - singly linear LinkedList in c++
    first is a pointer like (head) in c
    public - access specifier
    PNODE as a pointer their size will be 8 byte
    this use in c, c++ - (->) when we use characteristics are non static 
    Python madhe this chya jagi self. as use krta
    class madhe function chi declaration lihaychi ani tyachi definition outside class kraychi as per industry standard
    
    SinglyLL :: SinglyLL()     
    classname :: Constructor

    return value class name :: function name(Parameter)
        void       SinglyLL :: InsertFirst  (int iNo)
 */