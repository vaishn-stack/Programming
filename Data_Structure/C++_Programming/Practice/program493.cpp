// Queue

#include<iostream>
using namespace std;

#pragma pack(1)

template<class T>
struct node
{
    T data;
    struct node<T> *next;
};

template<class T>
class Queue
{
    private:
        node<T> *first;
        int iCount;
    
    public:
        Queue();
        void Enqueue(T No);                  // InsertLast
        T Dequeue();                          // DeleteFirst
        void Display();
        int Count();
};

template<class T>
Queue<T> :: Queue()
{
    this -> first = NULL;
    this -> iCount = 0;
}

template<class T>
void Queue<T> :: Enqueue(T No)
{
    node<T> *newn = NULL;
    node<T> *temp = NULL;

    newn = new node<T>();

    newn -> data = No;
    newn -> next = NULL;

    if(first == NULL)
    {
        first = newn;
    }
    else
    {
        temp = first;

        while(temp -> next != NULL)
        {
            temp = temp -> next;
        }
        temp -> next = newn;
    }
    
    iCount++;
}              

template<class T>
T Queue<T> :: Dequeue()
{
    T Value = 0;
    node<T> *temp = NULL;

    if(first == NULL)
    {
        cout << "Queue is empty...\n";
        return T();
    }
    else
    {
        Value = first -> data;
        temp = first;

        first = first -> next;
        delete temp;

        iCount--;

        return Value;
    }
}               

template<class T>
void Queue<T> :: Display()
{
    struct node<T> *temp = NULL;

    temp = first;

    while(temp != NULL)
    {
        cout << "| " << temp -> data << " |\n";
        temp = temp -> next;
    }
}

template<class T>
int Queue<T> :: Count()
{
    return iCount;
}

int main()
{
    Queue <int> sobj;
    int iRet = 0;

    sobj.Enqueue(11);
    sobj.Enqueue(21);
    sobj.Enqueue(51);
    sobj.Enqueue(101);

    sobj.Display();
    iRet = sobj.Count();
    cout << "Elements of the Queue are : "<< iRet << "\n";

    iRet = sobj.Dequeue();
    cout << "Removed element is : " << iRet << "\n";
    
    sobj.Display();
    iRet = sobj.Count();
    cout << "Elements of the Queue are : "<< iRet << "\n";
    
    return 0;
}