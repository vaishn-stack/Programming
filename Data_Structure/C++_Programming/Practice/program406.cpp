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
    this -> first = NULL;
    this -> iCount = 0;
}

void SinglyLL :: Display()
{
    PNODE temp = NULL;
    temp = this -> first;

    while(temp != NULL)
    {
        cout << "| " << temp -> data << " | ->" ;
        temp = temp -> next;
    }
    cout << "NULL" << endl; 
}

int SinglyLL :: Count()
{
    return this -> iCount;
}
        
void SinglyLL :: InsertFirst(int iNo)
{
    PNODE newn = NULL;

    newn = new NODE;

    newn -> data = iNo;
    newn -> next = NULL;

    if(this -> first == NULL)
    {
        this -> first = newn;
    }
    else
    {
        newn -> next = this -> first;
        this -> first = newn;
    }

    this -> iCount++;       // Important
}

void SinglyLL :: InsertLast(int iNo)
{
    PNODE newn = NULL;
    PNODE temp = NULL;

    newn = new NODE;

    newn -> data = iNo;
    newn -> next = NULL;

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
    }
    this -> iCount++;
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

    int iRet = 0;

    sobj.InsertFirst(51);
    sobj.InsertFirst(21);
    sobj.InsertFirst(11);

    sobj.Display();

    iRet = sobj.Count();

    cout << "Number of elements are : " << iRet << endl;

    sobj.InsertLast(101);
    sobj.InsertLast(111);
    sobj.InsertLast(121);

    sobj.Display();

    iRet = sobj.Count();

    cout << "Number of elements are : " << iRet << endl;

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