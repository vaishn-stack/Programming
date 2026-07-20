// stack

#include<iostream>
using namespace std;

#pragma pack(1)
struct node
{
    int data;
    struct node *next;
};

class Stack
{
    private:
        struct node *first;
        int iCount;
    
    public:
        Stack();

        void Push(int iNo);                 // InsertFirst
        int Pop();                          // DeleteFirst
        int Peep();                         // DeleteFirst
        void Display();
        int Count();
};

Stack :: Stack()
{
    this -> first = NULL;
    this -> iCount = 0;
}

void Stack :: Push(int iNo)
{
    struct node *newn = NULL;

    newn = new struct node();

    newn -> data = iNo;
    newn -> next = NULL;

    newn -> next = first;           // Empty stack

    first = newn;

    iCount++;
}              

int Stack :: Pop()
{
    int iValue = 0;
    struct node *temp = NULL;

    if(first == NULL)
    {
        cout << "Stack is empty...\n";
        return -1;
    }
    else
    {
        iValue = first -> data;
        temp = first;

        first = first -> next;
        delete temp;

        iCount--;

        return iValue;
    }
}               

int Stack :: Peep()
{
    int iValue = 0;

    if(first == NULL)
    {
        cout << "Stack is empty...\n";
        return -1;
    }
    else
    {
        iValue = first -> data;

        return iValue;
    }
}               

void Stack :: Display()
{
    struct node *temp = NULL;

    temp = first;

    while(temp != NULL)
    {
        cout << "| " << temp -> data << " |\n";
        temp = temp -> next;
    }
}

int Stack :: Count()
{
    return iCount;
}

int main()
{
    Stack sobj;
    int iRet = 0;

    sobj.Push(11);
    sobj.Push(21);
    sobj.Push(51);
    sobj.Push(101);

    sobj.Display();
    iRet = sobj.Count();
    cout << "Elements of the stack are : "<< iRet << "\n";

    iRet = sobj.Pop();
    cout << "Popped element is : " << iRet << "\n";
    
    sobj.Display();
    iRet = sobj.Count();
    cout << "Elements of the stack are : "<< iRet << "\n";

    iRet = sobj.Peep();
    cout << "Peeped element is : " << iRet << "\n";
    
    sobj.Display();
    iRet = sobj.Count();
    cout << "Elements of the stack are : "<< iRet << "\n";

    return 0;
}