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
{}

void Stack :: Push(int iNo)
{}              

int Stack :: Pop()
{
    return 0;
}               

int Stack :: Peep()
{
    return 0;
}               

void Stack :: Display()
{}

int Stack :: Count()
{
    return iCount;
}

int main()
{
    Stack sobj();

    return 0;
}